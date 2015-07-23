package com.bobmowzie.mowziesmobs.common.entity;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by jnad325 on 7/23/15.
 */
public class EntityTribeHunter extends EntityTribesman {
    public EntityTribeElite leader;
    public int index = 0;

    public EntityTribeHunter(World world) {
        super(world);
        tasks.addTask(5, new EntityAIWander(this, 0.4));
        this.leader = null;
    }

    public EntityTribeHunter(World world, EntityTribeElite leader) {
        super(world);
        this.leader = leader;
    }

    public void setIndex(int index) {
        this.index = index;
        setPackIndex(index);
    }

    @Override
    public void onDeath(DamageSource p_70645_1_) {
        super.onDeath(p_70645_1_);
        if (leader != null) leader.pack.set(index, null);
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(30, 0);
        dataWatcher.addObject(31, 0);
    }

    public int getLeaderID()
    {
        return dataWatcher.getWatchableObjectInt(30);
    }

    public void setLeaderID(Integer id)
    {
        dataWatcher.updateObject(30, id);
    }

    public int getPackIndex()
    {
        return dataWatcher.getWatchableObjectInt(31);
    }

    public void setPackIndex(Integer index)
    {
        dataWatcher.updateObject(31, index);
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("mask", getMask());
        compound.setInteger("leaderID", getLeaderID());
        compound.setInteger("index", getPackIndex());
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        setMask(compound.getInteger("mask"));
        setLeaderID(compound.getInteger("leaderID"));
        setIndex(compound.getInteger("index"));

        leader = (EntityTribeElite) worldObj.getEntityByID(getLeaderID());
        leader.pack.set(index, this);
    }
}
