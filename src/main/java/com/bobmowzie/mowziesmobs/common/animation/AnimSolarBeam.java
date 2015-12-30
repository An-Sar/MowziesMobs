package com.bobmowzie.mowziesmobs.common.animation;

import com.bobmowzie.mowziesmobs.common.entity.EntitySolarBeam;
import net.minecraft.entity.EntityLivingBase;
import thehippomaster.AnimationAPI.IAnimatedEntity;

/**
 * Created by jnad325 on 12/29/15.
 */
public class AnimSolarBeam extends MMAnimBase {
    protected EntityLivingBase entityTarget;

    private EntitySolarBeam solarBeam;

    public AnimSolarBeam(IAnimatedEntity entity, int id, int duration) {
        super(entity, id, duration);
        setMutexBits(8);
    }

    public void startExecuting()
    {
        super.startExecuting();
        entityTarget = animatingEntity.getAttackTarget();
    }

    public void updateTask() {
        super.updateTask();
        float radius1 = 1.7f;
        if (animatingEntity.getAnimTick() == 24 && !animatingEntity.worldObj.isRemote)
        {
            solarBeam = new EntitySolarBeam(animatingEntity.worldObj, animatingEntity, animatingEntity.posX + radius1 * Math.sin(-animatingEntity.rotationYaw * Math.PI / 180), animatingEntity.posY + 1.4, animatingEntity.posZ + radius1 * Math.cos(-animatingEntity.rotationYaw * Math.PI / 180), (float) ((animatingEntity.rotationYawHead + 90) * Math.PI/180), (float) (-animatingEntity.rotationPitch * Math.PI/180), 55);
            animatingEntity.worldObj.spawnEntityInWorld(solarBeam);
        }
        if (animatingEntity.getAnimTick() >= 24) {
            float radius2 = 1.2f;
            float angle = animatingEntity.rotationYawHead + 90;
            solarBeam.setYaw((float) (angle * Math.PI/180));
            solarBeam.setPosition(animatingEntity.posX + radius1 * Math.sin(-animatingEntity.rotationYaw * Math.PI / 180), animatingEntity.posY + 1.4, animatingEntity.posZ + radius1 * Math.cos(-animatingEntity.rotationYaw * Math.PI / 180));
            solarBeam.posX += radius2 * Math.sin(-animatingEntity.rotationYawHead * Math.PI/180) * Math.cos(-animatingEntity.rotationPitch * Math.PI/180);
            solarBeam.posZ += radius2 * Math.cos(-animatingEntity.rotationYawHead * Math.PI/180) * Math.cos(-animatingEntity.rotationPitch * Math.PI/180);
            solarBeam.posY += radius2 * Math.sin(-animatingEntity.rotationPitch * Math.PI/180);

            if (entityTarget != null) animatingEntity.getLookHelper().setLookPosition(entityTarget.posX, 0, entityTarget.posZ, 1, 1);
        }
    }
}
