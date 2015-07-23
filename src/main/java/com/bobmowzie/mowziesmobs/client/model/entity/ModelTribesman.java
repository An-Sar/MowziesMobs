package com.bobmowzie.mowziesmobs.client.model.entity;

import com.bobmowzie.mowziesmobs.common.entity.EntityTribeElite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * ModelTribesman - Undefined
 * Created using Tabula 5.1.0
 */
public class ModelTribesman extends ModelBase {
    public ModelRenderer modelCore;
    public ModelRenderer body;
    public ModelRenderer chest;
    public ModelRenderer thighLeft;
    public ModelRenderer thighRight;
    public ModelRenderer loinClothFront;
    public ModelRenderer loinClothBack;
    public ModelRenderer armRightJoint;
    public ModelRenderer armLeftJoint;
    public ModelRenderer neckJoint;
    public ModelRenderer armUpperRight;
    public ModelRenderer armLowerRight;
    public ModelRenderer handRight;
    public ModelRenderer spearBase;
    public ModelRenderer spear;
    public ModelRenderer armUpperLeft;
    public ModelRenderer armLowerLeft;
    public ModelRenderer handLeft;
    public ModelRenderer shieldBase;
    public ModelRenderer shield;
    public ModelRenderer neck;
    public ModelRenderer headJoint;
    public ModelRenderer head;
    public ModelRenderer maskBase;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer maskLeft;
    public ModelRenderer maskRight;
    public ModelRenderer mane;
    public ModelRenderer earringLeft;
    public ModelRenderer earringRight;
    public ModelRenderer calfLeft;
    public ModelRenderer footLeft;
    public ModelRenderer calfRight;
    public ModelRenderer footRight;

