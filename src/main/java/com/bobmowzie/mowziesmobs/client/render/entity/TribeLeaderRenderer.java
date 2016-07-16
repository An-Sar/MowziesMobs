package com.bobmowzie.mowziesmobs.client.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.bobmowzie.mowziesmobs.MowziesMobs;
import com.bobmowzie.mowziesmobs.client.model.entity.TribeLeaderModel;
import com.bobmowzie.mowziesmobs.server.entity.tribe.EntityTribeLeader;

@SideOnly(Side.CLIENT)
public class TribeLeaderRenderer extends RenderLiving<EntityTribeLeader> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MowziesMobs.MODID, "textures/entity/textureTribeLeader.png");
    private static final ResourceLocation BURST_TEXTURE = new ResourceLocation(MowziesMobs.MODID, "textures/effects/textureSunstrike.png");
    private static final double BURST_RADIUS = 3.5;
    private static final int BURST_FRAME_COUNT = 10;
    private static final int BURST_START_FRAME = 12;

    public TribeLeaderRenderer(RenderManager mgr) {
        super(mgr, new TribeLeaderModel(), 1.0F);
    }

    @Override
    protected float getDeathMaxRotation(EntityTribeLeader entity) {
        return 0;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityTribeLeader entity) {
        return TribeLeaderRenderer.TEXTURE;
    }

    @Override
    public void doRender(EntityTribeLeader barako, double x, double y, double z, float yaw, float delta) {
        if (barako.getAnimation() == EntityTribeLeader.ATTACK_ANIMATION && barako.getAnimationTick() > BURST_START_FRAME && barako.getAnimationTick() < BURST_START_FRAME + BURST_FRAME_COUNT - 1) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(x, y + 1.1, z);
            setupGL();
            bindTexture(BURST_TEXTURE);
            GlStateManager.rotate(-renderManager.playerViewY, 0, 1, 0);
            GlStateManager.rotate(renderManager.playerViewX, 1, 0, 0);
            GlStateManager.disableDepth();
            drawBurst(barako.getAnimationTick() - BURST_START_FRAME + delta);
            GlStateManager.enableDepth();
            revertGL();
            GlStateManager.popMatrix();
        }
        super.doRender(barako, x, y, z, yaw, delta);
    }

    private void drawBurst(float tick) {
        int dissapateFrame = 6;
        float firstSpeed = 2f;
        float secondSpeed = 1f;
        int frame = ((int) (tick * firstSpeed) <= dissapateFrame) ? (int) (tick * firstSpeed) : (int) (dissapateFrame + (tick - dissapateFrame / firstSpeed) * secondSpeed);
        if (frame > BURST_FRAME_COUNT) {
            frame = BURST_FRAME_COUNT;
        }
        double minU = 0.0625 * frame;
        double maxU = minU + 0.0625;
        double minV = 0.5;
        double maxV = minV + 0.5;
        double offset = 0.219 * (frame % 2);
        Tessellator t = Tessellator.getInstance();
        VertexBuffer buf = t.getBuffer();
        buf.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
        float opacity = (tick < 8) ? 0.8f : 0.4f;
        buf.pos(-BURST_RADIUS + offset, -BURST_RADIUS + offset, 0).tex(minU, minV).lightmap(0, 240).color(1, 1, 1, opacity).endVertex();
        buf.pos(-BURST_RADIUS + offset, BURST_RADIUS + offset, 0).tex(minU, maxV).lightmap(0, 240).color(1, 1, 1, opacity).endVertex();
        buf.pos(BURST_RADIUS + offset, BURST_RADIUS + offset, 0).tex(maxU, maxV).lightmap(0, 240).color(1, 1, 1, opacity).endVertex();
        buf.pos(BURST_RADIUS + offset, -BURST_RADIUS + offset, 0).tex(maxU, minV).lightmap(0, 240).color(1, 1, 1, opacity).endVertex();
        GlStateManager.disableDepth();
        t.draw();
        GlStateManager.enableDepth();
    }

    private void setupGL() {
        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0);
    }

    private void revertGL() {
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
    }
}
