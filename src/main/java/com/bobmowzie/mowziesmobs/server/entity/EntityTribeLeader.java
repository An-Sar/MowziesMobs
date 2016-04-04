package com.bobmowzie.mowziesmobs.server.entity;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.client.model.tools.ControlledAnimation;
import com.bobmowzie.mowziesmobs.client.model.tools.MathUtils;
import com.bobmowzie.mowziesmobs.server.ai.BarakoaAttackTargetAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.*;
import com.bobmowzie.mowziesmobs.server.item.ItemTestStructure;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTribeLeader extends MowzieEntity implements LeaderSunstrikeImmune {
    private int direction = 0;
    public ControlledAnimation legsUp = new ControlledAnimation(15);
    public ControlledAnimation angryEyebrow = new ControlledAnimation(5);
    private boolean blocksByFeet = true;
    public int whichDialogue = 0;
    private int timeUntilSunstrike = 0;
    private int timeUntilLaser = 0;
    private int timeUntilBarakoa = 0;
    public int barakoaSpawnCount = 0;

    private static final int MAX_HEALTH = 150;

    private static final int SUNSTRIKE_PAUSE_MAX = 40;
    private static final int SUNSTRIKE_PAUSE_MIN = 15;
    private static final int LASER_PAUSE = 150;
    private static final int BARAKOA_PAUSE = 150;

    private boolean pacified = false;

    public static final Animation DIE_ANIMATION = Animation.create(130);
    public static final Animation HURT_ANIMATION = Animation.create(13);
    public static final Animation BELLY_ANIMATION = Animation.create(40);
    public static final Animation TALK_ANIMATION = Animation.create(80);
    public static final Animation SUNSTRIKE_ANIMATION = Animation.create(15);
    public static final Animation ATTACK_ANIMATION = Animation.create(30);
    public static final Animation SPAWN_ANIMATION = Animation.create(20);
    public static final Animation SOLAR_BEAM_ANIMATION = Animation.create(100);

    public EntityTribeLeader(World world) {
        super(world);
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(4, new BarakoaAttackTargetAI(this, EntityPlayer.class, 0, false));
        this.tasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, false));
        this.tasks.addTask(2, new AnimationAI<>(this, BELLY_ANIMATION, false));
        this.tasks.addTask(2, new AnimationAI<>(this, TALK_ANIMATION, false));
        this.tasks.addTask(2, new AnimationSunStrike<>(this, SUNSTRIKE_ANIMATION));
        this.tasks.addTask(2, new AnimationRadiusAttack<>(this, ATTACK_ANIMATION, 5, 5, 4.5f, 12));
        this.tasks.addTask(2, new AnimationSpawnBarakoa<>(this, SPAWN_ANIMATION));
        this.tasks.addTask(2, new AnimationSolarBeam<>(this, SOLAR_BEAM_ANIMATION));
        this.tasks.addTask(3, new AnimationTakeDamage<>(this));
        this.tasks.addTask(1, new AnimationDieAI<>(this));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityTribesman.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.setSize(1.5f, 2.4f);
        if (getDirection() == 0) {
            this.setDirection(rand.nextInt(4) + 1);
        }
    }

    @Override
    public float getEyeHeight() {
        return 1.4f;
    }

    public EntityTribeLeader(World world, int direction) {
        this(world);
        this.setDirection(direction);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MAX_HEALTH);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected String getLivingSound() {
        if (getAnimation() == NO_ANIMATION) {
            if (getAttackTarget() == null) {
                int soundType = MathHelper.getRandomIntegerInRange(this.rand, 1, 10);
                if (soundType < 7) {
                    this.playSound("mowziesmobs:barakoTalk" + soundType, 1.4F, 1.0F);
                    this.setWhichDialogue(soundType);
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, TALK_ANIMATION);
                }
            } else {
                int soundType = MathHelper.getRandomIntegerInRange(rand, 1, 10);
                if (soundType < 7) {
                    this.playSound("mowziesmobs:barakoAngry" + soundType, 1.4F, 1.0F);
//                    setWhichDialogue(soundType);
//                    AnimationHandler.INSTANCE.sendAnimationMessage(this, 3);
                }
            }
        }
        return null;
    }

    @Override
    protected String getHurtSound() {
        return "mowziesmobs:barakoHurt";
    }

    @Override
    protected String getDeathSound() {
        this.playSound("mowziesmobs:barakoDie", 1.4f, 1);
        return null;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (pacified) {
            setAttackTarget(null);
        }
        if (ticksExisted == 1) {
            direction = getDirection();
        }
        this.repelEntities(2.2f, 2.5f, 2.2f, 2.2f);
        this.rotationYaw = (direction - 1) * 90;
        this.renderYawOffset = rotationYaw;
        this.posX = prevPosX;
        this.posZ = prevPosZ;

        if (getAttackTarget() != null) {
            EntityLivingBase target = getAttackTarget();
            this.setAngry(1);
            float entityHitAngle = (float) ((Math.atan2(target.posZ - posZ, target.posX - posX) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = rotationYaw % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = Math.abs(entityHitAngle - entityAttackingAngle);
            if (getAnimation() == NO_ANIMATION && getHealth() <= 70 && timeUntilLaser <= 0 && (entityRelativeAngle < 60 || entityRelativeAngle > 300) && rand.nextInt(50) == 0) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, SOLAR_BEAM_ANIMATION);
                timeUntilLaser = LASER_PAUSE;
            } else if (getAnimation() == NO_ANIMATION && targetDistance <= 5) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
            } else if (getAnimation() == NO_ANIMATION && rand.nextInt(50) == 0 && targetDistance > 5 && timeUntilBarakoa <= 0) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, SPAWN_ANIMATION);
                timeUntilBarakoa = BARAKOA_PAUSE;
            } else if (getAnimation() == NO_ANIMATION && timeUntilSunstrike <= 0 && targetDistance > 5) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, SUNSTRIKE_ANIMATION);
                timeUntilSunstrike = getTimeUntilSunstrike();
            }
        } else {
            if (!worldObj.isRemote) {
                this.setAngry(0);
            }
        }

        if (ticksExisted % 20 == 0) {
            blocksByFeet = checkBlocksByFeet();
        }

        if (blocksByFeet) {
            legsUp.increaseTimer();
        } else {
            legsUp.decreaseTimer();
        }

        if (getAngry() == 1) {
            angryEyebrow.increaseTimer();
        } else {
            angryEyebrow.decreaseTimer();
        }

        if (getAnimation() == NO_ANIMATION && getAttackTarget() == null && rand.nextInt(200) == 0) {
            AnimationHandler.INSTANCE.sendAnimationMessage(this, BELLY_ANIMATION);
        }

        if (getAnimation() == BELLY_ANIMATION && (getAnimationTick() == 9 || getAnimationTick() == 29)) {
            this.playSound("mowziesmobs:barakoBelly", 1.4f, 1f);
        }

        if (getAnimation() == TALK_ANIMATION && getAnimationTick() == 1) {
            whichDialogue = getWhichDialogue();
        }

        if (getAnimation() == ATTACK_ANIMATION) {
            rotationYawHead = rotationYaw;
            if (getAnimationTick() == 1) {
                this.playSound("mowziesmobs:barakoBurst", 1.5f, 1.5f);
            }
            if (getAnimationTick() == 10) {
                if (worldObj.isRemote) {
                    spawnExplosionParticles(30);
                }
                this.playSound("mowziesmobs:barakoAttack", 1.5f, 0.9f);
            }
            if (getAnimationTick() <= 6 && worldObj.isRemote) {
                int particleCount = 8;
                while (--particleCount != 0) {
                    double radius = 2f;
                    double yaw = rand.nextFloat() * 2 * Math.PI;
                    double pitch = rand.nextFloat() * 2 * Math.PI;
                    double ox = radius * Math.sin(yaw) * Math.sin(pitch);
                    double oy = radius * Math.cos(pitch);
                    double oz = radius * Math.cos(yaw) * Math.sin(pitch);
                    double offsetX = -0.3 * Math.sin(rotationYaw * Math.PI / 180);
                    double offsetZ = -0.3 * Math.cos(rotationYaw * Math.PI / 180);
                    double offsetY = 1;
                    MowziesMobs.PROXY.spawnOrbFX(worldObj, posX + ox + offsetX, posY + offsetY + oy, posZ + oz + offsetZ, posX + offsetX, posY + offsetY, posZ + offsetZ, 6);
                }
            }
        }
        if (!worldObj.isRemote && getAttackTarget() == null && getAnimation() != SOLAR_BEAM_ANIMATION) {
            heal(0.2f);
        }
        if (timeUntilSunstrike > 0) {
            timeUntilSunstrike--;
        }
        if (timeUntilLaser > 0) {
            timeUntilLaser--;
        }
        if (timeUntilBarakoa > 0) {
            timeUntilBarakoa--;
        }
    }

    @Override
    public Animation getDeathAnimation() {
        return DIE_ANIMATION;
    }

    @Override
    public Animation getHurtAnimation() {
        return HURT_ANIMATION;
    }

    private boolean checkBlocksByFeet() {
        Block blockLeft;
        Block blockRight;
        if (direction == 1) {
            blockLeft = worldObj.getBlock(MathHelper.floor_double(posX) + 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) + 1);
            blockRight = worldObj.getBlock(MathHelper.floor_double(posX) - 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) + 1);
        } else if (direction == 2) {
            blockLeft = worldObj.getBlock(MathHelper.floor_double(posX) - 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) + 1);
            blockRight = worldObj.getBlock(MathHelper.floor_double(posX) - 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) - 1);
        } else if (direction == 3) {
            blockLeft = worldObj.getBlock(MathHelper.floor_double(posX) - 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) - 1);
            blockRight = worldObj.getBlock(MathHelper.floor_double(posX) + 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) - 1);
        } else if (direction == 4) {
            blockLeft = worldObj.getBlock(MathHelper.floor_double(posX) + 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) - 1);
            blockRight = worldObj.getBlock(MathHelper.floor_double(posX) + 1, Math.round((float) (posY - 1)), MathHelper.floor_double(posZ) + 1);
        } else {
            return false;
        }

        return !(blockLeft instanceof BlockAir && blockRight instanceof BlockAir);
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 0.25F;
            float yaw = i * (MathUtils.TAU / amount);
            float vy = rand.nextFloat() * 0.1F - 0.05f;
            float vx = velocity * MathHelper.cos(yaw);
            float vz = velocity * MathHelper.sin(yaw);
            worldObj.spawnParticle("flame", posX, posY + 1, posZ, vx, vy, vz);
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataWatcher.addObject(28, 0);
        dataWatcher.addObject(29, 0);
        dataWatcher.addObject(30, 0);
    }

    public int getDirection() {
        return dataWatcher.getWatchableObjectInt(28);
    }

    public void setDirection(Integer direction) {
        dataWatcher.updateObject(28, direction);
    }

    public int getWhichDialogue() {
        return dataWatcher.getWatchableObjectInt(29);
    }

    public void setWhichDialogue(Integer i) {
        dataWatcher.updateObject(29, i);
    }

    public int getAngry() {
        return dataWatcher.getWatchableObjectInt(30);
    }

    public void setAngry(Integer i) {
        dataWatcher.updateObject(30, i);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("direction", getDirection());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setDirection(compound.getInteger("direction"));
    }

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @Override
    protected boolean interact(EntityPlayer player) {
        if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemTestStructure) {
            pacified = true;
        }
        return super.interact(player);
    }

    private int getTimeUntilSunstrike() {
        int damageTaken = (int) (MAX_HEALTH - getHealth());
        if (damageTaken > 60) {
            damageTaken = 60;
        }
        return (int) (SUNSTRIKE_PAUSE_MAX - (damageTaken / 60f) * (SUNSTRIKE_PAUSE_MAX - SUNSTRIKE_PAUSE_MIN));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DIE_ANIMATION, HURT_ANIMATION, BELLY_ANIMATION, TALK_ANIMATION, SUNSTRIKE_ANIMATION, ATTACK_ANIMATION, SPAWN_ANIMATION, SOLAR_BEAM_ANIMATION};
    }
}
