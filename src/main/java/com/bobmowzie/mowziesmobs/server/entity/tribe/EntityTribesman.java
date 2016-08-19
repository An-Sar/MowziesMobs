package com.bobmowzie.mowziesmobs.server.entity.tribe;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import com.bobmowzie.mowziesmobs.client.model.tools.ControlledAnimation;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationActivateAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationAttackAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationDieAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationProjectileAttackAI;
import com.bobmowzie.mowziesmobs.server.ai.animation.AnimationTakeDamage;
import com.bobmowzie.mowziesmobs.server.entity.EntityDart;
import com.bobmowzie.mowziesmobs.server.entity.LeaderSunstrikeImmune;
import com.bobmowzie.mowziesmobs.server.entity.MowzieEntity;
import com.bobmowzie.mowziesmobs.server.item.ItemHandler;
import com.bobmowzie.mowziesmobs.server.sound.MMSounds;

public class EntityTribesman extends MowzieEntity implements IRangedAttackMob, LeaderSunstrikeImmune {
    public static final Animation DIE_ANIMATION = Animation.create(70);
    public static final Animation HURT_ANIMATION = Animation.create(10);
    public static final Animation ATTACK_ANIMATION = Animation.create(19);
    public static final Animation PROJECTILE_ATTACK_ANIMATION = Animation.create(20);
    public static final Animation IDLE_ANIMATION = Animation.create(35);
    public static final Animation ACTIVATE_ANIMATION = Animation.create(20);
    private static final DataParameter<Boolean> DANCING = EntityDataManager.createKey(EntityTribesman.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> MASK = EntityDataManager.createKey(EntityTribesman.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> WEAPON = EntityDataManager.createKey(EntityTribesman.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(EntityTribesman.class, DataSerializers.BOOLEAN);
    public ControlledAnimation doWalk = new ControlledAnimation(3);
    public ControlledAnimation dancing = new ControlledAnimation(7);
    public boolean circleDirection = true;
    public int circleTick = 0;
    protected boolean attacking = false;
    protected int timeSinceAttack = 0;
    boolean prevHasTarget = false;
    boolean prevprevHasTarget = false;
    boolean prevprevprevHasTarget = false;
    int cryDelay = -1;
    private int danceTimer = 0;
    private int talkTimer = 0;

    public EntityTribesman(World world) {
        super(world);
        setPathPriority(PathNodeType.WATER, 0);
        this.tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(4, new EntityAIAttackMelee(this, 0.5D, false));
        tasks.addTask(5, new EntityAIWander(this, 0.4));
        tasks.addTask(2, new AnimationAttackAI<>(this, ATTACK_ANIMATION, MMSounds.ENTITY_BARAKOA_SWING, null, 1, 3, 1, 9));
        tasks.addTask(2, new AnimationProjectileAttackAI<>(this, PROJECTILE_ATTACK_ANIMATION, 9, MMSounds.ENTITY_BARAKOA_BLOWDART));
        tasks.addTask(4, new AnimationAI<>(this, IDLE_ANIMATION));
        tasks.addTask(3, new AnimationTakeDamage<>(this));
        tasks.addTask(1, new AnimationDieAI<>(this));
        tasks.addTask(0, new AnimationActivateAI<>(this, ACTIVATE_ANIMATION));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        setMask(MathHelper.getRandomIntegerInRange(rand, 2, 5));
        setSize(0.6f, 1.7f);
        stepHeight = 1;
        circleTick += rand.nextInt(200);
        frame += rand.nextInt(50);
        experienceValue = 8;
        active = true;
    }

    @Override
    public int getAttack() {
        return 4;
    }

    @Override
    public Animation getDeathAnimation() {
        return DIE_ANIMATION;
    }

    @Override
    public Animation getHurtAnimation() {
        return HURT_ANIMATION;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (!active) {
            return null;
        }
        if (danceTimer == 0) {
            if (getAttackTarget() == null) {
                int i = MathHelper.getRandomIntegerInRange(rand, 0, 11);
                if (i < MMSounds.ENTITY_BARAKOA_TALK.length) {
                    playSound(MMSounds.ENTITY_BARAKOA_TALK[i], 1, 1.5f);
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, IDLE_ANIMATION);
                }
            } else {
                int i = MathHelper.getRandomIntegerInRange(rand, 0, 7);
                if (i < MMSounds.ENTITY_BARAKOA_ANGRY.length) {
                    playSound(MMSounds.ENTITY_BARAKOA_ANGRY[i], 1, 1.6f);   
                }
            }
        }
        return null;
    }

    @Override
    protected SoundEvent getHurtSound() {
        return active ? MMSounds.ENTITY_BARAKOA_HURT : null;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        return super.attackEntityAsMob(p_70652_1_);
    }

    protected void updateAttackAI() {
        if (timeSinceAttack < 80) {
            timeSinceAttack++;
        }
        if (getAttackTarget() != null) {
            if (targetDistance > 7) {
                getNavigator().tryMoveToXYZ(getAttackTarget().posX, getAttackTarget().posY, getAttackTarget().posZ, 0.6);
            } else {
                if (!attacking) {
                    updateCircling();
                }
            }
            if (rand.nextInt(80) == 0 && timeSinceAttack == 80) {
                attacking = true;
                if (getAnimation() == NO_ANIMATION && getWeapon() == 0) {
                    getNavigator().tryMoveToEntityLiving(getAttackTarget(), 0.5);
                }
            }
            if (attacking && getAnimation() == NO_ANIMATION) {
                if (targetDistance <= 3 && getWeapon() == 0) {
                    attacking = false;
                    timeSinceAttack = 0;
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
                }
                if (getWeapon() == 1) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, PROJECTILE_ATTACK_ANIMATION);
                }
            }
        } else {
            attacking = false;
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        if (!(this instanceof EntityTribeElite)) {
            int weapon = 0;
            if (rand.nextInt(3) == 0) {
                weapon = 1;
            }
            setWeapon(weapon);
        }
        return super.onInitialSpawn(difficulty, data);
    }

    protected void updateCircling() {
        if (rand.nextInt(200) == 0) {
            circleDirection = !circleDirection;
        }
        if (circleDirection) {
            circleTick++;
        } else {
            circleTick--;
        }
        if (!attacking && targetDistance < 5) {
            circleEntity(getAttackTarget(), 7, 0.3f, true, circleTick, 0, 1.75f);
        } else {
            circleEntity(getAttackTarget(), 7, 0.3f, true, circleTick, 0, 1);
        }
        attacking = false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!worldObj.isRemote && active && !getActive()) {
            setActive(true);
        }
        active = getActive();
        if (!active) {
            getNavigator().clearPathEntity();
            rotationYaw = prevRotationYaw;
            renderYawOffset = rotationYaw;
            if (onGround && getAnimation() == NO_ANIMATION) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this, ACTIVATE_ANIMATION);
                playSound(MMSounds.ENTITY_BARAKOA_EMERGE, 1, 1);
            }
            return;
        }
        updateAttackAI();
        if (getAnimation() != NO_ANIMATION) {
            getNavigator().clearPathEntity();
        }

        if (getDancing()) {
            setDancing(false);
            danceTimer++;
        }

        if (getAnimation() == NO_ANIMATION || getAnimation() == IDLE_ANIMATION) {
            doWalk.increaseTimer();
        } else {
            doWalk.decreaseTimer();
        }

        if (danceTimer != 0 && danceTimer != 30) {
            danceTimer++;
            dancing.increaseTimer();
        } else {
            danceTimer = 0;
            dancing.decreaseTimer();
        }
        if (!worldObj.isRemote && getAnimation() == NO_ANIMATION && danceTimer == 0 && rand.nextInt(800) == 0) {
            setDancing(true);
            playSound(MMSounds.ENTITY_BARAKOA_BATTLECRY_2, 1.2f, 1.3f);
        }
        if (getAnimation() != NO_ANIMATION) {
            danceTimer = 0;
        }

        if (cryDelay > -1) {
            cryDelay--;
        }
        if (cryDelay == 0) {
            playSound(MMSounds.ENTITY_BARAKOA_BATTLECRY, 1.5f, 1.5f);
        }
        if (getAttackTarget() != null && !prevHasTarget && !prevprevHasTarget && !prevprevprevHasTarget) {
            cryDelay = MathHelper.getRandomIntegerInRange(rand, -15, 30);
        }

        if (getAnimation() == ATTACK_ANIMATION && getAnimationTick() == 5) {
            playSound(MMSounds.ENTITY_BARAKOA_SHOUT, 1, 1.1f);
        }
        if (getAnimation() == PROJECTILE_ATTACK_ANIMATION && getAnimationTick() == 1) {
            playSound(MMSounds.ENTITY_BARAKOA_INHALE, 0.7f, 1.2f);
        }

        prevprevprevHasTarget = prevprevHasTarget;
        prevprevHasTarget = prevHasTarget;
        prevHasTarget = (getAttackTarget() != null);

        if (ticksExisted > 50) setDead();
