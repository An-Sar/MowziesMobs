package com.bobmowzie.mowziesmobs.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribeHunter;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribePlayer;
import com.bobmowzie.mowziesmobs.server.entity.wroughtnaut.EntityWroughtnaut;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.server.entity.foliaath.EntityFoliaath;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribesman;
import com.bobmowzie.mowziesmobs.server.item.ItemBarakoaMask;
import com.bobmowzie.mowziesmobs.server.item.ItemHandler;
import com.bobmowzie.mowziesmobs.server.message.MessagePlayerSolarBeam;
import com.bobmowzie.mowziesmobs.server.message.MessagePlayerSummonSunstrike;
import com.bobmowzie.mowziesmobs.server.potion.PotionHandler;
import com.bobmowzie.mowziesmobs.server.property.MowziePlayerProperties;

public enum ServerEventHandler {
    INSTANCE;

    private final static int SUNSTRIKE_COOLDOWN = 65;
    private final static int SOLARBEAM_COOLDOWN = 130;

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {
        if (event.getWorld().isRemote) {
            return;
        }
        Entity entity = event.getEntity();
        if (entity instanceof EntityZombie) {
            ((EntityCreature) entity).tasks.addTask(2, new EntityAIAttackMelee((EntityCreature) entity, 1.0D, false)); // EntityFoliaath.class
            ((EntityCreature) entity).targetTasks.addTask(2, new EntityAINearestAttackableTarget((EntityCreature) entity, EntityFoliaath.class, 0, true, false, null));

            ((EntityCreature) entity).tasks.addTask(2, new EntityAIAttackMelee((EntityCreature) entity, 1.0D, false)); // EntityTribesman.class
            ((EntityCreature) entity).targetTasks.addTask(2, new EntityAINearestAttackableTarget((EntityCreature) entity, EntityTribesman.class, 0, true, false, null));
        }
        if (entity instanceof EntityOcelot) {
            ((EntityCreature) entity).tasks.addTask(3, new EntityAIAvoidEntity((EntityCreature) entity, EntityFoliaath.class, 6.0F, 1.0D, 1.2D));
        }
        if (entity instanceof EntityAnimal) {
            ((EntityCreature) entity).tasks.addTask(3, new EntityAIAvoidEntity((EntityCreature) entity, EntityTribesman.class, 6.0F, 1.0D, 1.2D));
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            return;
        }
        EntityPlayer player = event.player;
        MowziePlayerProperties property = EntityPropertiesHandler.INSTANCE.getProperties(player, MowziePlayerProperties.class);
        property.update();
        if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() == ItemHandler.INSTANCE.wroughtAxe) {
            if (property.getTick() > 0) {
                property.decrementTime();
            }
            if (property.getTick() == MowziePlayerProperties.SWING_HIT_TICK && !player.worldObj.isRemote) {
                float damage = 7;
                boolean hit = false;
                float range = 4;
                float knockback = 1.2F;
                float arc = 100;
                List<EntityLivingBase> entitiesHit = getEntityLivingBaseNearby(player, range, 2, range, range);
                for (EntityLivingBase entityHit : entitiesHit) {
                    float entityHitAngle = (float) ((Math.atan2(entityHit.posZ - player.posZ, entityHit.posX - player.posX) * (180 / Math.PI) - 90) % 360);
                    float entityAttackingAngle = player.rotationYaw % 360;
                    if (entityHitAngle < 0) {
                        entityHitAngle += 360;
                    }
                    if (entityAttackingAngle < 0) {
                        entityAttackingAngle += 360;
                    }
                    float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
                    float entityHitDistance = (float) Math.sqrt((entityHit.posZ - player.posZ) * (entityHit.posZ - player.posZ) + (entityHit.posX - player.posX) * (entityHit.posX - player.posX));
                    if (entityHitDistance <= range && entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2 || entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2) {
                        entityHit.attackEntityFrom(DamageSource.causeMobDamage(player), damage);
                        entityHit.motionX *= knockback;
                        entityHit.motionZ *= knockback;
                        hit = true;
                    }
                }
                if (hit) {
                    player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.3F, 0.5F);
                }
            }
        }
        if (property.untilSunstrike > 0) {
            property.untilSunstrike--;
        }
        if (event.side == Side.CLIENT) {
            return;
        }
        ItemStack headArmorStack = event.player.inventory.armorItemInSlot(3);
        if (headArmorStack == null) {
            return;
        }
        Item headItemStack = headArmorStack.getItem();
        if (headItemStack instanceof ItemBarakoaMask) {
            ItemBarakoaMask mask = (ItemBarakoaMask) headItemStack;
            event.player.addPotionEffect(new PotionEffect(mask.getPotion(), 0, 0));
        }

        List<EntityTribePlayer> pack = property.tribePack;
        for (int i = 0; i < pack.size(); i++) {
            pack.get(i).index = i;
        }
        if (!player.worldObj.isRemote && pack != null) {
            float theta = (2 * (float) Math.PI / pack.size());
            for (int i = 0; i < pack.size(); i++) {
                EntityTribePlayer tribePlayer = pack.get(i);
                if (tribePlayer.getAttackTarget() == null) {
                    tribePlayer.getNavigator().tryMoveToXYZ(player.posX + property.tribePackRadius * MathHelper.cos(theta * i), player.posY, player.posZ + property.tribePackRadius * MathHelper.sin(theta * i), 0.45);
                    if (player.getDistanceToEntity(tribePlayer) > 20) {
                        tribePlayer.setPosition(player.posX + property.tribePackRadius * MathHelper.cos(theta * i), player.posY, player.posZ + property.tribePackRadius * MathHelper.sin(theta * i));
                    }
                }
            }
        }
    }

    private List<EntityLivingBase> getEntityLivingBaseNearby(EntityLivingBase user, double distanceX, double distanceY, double distanceZ, double radius) {
        List<Entity> list = user.worldObj.getEntitiesWithinAABBExcludingEntity(user, user.getEntityBoundingBox().expand(distanceX, distanceY, distanceZ));
        ArrayList<EntityLivingBase> nearEntities = list.stream().filter(entityNeighbor -> entityNeighbor instanceof EntityLivingBase && user.getDistanceToEntity(entityNeighbor) <= radius).map(entityNeighbor -> (EntityLivingBase) entityNeighbor).collect(Collectors.toCollection(ArrayList::new));
        return nearEntities;
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickEmpty event) {
        EntityPlayer player = event.getEntityPlayer();
        if (event.getWorld().isRemote && player.inventory.getCurrentItem() == null && player.isPotionActive(PotionHandler.INSTANCE.sunsBlessing) && EntityPropertiesHandler.INSTANCE.getProperties(player, MowziePlayerProperties.class).untilSunstrike <= 0) {
            MowziePlayerProperties property = EntityPropertiesHandler.INSTANCE.getProperties(player, MowziePlayerProperties.class);
            if (player.isSneaking()) {
                MowziesMobs.NETWORK_WRAPPER.sendToServer(new MessagePlayerSolarBeam());
                property.untilSunstrike = SOLARBEAM_COOLDOWN;
            } else {
                MowziesMobs.NETWORK_WRAPPER.sendToServer(new MessagePlayerSummonSunstrike());
                property.untilSunstrike = SUNSTRIKE_COOLDOWN;
            }
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
        EntityPlayer player = event.getEntityPlayer();
        if (event.getWorld().isRemote && player.inventory.getCurrentItem() == null && player.isPotionActive(PotionHandler.INSTANCE.sunsBlessing) && EntityPropertiesHandler.INSTANCE.getProperties(player, MowziePlayerProperties.class).untilSunstrike <= 0) {
            MowziePlayerProperties property = EntityPropertiesHandler.INSTANCE.getProperties(player, MowziePlayerProperties.class);
            if (player.isSneaking()) {
                MowziesMobs.NETWORK_WRAPPER.sendToServer(new MessagePlayerSolarBeam());
                property.untilSunstrike = SOLARBEAM_COOLDOWN;
            } else {
                MowziesMobs.NETWORK_WRAPPER.sendToServer(new MessagePlayerSummonSunstrike());
                property.untilSunstrike = SUNSTRIKE_COOLDOWN;
            }
        }
    }

    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent event) {
        if (!(event.getTarget() instanceof EntityLivingBase)) return;
        MowziePlayerProperties property = EntityPropertiesHandler.INSTANCE.getProperties(event.getEntity(), MowziePlayerProperties.class);
        if (event.getTarget() instanceof EntityTribePlayer) return;
        for (int i = 0; i < property.getPackSize(); i++) property.tribePack.get(i).setAttackTarget((EntityLivingBase) event.getTarget());
    }

    @SubscribeEvent
    public void onChat(ServerChatEvent event) {
        String[] words = event.getMessage().split("\\W");
        boolean dap = false;
        for (String word : words) {
            if (word.equalsIgnoreCase("dap")) {
                dap = true;
                break;
            }
        }
        if (dap) {
            final float dist = 20.5F;
            EntityPlayerMP player = event.getPlayer();
            AxisAlignedBB bounds = player.getEntityBoundingBox().expandXyz(dist);
            List<EntityWroughtnaut> wroughtnauts = player.worldObj.getEntitiesWithinAABB(EntityWroughtnaut.class, bounds);
            for (EntityWroughtnaut wroughtnaut : wroughtnauts) {
                if (wroughtnaut.isActive() && wroughtnaut.getDistanceSq(player.posX, player.posY, player.posZ) <= dist * dist) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(wroughtnaut, EntityWroughtnaut.DAP_ANIMATION);
                }
            }
        }
    }
}
