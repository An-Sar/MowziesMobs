package com.bobmowzie.mowziesmobs.client.renderer.entity;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderWroughtnaut extends RenderLiving
{
    public RenderWroughtnaut(ModelBase model, float shadowSize)
    {
        super(model, shadowSize);
    }

    @Override
    public void preRenderCallback(EntityLivingBase entity, float side)
    {
        super.preRenderCallback(entity, side);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        return new ResourceLocation(MowziesMobs.getModID() + "textures/entity/textureWroughtnaut.png");
    }

    @Override
    protected float getDeathMaxRotation(EntityLivingBase entity)
    {
        return 0;
    }
}
