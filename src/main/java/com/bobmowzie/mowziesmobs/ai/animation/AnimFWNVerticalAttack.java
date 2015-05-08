package com.bobmowzie.mowziesmobs.ai.animation;

import com.bobmowzie.mowziesmobs.entity.EntityWroughtnaut;
import com.bobmowzie.mowziesmobs.entity.MMEntityBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

import java.util.List;

/**
 * Created by jnad325 on 4/16/15.
 */
public class AnimFWNVerticalAttack extends AnimBasicAttack {
    private float arc;

    public AnimFWNVerticalAttack(MMEntityBase entity, int duration, String sound, float knockback, float range, float arc) {
        super(entity, duration, sound, knockback, range);
        this.arc = arc;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        entity.playSound("mowziesmobs:wroughtnautPreSwing2", 1.5F, 1F);
    }

    @Override
    public int getAnimID() {
        return 5;
    }

    @Override
    public void updateTask()
    {
        entity.motionX = 0;
        entity.motionZ = 0;
        if (entity.getAnimTick() < 27 && entityTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(entityTarget, 30F, 30F);

        if (entity.getAnimTick() == 6) entity.playSound("mowziesmobs:wroughtnautCreak", 0.5F, 1F);

        if (entity.getAnimTick() == 27) entity.playSound(attackSound, 1.2F, 1);

        if (this.entity.getAnimTick() == 27) {
            entity.playSound("mowziesmobs:wroughtnautSwing2", 1.5F, 1F);
            List<EntityLivingBase> entitiesHit = entity.getEntityLivingBaseNearby(range, 3, range, range);
            float damage = (float) this.entity.getAttack();
            for (EntityLivingBase entityHit : entitiesHit) {
                float entityHitAngle = (float) ((Math.atan2(entityHit.posZ - entity.posZ, entityHit.posX - entity.posX) * (180 / Math.PI) - 90) % 360);
                float entityAttackingAngle = entity.renderYawOffset % 360;
                if (entityHitAngle < 0) entityHitAngle += 360;
                if (entityAttackingAngle < 0) entityAttackingAngle += 360;
                float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
                float entityHitDistance = (float) Math.sqrt((entityHit.posZ - entity.posZ) * (entityHit.posZ - entity.posZ) + (entityHit.posX - entity.posX) * (entityHit.posX - entity.posX));
                if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc/2 || entityRelativeAngle <= -360 + arc/2)) {
                    entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.entity), damage * 1.5F);
                    entityHit.motionX *= knockback;
                    entityHit.motionZ *= knockback;
                }
            }
            entity.playSound("minecraft:random.anvil_land", 1, 0.5F);
        }
        if (entity.getAnimTick() > 27 && entity.getAnimTick() < 80) ((EntityWroughtnaut)entity).vulnerable = true;
        else ((EntityWroughtnaut)entity).vulnerable = false;
    }
}