    public ModelTribesman() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.footLeft = new ModelRenderer(this, 21, 53);
        this.footLeft.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.footLeft.addBox(-2.5F, 0.5F, -7.0F, 5, 2, 9, 0.0F);
        this.setRotateAngle(footLeft, -0.5235987755982988F, 0.0F, 0.0F);
        this.thighLeft = new ModelRenderer(this, 41, 52);
        this.thighLeft.mirror = true;
        this.thighLeft.setRotationPoint(4.0F, -2.0F, 3.0F);
        this.thighLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(thighLeft, -0.7853981633974483F, -0.6981317007977318F, 0.0F);
        this.spearBase = new ModelRenderer(this, 0, 0);
        this.spearBase.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.spearBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.loinClothBack = new ModelRenderer(this, 32, 27);
        this.loinClothBack.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.loinClothBack.addBox(-4.0F, 0.0F, 0.0F, 8, 7, 0, 0.0F);
        this.setRotateAngle(loinClothBack, 0.17453292519943295F, 0.0F, 0.0F);
        this.loinClothFront = new ModelRenderer(this, 32, 27);
        this.loinClothFront.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.loinClothFront.addBox(-4.0F, 0.0F, 0.0F, 8, 7, 0, 0.0F);
        this.setRotateAngle(loinClothFront, -0.17453292519943295F, 0.0F, 0.0F);
        this.thighRight = new ModelRenderer(this, 41, 52);
        this.thighRight.setRotationPoint(-4.0F, -2.0F, 3.0F);
        this.thighRight.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(thighRight, -0.7853981633974483F, 0.6981317007977318F, 0.0F);
        this.armLowerLeft = new ModelRenderer(this, 12, 55);
        this.armLowerLeft.mirror = true;
        this.armLowerLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.armLowerLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(armLowerLeft, -1.0471975511965976F, 0.0F, 0.0F);
        this.armLowerRight = new ModelRenderer(this, 12, 55);
        this.armLowerRight.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.armLowerRight.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(armLowerRight, -1.0471975511965976F, 0.0F, 0.0F);
        this.earringRight = new ModelRenderer(this, 0, 29);
        this.earringRight.setRotationPoint(-3.0F, 4.0F, 0.5F);
        this.earringRight.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
        this.neckJoint = new ModelRenderer(this, 0, 0);
        this.neckJoint.setRotationPoint(0.0F, -4.0F, 1.0F);
        this.neckJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neckJoint, 0.3490658503988659F, 0.0F, 0.0F);
        this.armUpperLeft = new ModelRenderer(this, 41, 52);
        this.armUpperLeft.mirror = true;
        this.armUpperLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armUpperLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(armUpperLeft, 0.0F, 0.0F, -0.9599310885968813F);
        this.spear = new ModelRenderer(this, 66, 0);
        this.spear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spear.addBox(0.0F, -11.0F, -5.1F, 0, 16, 16, 0.0F);
        this.setRotateAngle(spear, 2.356194490192345F, 0.0F, 3.141592653589793F);
        this.earLeft = new ModelRenderer(this, 48, 0);
        this.earLeft.setRotationPoint(4.0F, -4.0F, -3.0F);
        this.earLeft.addBox(0.0F, -2.0F, 0.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(earLeft, 0.0F, -0.3490658503988659F, 0.0F);
        this.maskLeft = new ModelRenderer(this, 48, 18);
        this.maskLeft.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.maskLeft.addBox(-7.0F, -8.0F, 0.0F, 7, 14, 2, 0.0F);
        this.setRotateAngle(maskLeft, 0.0F, 0.4363323129985824F, 0.0F);
        this.calfLeft = new ModelRenderer(this, 12, 55);
        this.calfLeft.mirror = true;
        this.calfLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.calfLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(calfLeft, 1.3089969389957472F, 0.0F, 0.0F);
        this.handLeft = new ModelRenderer(this, 0, 55);
        this.handLeft.mirror = true;
        this.handLeft.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.handLeft.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 4, 0.0F);
        this.setRotateAngle(handLeft, 0.0F, 0.0F, 0.7853981633974483F);
        this.calfRight = new ModelRenderer(this, 12, 55);
        this.calfRight.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.calfRight.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(calfRight, 1.3089969389957472F, 0.0F, 0.0F);
        this.shield = new ModelRenderer(this, 66, 40);
        this.shield.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shield.addBox(1.0F, -6.0F, -6.0F, 2, 12, 12, 0.0F);
        this.setRotateAngle(shield, 0.7853981633974483F, 0.0F, 0.0F);
        this.handRight = new ModelRenderer(this, 0, 55);
        this.handRight.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.handRight.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 4, 0.0F);
        this.setRotateAngle(handRight, 0.0F, 0.0F, -0.7853981633974483F);
        this.maskBase = new ModelRenderer(this, 0, 0);
        this.maskBase.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.maskBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.neck = new ModelRenderer(this, 49, 52);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.5F, -9.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(neck, 0.3665191429188092F, 0.0F, 0.0F);
        this.modelCore = new ModelRenderer(this, 0, 0);
        this.modelCore.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.modelCore.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.head = new ModelRenderer(this, 34, 34);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -7.0F, -7.0F, 8, 8, 8, 0.0F);
        this.footRight = new ModelRenderer(this, 21, 53);
        this.footRight.mirror = true;
        this.footRight.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.footRight.addBox(-2.5F, 0.5F, -7.0F, 5, 2, 9, 0.0F);
        this.setRotateAngle(footRight, -0.5235987755982988F, 0.0F, 0.0F);
        this.armRightJoint = new ModelRenderer(this, 0, 0);
        this.armRightJoint.setRotationPoint(-3.5F, -4.5F, 0.0F);
        this.armRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armRightJoint, 0.3490658503988659F, 0.3490658503988659F, 0.0F);
        this.earRight = new ModelRenderer(this, 48, 0);
        this.earRight.mirror = true;
        this.earRight.setRotationPoint(-4.0F, -4.0F, -3.0F);
        this.earRight.addBox(-4.0F, -2.0F, 0.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(earRight, 0.0F, 0.3490658503988659F, 0.0F);
        this.shieldBase = new ModelRenderer(this, 0, 0);
        this.shieldBase.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.shieldBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.armLeftJoint = new ModelRenderer(this, 0, 0);
        this.armLeftJoint.setRotationPoint(3.5F, -4.5F, 0.0F);
        this.armLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armLeftJoint, 0.3490658503988659F, -0.3490658503988659F, 0.0F);
        this.earringLeft = new ModelRenderer(this, 0, 29);
        this.earringLeft.setRotationPoint(3.0F, 4.0F, 0.5F);
        this.earringLeft.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
        this.armUpperRight = new ModelRenderer(this, 41, 52);
        this.armUpperRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armUpperRight.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(armUpperRight, 0.0F, 0.0F, 0.9599310885968813F);
        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -7.0F, 1.0F);
        this.headJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, -0.3665191429188092F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 42);
        this.chest.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.chest.addBox(-4.0F, -5.0F, -3.5F, 8, 5, 7, 0.0F);
        this.setRotateAngle(chest, -0.3490658503988659F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 24);
        this.body.setRotationPoint(0.0F, -11.0F, -1.0F);
        this.body.addBox(-5.5F, -8.0F, -5.0F, 11, 8, 10, 0.0F);
        this.maskRight = new ModelRenderer(this, 48, 18);
        this.maskRight.mirror = true;
        this.maskRight.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.maskRight.addBox(0.0F, -8.0F, 0.0F, 7, 14, 2, 0.0F);
        this.setRotateAngle(maskRight, 0.0F, -0.4363323129985824F, 0.0F);
        this.mane = new ModelRenderer(this, 0, 0);
        this.mane.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.mane.addBox(-12.0F, -12.0F, 0.0F, 24, 24, 0, 0.0F);
        this.calfLeft.addChild(this.footLeft);
        this.body.addChild(this.thighLeft);
        this.handRight.addChild(this.spearBase);
        this.body.addChild(this.loinClothBack);
        this.body.addChild(this.loinClothFront);
        this.body.addChild(this.thighRight);
        this.armUpperLeft.addChild(this.armLowerLeft);
        this.armUpperRight.addChild(this.armLowerRight);
        this.earRight.addChild(this.earringRight);
        this.chest.addChild(this.neckJoint);
        this.armLeftJoint.addChild(this.armUpperLeft);
        this.spearBase.addChild(this.spear);
        this.head.addChild(this.earLeft);
        this.maskBase.addChild(this.maskLeft);
        this.thighLeft.addChild(this.calfLeft);
        this.armLowerLeft.addChild(this.handLeft);
        this.thighRight.addChild(this.calfRight);
        this.shieldBase.addChild(this.shield);
        this.armLowerRight.addChild(this.handRight);
        this.head.addChild(this.maskBase);
        this.neckJoint.addChild(this.neck);
        this.headJoint.addChild(this.head);
        this.calfRight.addChild(this.footRight);
        this.chest.addChild(this.armRightJoint);
        this.head.addChild(this.earRight);
        this.armLowerLeft.addChild(this.shieldBase);
        this.chest.addChild(this.armLeftJoint);
        this.earLeft.addChild(this.earringLeft);
        this.armRightJoint.addChild(this.armUpperRight);
        this.neck.addChild(this.headJoint);
        this.body.addChild(this.chest);
        this.modelCore.addChild(this.body);
        this.maskBase.addChild(this.maskRight);
        this.maskBase.addChild(this.mane);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        if (entity instanceof EntityTribeElite)
        {
            GL11.glScalef(0.85f, 0.85f, 0.85f);
            GL11.glTranslatef(0, 0.25f, 0);
        }
        else
        {
            GL11.glScalef(0.75f, 0.75f, 0.75f);
            GL11.glTranslatef(0, 0.5f, 0);
        }
        this.modelCore.render(f5);
        GL11.glPopMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
