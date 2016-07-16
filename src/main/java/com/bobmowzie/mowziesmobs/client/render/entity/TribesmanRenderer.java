package com.bobmowzie.mowziesmobs.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.client.model.entity.TribesmanModel;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribeElite;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribesman;

@SideOnly(Side.CLIENT)
public class TribesmanRenderer extends RenderLiving<EntityTribesman> {
    private static final ResourceLocation ELITE_TEXTURE = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribesman1.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribesman2.png");
    private static final ResourceLocation TEXTURE3 = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribesman3.png");
    private static final ResourceLocation TEXTURE4 = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribesman4.png");
    private static final ResourceLocation TEXTURE5 = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribesman5.png");

    public TribesmanRenderer(RenderManager mgr) {
        super(mgr, new TribesmanModel(), 0.6F);
    }

    @Override
    protected float getDeathMaxRotation(EntityTribesman entity) {
        return 0;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityTribesman entity) {
        EntityTribesman tribesman = (EntityTribesman) entity;
        if (tribesman instanceof EntityTribeElite) {
            return TribesmanRenderer.ELITE_TEXTURE;
        } else if (tribesman.getMask() == 2) {
            return TribesmanRenderer.TEXTURE2;
        } else if (tribesman.getMask() == 3) {
            return TribesmanRenderer.TEXTURE3;
        } else if (tribesman.getMask() == 4) {
            return TribesmanRenderer.TEXTURE4;
        } else if (tribesman.getMask() == 5) {
            return TribesmanRenderer.TEXTURE5;
        }
        return TribesmanRenderer.TEXTURE2;
    }
}
