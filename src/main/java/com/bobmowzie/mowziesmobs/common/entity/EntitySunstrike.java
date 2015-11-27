package com.bobmowzie.mowziesmobs.common.entity;

import com.bobmowzie.mowziesmobs.client.audio.MovingSoundSuntrike;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by jnad325 on 11/16/15.
 */
public class EntitySunstrike extends Entity implements IEntityAdditionalSpawnData
{
    private static final int STRIKE_LENGTH = 43;

    private static final int STRIKE_EXPLOSION = 35;

    // 2 minutes past strike end
    private static final int STRIKE_LINGER = STRIKE_LENGTH + 20 * 60 * 2;

    private int prevStrikeTime;

    private int strikeTime;

    public EntitySunstrike(World world)
    {
        super(world);
        setSize(0.1F, 0.1F);
        ignoreFrustumCheck = true;
    }

    public EntitySunstrike(World world, int x, int y, int z)
    {
        this(world);
        setPosition(x + 0.5F, y + 1.0625F, z + 0.5F);
    }

    @Override
    protected void entityInit()
    {
    }

    public float getStrikeTime(float delta)
    {
        return getActualStrikeTime(delta) / STRIKE_LENGTH;
    }

    public float getStrikeDrawTime(float delta)
    {
        return getActualStrikeTime(delta) / STRIKE_EXPLOSION;
    }

    public float getStrikeDamageTime(float delta)
    {
        return (getActualStrikeTime(delta) - STRIKE_EXPLOSION) / (STRIKE_LENGTH - STRIKE_EXPLOSION);
    }

    public boolean isStrikeDrawing(float delta)
    {
        return getActualStrikeTime(delta) < STRIKE_EXPLOSION;
    }

    public boolean isLingering(float delta)
    {
        return getActualStrikeTime(delta) > STRIKE_LENGTH;
    }

    private float getActualStrikeTime(float delta)
    {
        return prevStrikeTime + (strikeTime - prevStrikeTime) * delta;
    }

    private void setStrikeTime(int strikeTime)
    {
        this.prevStrikeTime = this.strikeTime = strikeTime;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    public boolean isInRangeToRenderDist(double distance)
    {
        return distance < 1024;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        prevStrikeTime = strikeTime;

        if (worldObj.isRemote)
        {
            if (strikeTime == 0)
            {
                Minecraft.getMinecraft().getSoundHandler().playSound(new MovingSoundSuntrike(this));
            }
        }
        else
        {
            if (strikeTime == STRIKE_LINGER || !worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)))
            {
                setDead();
            }
            else if (strikeTime == STRIKE_EXPLOSION)
            {
                damageEntityLivingBaseNearby(3);
            }
        }
        strikeTime++;
    }

    public void damageEntityLivingBaseNearby(double radius)
    {
        AxisAlignedBB region = AxisAlignedBB.getBoundingBox(posX - radius, posY - 0.5, posZ - radius, posX + radius, Double.POSITIVE_INFINITY, posZ + radius);
        List<Entity> entities = worldObj.getEntitiesWithinAABBExcludingEntity(this, region);
        double radiusSq = radius * radius;
        for (Entity entity : entities)
        {
            if (entity instanceof EntityLivingBase && getDistanceSqToEntity(entity) < radiusSq)
            {
                ((EntityLivingBase) entity).attackEntityFrom(DamageSource.onFire, 10);
                ((EntityLivingBase) entity).setFire(5);
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setInteger("strikeTime", strikeTime);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        setStrikeTime(compound.getInteger("strikeTime"));
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        buffer.writeInt(strikeTime);
    }

    @Override
    public void readSpawnData(ByteBuf buffer)
    {
        setStrikeTime(buffer.readInt());
    }
}
