package com.bobmowzie.mowziesmobs.entity;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.ai.animation.AnimBasicAttack;
import com.bobmowzie.mowziesmobs.client.model.animation.tools.ControlledAnimation;
import com.bobmowzie.mowziesmobs.client.model.animation.tools.IntermittentAnimation;
import com.bobmowzie.mowziesmobs.enums.MMAnimation;
import com.bobmowzie.mowziesmobs.packet.AbstractPacket;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketDecreaseTimer;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketIncreaseTimer;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketSetActiveFalse;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketSetActiveTrue;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityFoliaath extends MMEntityBase
{
    public IntermittentAnimation openMouth = new IntermittentAnimation(15, 70, 7, 1);
    public ControlledAnimation activate = new ControlledAnimation(30);
    public boolean active;
    public int lastTimeDecrease = 0;
    private double prevOpenMouth;
    private double prevActivate;

    public EntityFoliaath(World world)
    {
        super(world);
        this.getNavigator().setAvoidsWater(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(2, new AnimBasicAttack(this, 14, "mowziesmobs:foliaathbite1", 2F, 4.5F));
        tasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        tasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCreature.class, 0, true));
    }

    public int getAttack()
    {
        return 8;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
    }

    public void onUpdate()
    {
        super.onUpdate();
        //Open mouth animation
        if (worldObj.isRemote)
        {
            if (getAnimID() == 0 && activate.getAnimationFraction() == 1) openMouth.runAnimation();
            else openMouth.stopAnimation();
        }

        if (worldObj.isRemote && activate.getAnimationFraction() >= 0.8)
        {
            if (active == false) {
                sendPacket2(new PacketSetActiveTrue(getEntityId()));
                active = true;
            }
        }
        else if (worldObj.isRemote && activate.getAnimationFraction() < 0.8)
        {
            if (active == true) {
                sendPacket2(new PacketSetActiveFalse(getEntityId()));
                active = false;
            }
        }

        System.out.println(active);

        //Sounds
        if (frame % 13 == 3)
        {
            if (openMouth.getTimer() >= 10) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathpant1");
            else if (activate.getTimer() >= 25) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathpant2");
        }

        if (openMouth.getTimer() == 1 && prevOpenMouth-openMouth.getTimer() < 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathrustle");
        if (openMouth.getTimer() == 13 && prevOpenMouth-openMouth.getTimer() < 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathgrunt");
        prevOpenMouth = openMouth.getTimer();

        if (activate.getTimer() == 1 && prevActivate-activate.getTimer() < 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathrustle");
        if (activate.getTimer() == 5 && prevActivate-activate.getTimer() < 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathemerge");
        if (activate.getTimer() == 28 && prevActivate-activate.getTimer() > 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathrustle");
        if (activate.getTimer() == 24 && prevActivate-activate.getTimer() > 0) MowziesMobs.playSound(getEntityId(), "mowziesmobs:foliaathretreat");
        prevActivate = activate.getTimer();

        //Targetting, attacking, and activating
        renderYawOffset = 0;
        rotationYaw = 0;

        if (getAttackTarget() instanceof EntityFoliaath) setAttackTarget(null);
        if (getAttackTarget() != null)
        {
            setRotationYawHead(targetAngle);

            if (targetDistance <= 4.5 && getAnimID() == 0 && active)
            {
                AnimationAPI.sendAnimPacket(this, MMAnimation.ATTACK.animID());
            }

            if (targetDistance <= 11)
            {
                sendPacket(new PacketIncreaseTimer(getEntityId()));
                lastTimeDecrease = 0;
            }
            else if (lastTimeDecrease <= 30 && getAnimID() == 0)
            {
                sendPacket(new PacketDecreaseTimer(getEntityId()));
                lastTimeDecrease++;
            }
        }
        else if (lastTimeDecrease <= 30 && getAnimID() == 0)
        {
            sendPacket(new PacketDecreaseTimer(getEntityId()));
            lastTimeDecrease++;
        }
    }

    @Override
    public void applyEntityCollision(Entity p_70108_1_)
    {
        if (p_70108_1_.riddenByEntity != this && p_70108_1_.ridingEntity != this)
        {
            double d0 = p_70108_1_.posX - this.posX;
            double d1 = p_70108_1_.posZ - this.posZ;
            double d2 = MathHelper.abs_max(d0, d1);

            if (d2 >= 0.009999999776482582D)
            {
                d2 = (double)MathHelper.sqrt_double(d2);
                d0 /= d2;
                d1 /= d2;
                double d3 = 1.0D / d2;

                if (d3 > 1.0D)
                {
                    d3 = 1.0D;
                }

                d0 *= d3;
                d1 *= d3;
                d0 *= 0.05000000074505806D;
                d1 *= 0.05000000074505806D;
                d0 *= (double)(1.0F - this.entityCollisionReduction);
                d1 *= (double)(1.0F - this.entityCollisionReduction);
                addVelocity(d0, 0.0D, d1);
                p_70108_1_.addVelocity(d0, 0.0D, d1);
            }
        }
    }

    public void sendPacket(AbstractPacket packet)
    {
        if (!worldObj.isRemote)
        {
            MowziesMobs.networkWrapper.sendToAll(packet);
        }
    }

    public void sendPacket2(AbstractPacket packet)
    {
        MowziesMobs.networkWrapper.sendToServer(packet);
    }

    @Override
    public boolean getCanSpawnHere() {
        if (this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
        {
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.boundingBox.minY);
            int k = MathHelper.floor_double(this.posZ);

            if (j < 63)
            {
                return false;
            }

            Block block = this.worldObj.getBlock(i, j - 1, k);

            if (block == Blocks.grass || block.isLeaves(worldObj, i, j - 1, k))
            {
                return true;
            }
        }

        return false;
    }
}

