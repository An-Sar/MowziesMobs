package com.bobmowzie.mowziesmobs.common.ai.animation;

import com.bobmowzie.mowziesmobs.common.entity.EntityTribeLeader;
import com.bobmowzie.mowziesmobs.common.entity.LeaderSunstrikeImmune;
import com.bobmowzie.mowziesmobs.common.entity.MowzieEntity;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

import java.util.List;

public class AnimationRadiusAttack<T extends MowzieEntity & IAnimatedEntity> extends AnimationAI<T> {
    private float radius;
    private int damage;
    private float knockBack;
    private int damageFrame;

    public AnimationRadiusAttack(T entity, Animation animation, float radius, int damage, float knockBack, int damageFrame) {
        super(entity, animation);
        this.radius = radius;
        this.damage = damage;
        this.knockBack = knockBack;
        this.damageFrame = damageFrame;
        setMutexBits(8);
    }

    @Override
    public void updateTask() {
        super.updateTask();
        if (animatingEntity.getAnimationTick() == damageFrame) {
            List<EntityLivingBase> hit = animatingEntity.getEntityLivingBaseNearby(radius, 2 * radius, radius, radius);
            for (EntityLivingBase aHit : hit) {
                if (animatingEntity instanceof EntityTribeLeader && aHit instanceof LeaderSunstrikeImmune) {
                    continue;
                }
                aHit.attackEntityFrom(DamageSource.causeMobDamage(animatingEntity), damage);
                aHit.motionX *= knockBack;
                aHit.motionZ *= knockBack;
            }
        }
    }
}