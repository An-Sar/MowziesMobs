package com.bobmowzie.mowziesmobs.entity;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.ai.animation.AnimBasicAttack;
import com.bobmowzie.mowziesmobs.client.model.animation.tools.ControlledAnimation;
import com.bobmowzie.mowziesmobs.client.model.animation.tools.IntermittentAnimation;
import com.bobmowzie.mowziesmobs.enums.MMAnimation;
import com.bobmowzie.mowziesmobs.packet.AbstractPacket;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketDecreaseTimer;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketIncreaseTimer;
import com.bobmowzie.mowziesmobs.packet.foliaath.PacketSetActive;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
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
        return 12;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
    }

    public void onUpdate()
    {
        super.onUpdate();
        if (worldObj.isRemote)
        {
            if (getAnimID() == 0 && activate.getAnimationFraction() == 1) openMouth.runAnimation();
            else openMouth.stopAnimation();
        }

        if (activate.getAnimationFraction() == 1)
        {
            if (active == false) sendPacket(new PacketSetActive(getEntityId(), true));
        }
        else
        {
            if (active == true) sendPacket(new PacketSetActive(getEntityId(), false));
        }

        //System.out.println(active);

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

        renderYawOffset = 0;
        rotationYaw = 0;

        if (getAttackTarget() instanceof EntityFoliaath) setAttackTarget(null);
        if (getAttackTarget() != null)
        {
            setRotationYawHead(targetAngle);

            if (targetDistance <= 4.5 && getAnimID() == 0)
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

    public void sendPacket(AbstractPacket packet)
    {
        if (!worldObj.isRemote)
        {
            MowziesMobs.networkWrapper.sendToAll(packet);
        }
    }
}

