package com.bobmowzie.mowziesmobs.client.particle;

import net.minecraft.world.World;

public class EntityOrbFX extends EntityMMFX {
	private double targetX;

	private double targetZ;

	private double signX;

	private double signZ;

	public EntityOrbFX(World world, double x, double y, double z, double targetX, double targetZ) {
		super(world, x, y, z);
		this.targetX = targetX;
		this.targetZ = targetZ;
		setTextureIndex(0, 0);
		particleScale = 1.5F + rand.nextFloat() * 0.5F;
		particleMaxAge = 120;
		signX = Math.signum(targetX - posX);
		signZ = Math.signum(targetZ - posZ);
	}

	@Override
	public void onUpdate() {
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		double vecX = targetX - posX;
		double vecZ = targetZ - posZ;
		double dist = Math.sqrt(vecX * vecX + vecZ * vecZ);
		if (dist > 2 || Math.signum(vecX) != signX || Math.signum(vecZ) != signZ || particleAge > particleMaxAge)
		{
			setDead();
			return;
		}
		particleAlpha = (float) ((2 - dist) / 2);
		final double minVel = 0.1F, maxVel = 0.35F;
		double progress = Math.sin(-Math.PI / 4 * dist) + 1;
		double magMultipler = (progress * (maxVel - minVel) + minVel) / dist;
		vecX *= magMultipler;
		vecZ *= magMultipler;
		motionX = vecX;
		motionY = progress;
		motionZ = vecZ;
		moveEntity(motionX, motionY, motionZ);
		particleAge++;
	}
}
