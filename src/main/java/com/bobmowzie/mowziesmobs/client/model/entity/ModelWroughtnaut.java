package com.bobmowzie.mowziesmobs.client.model.entity;

import com.bobmowzie.mowziesmobs.client.model.animation.tools.MowzieModelBase;
import com.bobmowzie.mowziesmobs.client.model.animation.tools.MowzieModelRenderer;
import com.bobmowzie.mowziesmobs.entity.EntityWroughtnaut;
import com.bobmowzie.mowziesmobs.enums.MMAnimation;
import net.minecraft.entity.Entity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelWroughtnaut extends MowzieModelBase {
    private Animator animator;
    public MowzieModelRenderer waist;
    public MowzieModelRenderer groin;
    public MowzieModelRenderer stomachJoint;
    public MowzieModelRenderer groinJoint;
    public MowzieModelRenderer stomach;
    public MowzieModelRenderer chestJoint;
    public MowzieModelRenderer chest;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer shoulderRightJoint;
    public MowzieModelRenderer shoulderLeftJoint;
    public MowzieModelRenderer head;
    public MowzieModelRenderer helmet;
    public MowzieModelRenderer tuskRight1;
    public MowzieModelRenderer tuskLeft1;
    public MowzieModelRenderer hornRight1;
    public MowzieModelRenderer hornLeft1;
    public MowzieModelRenderer tuskRight2;
    public MowzieModelRenderer tuskLeft2;
    public MowzieModelRenderer hornRight2;
    public MowzieModelRenderer hornLeft2;
    public MowzieModelRenderer shoulderRight;
    public MowzieModelRenderer upperArmRightJoint;
    public MowzieModelRenderer upperArmRight;
    public MowzieModelRenderer lowerArmRightJoint;
    public MowzieModelRenderer elbowRightJoint;
    public MowzieModelRenderer lowerArmRight;
    public MowzieModelRenderer handRightJoint;
    public MowzieModelRenderer handRight;
    public MowzieModelRenderer axeBase;
    public MowzieModelRenderer axeHandle;
    public MowzieModelRenderer axeBladeRight;
    public MowzieModelRenderer axeBladeLeft;
    public MowzieModelRenderer axeBladeRight1;
    public MowzieModelRenderer axeBladeRight2;
    public MowzieModelRenderer axeBladeRight3;
    public MowzieModelRenderer axeBladeLeft1;
    public MowzieModelRenderer axeBladeLeft2;
    public MowzieModelRenderer axeBladeLeft3;
    public MowzieModelRenderer elbowRight;
    public MowzieModelRenderer shoulderLeft;
    public MowzieModelRenderer upperArmLeftJoint;
    public MowzieModelRenderer upperArmLeft;
    public MowzieModelRenderer lowerArmLeftJoint;
    public MowzieModelRenderer elbowLeftJoint;
    public MowzieModelRenderer lowerArmLeft;
    public MowzieModelRenderer handLeftJoint;
    public MowzieModelRenderer handLeft;
    public MowzieModelRenderer elbowLeft;
    public MowzieModelRenderer groinFront;
    public MowzieModelRenderer groinBack;
    public MowzieModelRenderer thighRightJoint;
    public MowzieModelRenderer thighLeftJoint;
    public MowzieModelRenderer thighRightJoint2;
    public MowzieModelRenderer thighRight;
    public MowzieModelRenderer calfRightJoint;
    public MowzieModelRenderer kneeRight;
    public MowzieModelRenderer calfRight;
    public MowzieModelRenderer footRightJoint;
    public MowzieModelRenderer footRight;
    public MowzieModelRenderer thighLeftJoint2;
    public MowzieModelRenderer thighLeft;
    public MowzieModelRenderer calfLeftJoint;
    public MowzieModelRenderer kneeLeft;
    public MowzieModelRenderer calfLeft;
    public MowzieModelRenderer footLeftJoint;
    public MowzieModelRenderer footLeft;

    public MowzieModelRenderer waistBendController;

    public ModelWroughtnaut() {
        animator = new Animator(this);
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.axeHandle = new MowzieModelRenderer(this, 0, 22);
        this.axeHandle.setRotationPoint(3.0F, 0.0F, 1.0F);
        this.axeHandle.addBox(-1.5F, -44.0F, -1.5F, 3, 50, 3, 0.0F);
        this.stomach = new MowzieModelRenderer(this, 80, 63);
        this.stomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stomach.addBox(-6.0F, -13.7F, -6.0F, 12, 17, 12, 0.0F);
        this.setRotateAngle(stomach, 0.0F, 0.7853981633974483F, 0.0F);
        this.elbowRight = new MowzieModelRenderer(this, 70, 24);
        this.elbowRight.setRotationPoint(0.0F, 0.0F, -1.4F);
        this.elbowRight.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 5, 0.0F);
        this.calfRight = new MowzieModelRenderer(this, 0, 75);
        this.calfRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.calfRight.addBox(-4.5F, 0.0F, -0.5F, 5, 12, 5, 0.0F);
        this.setRotateAngle(calfRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.lowerArmRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.lowerArmRightJoint.setRotationPoint(15.0F, 0.0F, 0.0F);
        this.lowerArmRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(lowerArmRightJoint, 0.7853981633974483F, 0.0F, 0.0F);
        this.kneeLeft = new MowzieModelRenderer(this, 24, 80);
        this.kneeLeft.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.kneeLeft.addBox(-3.0F, -1.7F, -3.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(kneeLeft, -0.5235987755982988F, -0.7853981633974483F, 0.0F);
        this.elbowLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.elbowLeftJoint.setRotationPoint(15.0F, -1.6F, -1.7F);
        this.elbowLeftJoint.addBox(-3.0F, -3.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(elbowLeftJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.upperArmLeft = new MowzieModelRenderer(this, 24, 40);
        this.upperArmLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperArmLeft.addBox(-5.0F, -4.0F, -4.0F, 20, 8, 8, 0.0F);
        this.setRotateAngle(upperArmLeft, 0.7853981633974483F, 0.0F, 0.0F);
        this.handLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.handLeftJoint.setRotationPoint(16.0F, 1.0F, 1.0F);
        this.handLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(handLeftJoint, 0.7853981633974483F, 0.0F, 0.0F);
        this.lowerArmLeft = new MowzieModelRenderer(this, 86, 29);
        this.lowerArmLeft.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.lowerArmLeft.addBox(0.0F, -2.0F, -2.0F, 15, 6, 6, 0.0F);
        this.setRotateAngle(lowerArmLeft, -0.7853981633974483F, 0.0F, 0.0F);
        this.shoulderRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.shoulderRightJoint.setRotationPoint(10.0F, 4.0F, 14.9F);
        this.shoulderRightJoint.addBox(-4.0F, -7.0F, -5.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(shoulderRightJoint, -1.0471975511965976F, 0.0F, 0.0F);
        this.groinBack = new MowzieModelRenderer(this, 0, 92);
        this.groinBack.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.groinBack.addBox(-5.0F, 0.0F, -1.0F, 10, 12, 2, 0.0F);
        this.setRotateAngle(groinBack, 0.17453292519943295F, 0.0F, 0.0F);
        this.thighLeftJoint2 = new MowzieModelRenderer(this, 0, 0);
        this.thighLeftJoint2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.thighLeftJoint2.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(thighLeftJoint2, -0.8726646259971648F, 0.0F, 0.0F);
        this.helmet = new MowzieModelRenderer(this, 32, 20);
        this.helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmet.addBox(-4.0F, -10.0F, -4.0F, 8, 12, 8, 0.0F);
        this.lowerArmRight = new MowzieModelRenderer(this, 86, 29);
        this.lowerArmRight.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.lowerArmRight.addBox(0.0F, -4.0F, -4.0F, 15, 6, 6, 0.0F);
        this.setRotateAngle(lowerArmRight, -0.7853981633974483F, 0.0F, 0.0F);
        this.handLeft = new MowzieModelRenderer(this, 98, 14);
        this.handLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handLeft.addBox(-2.0F, -4.0F, -2.0F, 8, 8, 7, 0.0F);
        this.setRotateAngle(handLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.calfLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.calfLeftJoint.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.calfLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(calfLeftJoint, 1.5707963267948966F, -0.7853981633974483F, 0.0F);
        this.chestJoint = new MowzieModelRenderer(this, 0, 0);
        this.chestJoint.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.chestJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(chestJoint, 0.0F, -0.7853981633974483F, 0.0F);
        this.tuskRight2 = new MowzieModelRenderer(this, 110, 97);
        this.tuskRight2.setRotationPoint(6.0F, 1.5F, 0.0F);
        this.tuskRight2.addBox(0.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(tuskRight2, 0.0F, 0.0F, -0.8726646259971648F);
        this.groinJoint = new MowzieModelRenderer(this, 0, 0);
        this.groinJoint.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.groinJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(groinJoint, 0.0F, -0.7853981633974483F, 0.0F);
        this.upperArmRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.upperArmRightJoint.setRotationPoint(5.0F, 1.0F, 1.0F);
        this.upperArmRightJoint.addBox(0.0F, -4.0F, -4.0F, 0, 0, 0, 0.0F);
        this.axeBladeRight3 = new MowzieModelRenderer(this, 56, 0);
        this.axeBladeRight3.setRotationPoint(17.7F, 2.3F, -0.01F);
        this.axeBladeRight3.addBox(-5.5F, 0.0F, -1.0F, 11, 17, 2, 0.0F);
        this.setRotateAngle(axeBladeRight3, 0.0F, 0.0F, 2.6179938779914944F);
        this.footRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.footRightJoint.setRotationPoint(-2.0F, 11.0F, 2.0F);
        this.footRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(footRightJoint, 0.0F, -0.7853981633974483F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-3.0F, -9.0F, -3.0F, 6, 10, 6, 0.0F);
        this.setRotateAngle(head, 0.0F, 0.7853981633974483F, 0.0F);
        this.hornLeft1 = new MowzieModelRenderer(this, 12, 17);
        this.hornLeft1.setRotationPoint(-2.5F, -8.05F, -3.0F);
        this.hornLeft1.addBox(-1.5F, -1.5F, -8.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(hornLeft1, -0.3490658503988659F, 0.0F, 0.0F);
        this.thighRightJoint2 = new MowzieModelRenderer(this, 0, 0);
        this.thighRightJoint2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.thighRightJoint2.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(thighRightJoint2, -0.8726646259971648F, 0.0F, 0.0F);
        this.thighRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.thighRightJoint.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.thighRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(thighRightJoint, 0.0F, -0.7853981633974483F, 0.0F);
        this.tuskLeft1 = new MowzieModelRenderer(this, 13, 60);
        this.tuskLeft1.setRotationPoint(-2.5F, 0.5F, -3.0F);
        this.tuskLeft1.addBox(-1.5F, -1.5F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(tuskLeft1, 0.4363323129985824F, 0.0F, 0.0F);
        this.kneeRight = new MowzieModelRenderer(this, 24, 80);
        this.kneeRight.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.kneeRight.addBox(-3.0F, -1.7F, -3.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(kneeRight, -0.5235987755982988F, -0.7853981633974483F, 0.0F);
        this.axeBladeLeft1 = new MowzieModelRenderer(this, 84, 0);
        this.axeBladeLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axeBladeLeft1.addBox(0.0F, -4.5F, -1.0F, 10, 8, 2, 0.0F);
        this.waist = new MowzieModelRenderer(this, 64, 41);
        this.waist.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.waist.addBox(-8.0F, 0.0F, -8.0F, 16, 6, 16, 0.0F);
        this.setRotateAngle(waist, 0.0F, 0.7853981633974483F, 0.0F);
        this.hornLeft2 = new MowzieModelRenderer(this, 30, 0);
        this.hornLeft2.setRotationPoint(-1.0F, 1.5F, -8.0F);
        this.hornLeft2.addBox(0.0F, -2.0F, -11.0F, 2, 2, 11, 0.0F);
        this.setRotateAngle(hornLeft2, -1.2217304763960306F, 0.0F, 0.0F);
        this.shoulderLeft = new MowzieModelRenderer(this, 21, 56);
        this.shoulderLeft.mirror = true;
        this.shoulderLeft.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.shoulderLeft.addBox(-4.0F, -7.0F, -7.5F, 15, 10, 13, 0.0F);
        this.setRotateAngle(shoulderLeft, 0.0F, 3.141592653589793F, 0.0F);
        this.axeBladeRight = new MowzieModelRenderer(this, 0, 0);
        this.axeBladeRight.setRotationPoint(0.0F, -37.0F, 0.0F);
        this.axeBladeRight.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(axeBladeRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.calfLeft = new MowzieModelRenderer(this, 0, 75);
        this.calfLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.calfLeft.addBox(-4.5F, 0.0F, -0.5F, 5, 12, 5, 0.0F);
        this.setRotateAngle(calfLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.elbowRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.elbowRightJoint.setRotationPoint(15.0F, 1.6F, 1.7F);
        this.elbowRightJoint.addBox(-3.0F, -3.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(elbowRightJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.axeBladeLeft = new MowzieModelRenderer(this, 0, 0);
        this.axeBladeLeft.setRotationPoint(0.0F, -37.0F, 0.0F);
        this.axeBladeLeft.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(axeBladeLeft, 0.0F, -3.9269908169872414F, 0.0F);
        this.thighRight = new MowzieModelRenderer(this, 26, 90);
        this.thighRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.thighRight.addBox(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
        this.setRotateAngle(thighRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.shoulderRight = new MowzieModelRenderer(this, 21, 56);
        this.shoulderRight.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.shoulderRight.addBox(-4.0F, -7.0F, -5.5F, 15, 10, 13, 0.0F);
        this.axeBladeRight1 = new MowzieModelRenderer(this, 84, 0);
        this.axeBladeRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axeBladeRight1.addBox(0.0F, -4.5F, -1.0F, 10, 8, 2, 0.0F);
        this.hornRight2 = new MowzieModelRenderer(this, 16, 44);
        this.hornRight2.setRotationPoint(8.0F, 1.5F, 0.0F);
        this.hornRight2.addBox(0.0F, -2.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(hornRight2, 0.0F, 0.0F, -1.2217304763960306F);
        this.thighLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.thighLeftJoint.setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.thighLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(thighLeftJoint, 0.0F, 0.7853981633974483F, 0.0F);
        this.axeBladeLeft3 = new MowzieModelRenderer(this, 56, 0);
        this.axeBladeLeft3.setRotationPoint(17.7F, 2.3F, -0.01F);
        this.axeBladeLeft3.addBox(-5.5F, 0.0F, -1.0F, 11, 17, 2, 0.01F);
        this.setRotateAngle(axeBladeLeft3, 0.0F, 0.0F, 2.6179938779914944F);
        this.footLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.footLeftJoint.setRotationPoint(-2.0F, 11.0F, 2.0F);
        this.footLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(footLeftJoint, 0.0F, -0.7853981633974483F, 0.0F);
        this.chest = new MowzieModelRenderer(this, 36, 92);
        this.chest.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.chest.addBox(-14.0F, 0.0F, 0.0F, 28, 18, 18, 0.0F);
        this.setRotateAngle(chest, 0.7853981633974483F, 0.0F, 0.0F);
        this.tuskLeft2 = new MowzieModelRenderer(this, 110, 101);
        this.tuskLeft2.setRotationPoint(-1.0F, 1.5F, -6.0F);
        this.tuskLeft2.addBox(0.0F, -2.0F, -7.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(tuskLeft2, -0.8726646259971648F, 0.0F, 0.0F);
        this.upperArmLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.upperArmLeftJoint.setRotationPoint(5.0F, 1.0F, -1.0F);
        this.upperArmLeftJoint.addBox(0.0F, -4.0F, -4.0F, 0, 0, 0, 0.0F);
        this.axeBase = new MowzieModelRenderer(this, 0, 0);
        this.axeBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.axeBase.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.handRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.handRightJoint.setRotationPoint(16.0F, -1.0F, -1.0F);
        this.handRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(handRightJoint, 0.7853981633974483F, 0.0F, 0.0F);
        this.footLeft = new MowzieModelRenderer(this, 48, 79);
        this.footLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footLeft.addBox(-3.0F, 0.0F, -8.0F, 6, 3, 10, 0.0F);
        this.setRotateAngle(footLeft, -0.6981317007977318F, 0.0F, 0.0F);
        this.handRight = new MowzieModelRenderer(this, 98, 14);
        this.handRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handRight.addBox(-2.0F, -4.0F, -2.0F, 8, 8, 7, 0.0F);
        this.setRotateAngle(handRight, 0.0F, 0.7853981633974483F, 0.0F);
        this.lowerArmLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.lowerArmLeftJoint.setRotationPoint(15.0F, 0.0F, 0.0F);
        this.lowerArmLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(lowerArmLeftJoint, 0.7853981633974483F, 0.0F, 0.0F);
        this.hornRight1 = new MowzieModelRenderer(this, 34, 13);
        this.hornRight1.setRotationPoint(3.0F, -8.05F, 2.5F);
        this.hornRight1.addBox(0.0F, -1.5F, -1.5F, 8, 3, 3, 0.0F);
        this.setRotateAngle(hornRight1, 0.0F, 0.0F, -0.3490658503988659F);
        this.tuskRight1 = new MowzieModelRenderer(this, 64, 63);
        this.tuskRight1.setRotationPoint(3.0F, 0.5F, 2.5F);
        this.tuskRight1.addBox(0.0F, -1.5F, -1.5F, 6, 3, 3, 0.0F);
        this.setRotateAngle(tuskRight1, 0.0F, 0.0F, 0.4363323129985824F);
        this.footRight = new MowzieModelRenderer(this, 48, 79);
        this.footRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footRight.addBox(-3.0F, 0.0F, -8.0F, 6, 3, 10, 0.0F);
        this.setRotateAngle(footRight, -0.6981317007977318F, 0.0F, 0.0F);
        this.thighLeft = new MowzieModelRenderer(this, 26, 90);
        this.thighLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.thighLeft.addBox(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
        this.setRotateAngle(thighLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.groinFront = new MowzieModelRenderer(this, 0, 92);
        this.groinFront.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.groinFront.addBox(-5.0F, 0.0F, -1.0F, 10, 12, 2, 0.0F);
        this.setRotateAngle(groinFront, -0.17453292519943295F, 0.0F, 0.0F);
        this.elbowLeft = new MowzieModelRenderer(this, 70, 24);
        this.elbowLeft.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.elbowLeft.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 5, 0.0F);
        this.axeBladeRight2 = new MowzieModelRenderer(this, 56, 0);
        this.axeBladeRight2.mirror = true;
        this.axeBladeRight2.setRotationPoint(17.7F, -3.2F, 0.01F);
        this.axeBladeRight2.addBox(-5.5F, 0.0F, -1.0F, 11, 17, 2, 0.0F);
        this.setRotateAngle(axeBladeRight2, 0.0F, 0.0F, 0.5235987755982988F);
        this.shoulderLeftJoint = new MowzieModelRenderer(this, 0, 0);
        this.shoulderLeftJoint.setRotationPoint(-10.0F, 4.0F, 14.9F);
        this.shoulderLeftJoint.addBox(-4.0F, -7.0F, -5.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(shoulderLeftJoint, -1.0471975511965976F, 0.0F, 0.0F);
        this.stomachJoint = new MowzieModelRenderer(this, 0, 0);
        this.stomachJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stomachJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(stomachJoint, 0.2617993877991494F, -0.7853981633974483F, 0.0F);
        this.axeBladeLeft2 = new MowzieModelRenderer(this, 56, 0);
        this.axeBladeLeft2.mirror = true;
        this.axeBladeLeft2.setRotationPoint(17.7F, -3.2F, 0.01F);
        this.axeBladeLeft2.addBox(-5.5F, 0.0F, -1.0F, 11, 17, 2, 0.0F);
        this.setRotateAngle(axeBladeLeft2, 0.0F, 0.0F, 0.5235987755982988F);
        this.calfRightJoint = new MowzieModelRenderer(this, 0, 0);
        this.calfRightJoint.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.calfRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(calfRightJoint, 1.5707963267948966F, -0.7853981633974483F, 0.0F);
        this.upperArmRight = new MowzieModelRenderer(this, 24, 40);
        this.upperArmRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperArmRight.addBox(-5.0F, -4.0F, -4.0F, 20, 8, 8, 0.0F);
        this.setRotateAngle(upperArmRight, 0.7853981633974483F, 0.0F, 0.0F);
        this.groin = new MowzieModelRenderer(this, 0, 106);
        this.groin.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.groin.addBox(-3.0F, -5.5F, -5.5F, 6, 11, 11, 0.0F);
        this.setRotateAngle(groin, -0.7853981633974483F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.0F, -1.4F, 15.1F);
        this.neck.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neck, -1.0471975511965976F, 0.0F, 0.0F);
        this.waistBendController = new MowzieModelRenderer(this, 0, 0);
        this.waistBendController.setRotationPoint(0.0F, 0F, 0F);
        this.waistBendController.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(waistBendController, 0.0F, 0.0F, 0.0F);

        this.waist.addChild(this.groinJoint);
        this.upperArmRightJoint.addChild(this.upperArmRight);
        this.helmet.addChild(this.tuskRight1);
        this.shoulderRight.addChild(this.upperArmRightJoint);
        this.axeBase.addChild(this.axeHandle);
        this.footRightJoint.addChild(this.footRight);
        this.head.addChild(this.helmet);
        this.calfRight.addChild(this.footRightJoint);
        this.axeBladeLeft.addChild(this.axeBladeLeft1);
        this.thighRightJoint.addChild(this.thighRightJoint2);
        this.axeBladeRight.addChild(this.axeBladeRight2);
        this.elbowLeftJoint.addChild(this.elbowLeft);
        this.lowerArmRight.addChild(this.handRightJoint);
        this.upperArmLeft.addChild(this.elbowLeftJoint);
        this.lowerArmLeft.addChild(this.handLeftJoint);
        this.axeBladeLeft.addChild(this.axeBladeLeft3);
        this.axeBladeLeft.addChild(this.axeBladeLeft2);
        this.axeHandle.addChild(this.axeBladeLeft);
        this.shoulderLeftJoint.addChild(this.shoulderLeft);
        this.thighLeftJoint.addChild(this.thighLeftJoint2);
        this.upperArmRight.addChild(this.lowerArmRightJoint);
        this.chest.addChild(this.shoulderRightJoint);
        this.upperArmLeftJoint.addChild(this.upperArmLeft);
        this.calfLeft.addChild(this.footLeftJoint);
        this.handLeftJoint.addChild(this.handLeft);
        this.footLeftJoint.addChild(this.footLeft);
        this.thighLeft.addChild(this.calfLeftJoint);
        this.tuskLeft1.addChild(this.tuskLeft2);
        this.stomach.addChild(this.chestJoint);
        this.groinJoint.addChild(this.thighLeftJoint);
        this.handRight.addChild(this.axeBase);
        this.chestJoint.addChild(this.chest);
        this.calfLeftJoint.addChild(this.calfLeft);
        this.chest.addChild(this.shoulderLeftJoint);
        this.elbowRightJoint.addChild(this.elbowRight);
        this.thighRightJoint2.addChild(this.thighRight);
        this.groinJoint.addChild(this.groinFront);
        this.tuskRight1.addChild(this.tuskRight2);
        this.handRightJoint.addChild(this.handRight);
        this.helmet.addChild(this.hornLeft1);
        this.shoulderRightJoint.addChild(this.shoulderRight);
        this.stomachJoint.addChild(this.stomach);
        this.axeBladeRight.addChild(this.axeBladeRight3);
        this.lowerArmLeftJoint.addChild(this.lowerArmLeft);
        this.calfRightJoint.addChild(this.calfRight);
        this.groinJoint.addChild(this.groinBack);
        this.hornLeft1.addChild(this.hornLeft2);
        this.thighRight.addChild(this.calfRightJoint);
        this.groinJoint.addChild(this.thighRightJoint);
        this.helmet.addChild(this.tuskLeft1);
        this.thighRight.addChild(this.kneeRight);
        this.thighLeft.addChild(this.kneeLeft);
        this.thighLeftJoint2.addChild(this.thighLeft);
        this.chest.addChild(this.neck);
        this.neck.addChild(this.head);
        this.upperArmRight.addChild(this.elbowRightJoint);
        this.hornRight1.addChild(this.hornRight2);
        this.lowerArmRightJoint.addChild(this.lowerArmRight);
        this.waist.addChild(this.stomachJoint);
        this.axeHandle.addChild(this.axeBladeRight);
        this.shoulderLeft.addChild(this.upperArmLeftJoint);
        this.helmet.addChild(this.hornRight1);
        this.axeBladeRight.addChild(this.axeBladeRight1);
        this.upperArmLeft.addChild(this.lowerArmLeftJoint);
        addChildTo(groin, groinJoint);

        //Corrections
        groin.rotateAngleY -= 45 * Math.PI/180;

        parts = new MowzieModelRenderer[] {waist, groin, stomachJoint, groinJoint, stomach, chestJoint, chest, neck, shoulderRightJoint, shoulderLeftJoint, head, helmet, tuskRight1, tuskLeft1, hornRight1, hornLeft1, tuskRight2, tuskLeft2, hornRight2, hornLeft2, shoulderRight, upperArmRightJoint, upperArmRight, lowerArmRightJoint, elbowRightJoint, lowerArmRight, handRightJoint, handRight, axeBase, axeHandle, axeBladeRight, axeBladeLeft, axeBladeRight1, axeBladeRight2, axeBladeRight3, axeBladeLeft1, axeBladeLeft2, axeBladeLeft3, elbowRight, shoulderLeft, upperArmLeftJoint, upperArmLeft, lowerArmLeftJoint, elbowLeftJoint, lowerArmLeft, handLeftJoint, handLeft, elbowLeft, groinFront, groinBack, thighRightJoint, thighLeftJoint, thighRightJoint2, thighRight, calfRightJoint, kneeRight, calfRight, footRightJoint, footRight, thighLeftJoint2, thighLeft, calfLeftJoint, kneeLeft, calfLeft, footLeftJoint, footLeft, waistBendController};
        setInitPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(f, f1, f2, f3, f4, f5, entity);
        this.waist.render(f5);
    }

    public void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z) {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityWroughtnaut entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        setToInitPose();
        EntityWroughtnaut wn = entity;
        shoulderLeft.rotateAngleZ -= 0.4;
        shoulderRight.rotateAngleZ += 0.35;
        shoulderLeft.rotateAngleY -= 0.3;
        shoulderRight.rotateAngleY += 0.2;
        upperArmLeft.rotateAngleZ += 0.5;
        upperArmRight.rotateAngleZ += 0.5;
        upperArmLeft.rotateAngleY -= 0.5;
        upperArmRight.rotateAngleY += 0.3;
        lowerArmLeft.rotateAngleZ += 1.5;
        lowerArmRight.rotateAngleZ -= 1.3;
        lowerArmLeft.rotateAngleY += 0.3;
        lowerArmRight.rotateAngleY += 0.7;
        handRight.rotateAngleZ += 0.3;
        handRight.rotateAngleX -= 0.2;
        handLeftJoint.rotateAngleX += 1.6;
        handLeftJoint.rotateAngleZ -= 0.5;
        axeHandle.rotateAngleY += 0.8;

        head.rotateAngleY += f3 / (180f / (float) Math.PI);
        neck.rotateAngleX += f4 / (180f / (float) Math.PI);

        f = (float) wn.walkFrame;
        f1 = wn.walkAnim.getAnimationProgressSinSqrt();

        float globalSpeed = (float) (Math.PI * 0.05);
        float globalDegree = 0.8F;
        float height = 2F;

        //groinJoint.rotationPointY -= 1 * f1;
        waist.rotationPointZ -= f1 * 4 * Math.pow(Math.sin(globalSpeed*(wn.frame - 15)), 2);
        bob(waist, 2F * globalSpeed, 1 * height, false, f, f1);
        swing(waist, 1F * globalSpeed, 0.3F * globalDegree, false, 0, 0, f, f1);
        swing(stomachJoint, 1F * globalSpeed, 0.6F * globalDegree, true, 0, 0, f, f1);
        swing(head, 1F * globalSpeed, 0.3F * globalDegree, false, 0, 0, f, f1);

        swing(thighLeftJoint, 1F * globalSpeed, 0.4F * globalDegree, true, 0, -0.5F, f, f1);
        walk(thighLeftJoint, 1F * globalSpeed, 0.4F * globalDegree, false, 0, 0.3F * globalDegree, f, f1);
        walk(calfLeftJoint, 1F * globalSpeed, 0.5F * globalDegree, false, -2.2F, 0.1F * globalDegree, f, f1);
        walk(footLeftJoint, 1F * globalSpeed, 0.4F * globalDegree, false, -2.1F, 0.26F * globalDegree, f, f1);

        swing(thighRightJoint, 1F * globalSpeed, 0.4F * globalDegree, true, 0, 0.5F, f, f1);
        walk(thighRightJoint, 1F * globalSpeed, 0.4F * globalDegree, true, 0, 0.3F * globalDegree, f, f1);
        walk(calfRightJoint, 1F * globalSpeed, 0.5F * globalDegree, true, -2.2F, 0.1F * globalDegree, f, f1);
        walk(footRightJoint, 1F * globalSpeed, 0.4F * globalDegree, true, -2.1F, 0.26F * globalDegree, f, f1);

        walk(groinFront, 2F * globalSpeed, 0.2F * 0.8F, true, -0.5F, -0.1F, f, f1);
        walk(groinBack, 2F * globalSpeed, 0.2F * 0.8F, false, -0.5F, 0.1F, f, f1);
        walk(neck, 2F * globalSpeed, 0.1F * 0.8F, true, -0.5F, 0.1F, f, f1);

        flap(shoulderLeft, 2F * globalSpeed, 0.05F * 0.8F, false, -0.5F, 0F, f, f1);
        flap(shoulderRight, 2F * globalSpeed, 0.05F * 0.8F, true, -0.5F, 0F, f, f1);
        swing(shoulderLeft, 1F * globalSpeed, 0.1F * 0.8F, true, 0F, 0.3F, f, f1);
        swing(shoulderRight, 1F * globalSpeed, 0.1F * 0.8F, true, 0F, 0.3F, f, f1);
        flap(upperArmLeftJoint, 2F * globalSpeed, 0.05F * 0.8F, true, -1F, 0F, f, f1);
        flap(upperArmRightJoint, 2F * globalSpeed, 0.05F * 0.8F, true, -1F, 0F, f, f1);
        flap(handLeft, 2 * globalSpeed, 0.2F, false, -0.5F, 0.5F, f, f1);
        walk(lowerArmLeftJoint, 2 * globalSpeed, 0.1F, true, -0.5F, 0, f, f1);
        walk(handLeft, 2 * globalSpeed, 0.2F, false, -0.5F, 0.6F, f, f1);
        lowerArmLeftJoint.rotateAngleY -= 0.65F * f1;
    }

    public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        animator.update((EntityWroughtnaut) entity);
        EntityWroughtnaut entityWroughtnaut = (EntityWroughtnaut) entity;
        setRotationAngles(f, f1, f2, f3, f4, f5, entityWroughtnaut);

        if (entityWroughtnaut.getAnimID() == MMAnimation.ATTACK.id) {
            if (entityWroughtnaut.swingDirection == false) {
                animator.setAnim(MMAnimation.ATTACK.animID());
                animator.setStationaryPhase(6);
                animator.startPhase(15);
                animator.rotate(stomachJoint, -0.2F, 0.5F, 0);
                animator.rotate(waist, 0, 0.5F, -0.2F);
                animator.move(waist, -3, 1F, 1);
                animator.rotate(head, 0F, -0.8F, 0);
                animator.rotate(neck, 0F, 0F, 0);

                animator.rotate(shoulderRight, 0, 0.1F, 0);
                animator.rotate(upperArmRightJoint, -0.5F, 0.2F, 0);
                animator.rotate(lowerArmRightJoint, 0.2F, 0.3F, 0);
                animator.rotate(handRight, -0.5F, 0.3F, 0.1F);
                animator.rotate(axeHandle, 0, 0.5F, 0);

                animator.rotate(shoulderLeft, 0, 0F, 0);
                animator.rotate(upperArmLeftJoint, 0.2F, 0F, 0);
                animator.rotate(lowerArmLeftJoint, 0.1F, -0.3F, 0);
                animator.rotate(handLeft, 0F, 0.5F, -0.3F);

                animator.rotate(thighRightJoint, -0.7F, 0, 0);
                animator.rotate(thighRightJoint2, 0F, 0.2F, 0.5F);
                animator.rotate(calfRightJoint, 0.3F, 0, 0);

                animator.rotate(thighLeftJoint, -0.2F, 0, 0);
                animator.rotate(thighLeftJoint2, 0F, -0.5F, -0.05F);
                animator.rotate(calfLeftJoint, 0.1F, 0, 0);
                animator.rotate(footLeftJoint, -0.1F, 0, 0);
                animator.endPhase();

                animator.setStationaryPhase(5);

                animator.startPhase(6);
                animator.rotate(stomachJoint, 0.3F, -1.3F, 0);
                animator.rotate(waist, 0, 0.5F, 0F);
                animator.move(waist, 2, 2, -7);
                animator.rotate(head, 0F, 0.8F, 0);
                animator.move(waistBendController, 7, 0, 0);

                animator.rotate(shoulderRight, 0, -0.6F, 0);
                animator.rotate(upperArmRightJoint, -0.8F, -0.9F, 0);
                animator.rotate(lowerArmRightJoint, 0.4F, 0.9F, 0F);
                animator.rotate(handRight, -0.8F, 0F, 0F);
                animator.rotate(axeHandle, 0, 1.2F, 0);

                animator.rotate(shoulderLeft, 0, -0.7F, 0);
                animator.move(shoulderLeft, 1, 0F, 0);
                animator.rotate(upperArmLeftJoint, 0.2F, -0.5F, 0);
                animator.move(upperArmLeft, 5F, 2F, 5F);
                animator.rotate(lowerArmLeftJoint, -0.5F, -0.3F, -0.7F);
                animator.move(lowerArmLeft, 0F, 2F, 0F);
                animator.rotate(handLeft, 2F, -0.3F, 0.5F);
                animator.rotate(handLeftJoint, 0F, -0.5F, -0.5F);

                animator.rotate(thighRightJoint, -0.4F, 0, 0);
                animator.rotate(thighRightJoint2, 0F, 0.2F, 0);
                animator.rotate(calfRightJoint, -0.1F, 0, 0);
                animator.rotate(footRightJoint, 0.5F, 0, 0);

                animator.rotate(thighLeftJoint, 0F, 0, 0);
                animator.rotate(thighLeftJoint2, 0F, -0.3F, 0.5F);
                animator.rotate(calfLeftJoint, -0.1F, 0, 0);
                animator.rotate(footLeftJoint, 0F, 0, 0);

                animator.endPhase();
                animator.setStationaryPhase(8);
                animator.resetPhase(10);
                float frame = waistBendController.rotationPointX;
                if (entityWroughtnaut.getAnimTick() <= 33) {
                    stomachJoint.rotateAngleX += 0.06 * -frame * (frame - 7);
                    neck.rotateAngleX -= 0.06 * -frame * (frame - 7);
                }
            }
            else {
                animator.setAnim(MMAnimation.ATTACK.animID());
                animator.setStationaryPhase(6);
                animator.startPhase(15);
                animator.rotate(stomachJoint, 0.2F, -0.5F, 0);
                animator.rotate(waist, 0, -0.5F, 0.2F);
                animator.move(waist, 3, 1F, -1);
                animator.rotate(head, 0F, 0F, 0);
                animator.rotate(neck, 0F, 0F, 0);

                animator.rotate(shoulderRight, 0, -0.6F, 0);
                animator.rotate(upperArmRightJoint, -0.8F, -0.9F, 0);
                animator.rotate(lowerArmRightJoint, 0.4F, 0.9F, 0F);
                animator.rotate(handRight, -0.8F, 0F, 0F);
                animator.rotate(axeHandle, 0, 1.2F, 0);

                animator.rotate(shoulderLeft, 0, -0.7F, 0);
                animator.move(shoulderLeft, 1, 0F, 0);
                animator.rotate(upperArmLeftJoint, 0.2F, -0.5F, 0);
                animator.move(upperArmLeft, 5F, 2F, 5F);
                animator.rotate(lowerArmLeftJoint, -0.5F, -0.3F, -0.7F);
                animator.move(lowerArmLeft, 0F, 3F, 0F);
                animator.rotate(handLeft, 2F, -0.3F, 0.5F);
                animator.rotate(handLeftJoint, 0F, -0.5F, -0.5F);

                animator.rotate(thighLeftJoint, -0.7F, 0, 0);
                animator.rotate(thighLeftJoint2, 0F, -0.2F, -0.5F);
                animator.rotate(calfLeftJoint, 0.3F, 0, 0);

                animator.rotate(thighRightJoint, -0.2F, 0, 0);
                animator.rotate(thighRightJoint2, 0F, 0.5F, 0.05F);
                animator.rotate(calfRightJoint, 0.1F, 0, 0);
                animator.rotate(footRightJoint, -0.1F, 0, 0);
                animator.endPhase();

                animator.setStationaryPhase(5);

                animator.startPhase(6);
                animator.rotate(stomachJoint, 0.3F, 1.3F, 0);
                animator.rotate(waist, 0, -0.5F, 0F);
                animator.move(waist, -2, 2, -7);
                animator.rotate(head, 0F, -0.8F, 0);
                animator.move(waistBendController, 7, 0, 0);

                animator.rotate(shoulderRight, 0, 0.1F, 0);
                animator.rotate(upperArmRightJoint, -0.5F, 0.2F, 0);
                animator.rotate(lowerArmRightJoint, 0.2F, 0.3F, 0);
                animator.rotate(handRight, -0.5F, 0.3F, 0.1F);
                animator.rotate(axeHandle, 0, 0.5F, 0);

                animator.rotate(shoulderLeft, 0, 0F, 0);
                animator.rotate(upperArmLeftJoint, 0.2F, 0F, 0);
                animator.rotate(lowerArmLeftJoint, 0.1F, -0.3F, 0);
                animator.rotate(handLeft, 0F, 0.5F, -0.3F);

                animator.rotate(thighLeftJoint, -0.4F, 0, 0);
                animator.rotate(thighLeftJoint2, 0F, -0.2F, 0);
                animator.rotate(calfLeftJoint, -0.1F, 0, 0);
                animator.rotate(footLeftJoint, 0.5F, 0, 0);

                animator.rotate(thighRightJoint, 0F, 0, 0);
                animator.rotate(thighRightJoint2, 0F, 0.3F, -0.5F);
                animator.rotate(calfRightJoint, -0.1F, 0, 0);
                animator.rotate(footRightJoint, 0F, 0, 0);

                animator.endPhase();
                animator.setStationaryPhase(8);
                animator.resetPhase(10);
                float frame = waistBendController.rotationPointX;
                if (entityWroughtnaut.getAnimTick() <= 33) {
                    stomachJoint.rotateAngleX += 0.06 * -frame * (frame - 7);
                    neck.rotateAngleX -= 0.06 * -frame * (frame - 7);
                }
            }
        }
    }
}