//        if (getAnimation() == NO_ANIMATION) AnimationAPI.sendAnimPacket(this, 4);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return MMSounds.ENTITY_BARAKOA_DIE;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        getDataManager().register(DANCING, false);
        getDataManager().register(MASK, 0);
        getDataManager().register(WEAPON, 0);
        getDataManager().register(ACTIVE, true);
    }

    public boolean getDancing() {
        return getDataManager().get(DANCING);
    }

    public void setDancing(boolean dancing) {
        getDataManager().set(DANCING, dancing);
    }

    public int getMask() {
        return getDataManager().get(MASK);
    }

    public void setMask(int type) {
        getDataManager().set(MASK, type);
    }

    public int getWeapon() {
        return getDataManager().get(WEAPON);
    }

    public void setWeapon(int type) {
        getDataManager().set(WEAPON, type);
    }

    public boolean getActive() {
        return getDataManager().get(ACTIVE);
    }

    public void setActive(boolean active) {
        getDataManager().set(ACTIVE, active);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("mask", getMask());
        compound.setInteger("weapon", getWeapon());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setMask(compound.getInteger("mask"));
        setWeapon(compound.getInteger("weapon"));
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float p_82196_2_) {
        EntityArrow dart = new EntityDart(this.worldObj, this);
        double dx = target.posX - this.posX;
        double dy = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - dart.posY;
        double dz = target.posZ - this.posZ;
        double dist = (double)MathHelper.sqrt_double(dx * dx + dz * dz);
        dart.setThrowableHeading(dx, dy + dist * 0.2D, dz, 1.6F, 1);
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, this.getHeldItem(EnumHand.MAIN_HAND));
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, this.getHeldItem(EnumHand.MAIN_HAND));
        dart.setDamage((double) (p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (double) ((float) this.worldObj.getDifficulty().getDifficultyId() * 0.11F));

        if (i > 0) {
            dart.setDamage(dart.getDamage() + (double) i * 0.5D + 0.5D);
        }

        if (j > 0) {
            dart.setKnockbackStrength(j);
        }

        this.worldObj.spawnEntityInWorld(dart);
        attacking = false;
    }

    @Override
    public void onDeath(DamageSource p_70645_1_) {
        if (!worldObj.isRemote && worldObj.getGameRules().getBoolean("doMobLoot") && rand.nextInt(12) == 0) {
            dropItem(ItemHandler.INSTANCE.barakoaMasks[getMask() - 1], 1);
        }
        super.onDeath(p_70645_1_);
    }

    @Override
    public boolean canBeCollidedWith() {
        return active;
    }

    @Override
    public void fall(float distance, float damageMultipler) {
        if (active) {
            super.fall(distance, damageMultipler);
        }
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{DIE_ANIMATION, HURT_ANIMATION, ATTACK_ANIMATION, PROJECTILE_ATTACK_ANIMATION, IDLE_ANIMATION, ACTIVATE_ANIMATION};
    }
}
