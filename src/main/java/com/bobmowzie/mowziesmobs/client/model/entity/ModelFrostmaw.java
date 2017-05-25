package com.bobmowzie.mowziesmobs.client.model.entity;

import com.bobmowzie.mowziesmobs.client.model.tools.LegArticulator;
import com.bobmowzie.mowziesmobs.server.entity.EntityFrostmaw;
import net.ilexiconn.llibrary.LLibrary;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;

/**
 * Created by Josh on 5/8/2017.
 */
public class ModelFrostmaw extends AdvancedModelBase {
    public AdvancedModelRenderer root;
    public AdvancedModelRenderer waist;
    public AdvancedModelRenderer chest;
    public AdvancedModelRenderer legLeftJoint;
    public AdvancedModelRenderer legRightJoint;
    public AdvancedModelRenderer headJoint;
    public AdvancedModelRenderer armLeftJoint;
    public AdvancedModelRenderer armRightJoint;
    public AdvancedModelRenderer headRotator;
    public AdvancedModelRenderer antlerLeft;
    public AdvancedModelRenderer antlerRight;
    public AdvancedModelRenderer head;
    public AdvancedModelRenderer jawJoint;
    public AdvancedModelRenderer teethUpper;
    public AdvancedModelRenderer headBack;
    public AdvancedModelRenderer eyeLidRight;
    public AdvancedModelRenderer eyeLidLeft;
    public AdvancedModelRenderer jawRotator;
    public AdvancedModelRenderer jaw;
    public AdvancedModelRenderer tuskLeftJoint;
    public AdvancedModelRenderer tuskRightJoint;
    public AdvancedModelRenderer jawSpikes1;
    public AdvancedModelRenderer jawSpikes2;
    public AdvancedModelRenderer teethLower;
    public AdvancedModelRenderer tuskLeft1;
    public AdvancedModelRenderer tuskLeft2;
    public AdvancedModelRenderer tuskRight1;
    public AdvancedModelRenderer tuskRight2;
    public AdvancedModelRenderer armLeft1;
    public AdvancedModelRenderer armLeftJoint2;
    public AdvancedModelRenderer armLeft2;
    public AdvancedModelRenderer leftHandJoint;
    public AdvancedModelRenderer armLeft2Fur;
    public AdvancedModelRenderer leftHand;
    public AdvancedModelRenderer leftFingersJoint;
    public AdvancedModelRenderer leftThumb;
    public AdvancedModelRenderer leftFingers;
    public AdvancedModelRenderer armRight1;
    public AdvancedModelRenderer armRightJoint2;
    public AdvancedModelRenderer armRight2;
    public AdvancedModelRenderer leftRightJoint;
    public AdvancedModelRenderer armRight2Fur;
    public AdvancedModelRenderer rightHand;
    public AdvancedModelRenderer rightFingersJoint;
    public AdvancedModelRenderer rightThumb;
    public AdvancedModelRenderer rightFingers;
    public AdvancedModelRenderer legLeft1;
    public AdvancedModelRenderer legLeft2;
    public AdvancedModelRenderer leftFoot;
    public AdvancedModelRenderer legLeftFur;
    public AdvancedModelRenderer legRight1;
    public AdvancedModelRenderer legRight2;
    public AdvancedModelRenderer rightFoot;
    public AdvancedModelRenderer legRightFur;
    public AdvancedModelRenderer chestJoint;
    public AdvancedModelRenderer handController;
    public AdvancedModelRenderer swingOffsetController;
    public AdvancedModelRenderer roarController;

    private ModelAnimator animator;

    public ModelFrostmaw() {
        this.textureWidth = 512;
        this.textureHeight = 256;
        animator = ModelAnimator.create();
        this.leftHand = new AdvancedModelRenderer(this, 240, 0);
        this.leftHand.mirror = true;
        this.leftHand.setRotationPoint(-2.0F, 1.0F, -4.5F);
        this.leftHand.addBox(-10.0F, -2.0F, -7.5F, 20, 20, 9, 0.0F);
        this.setRotateAngle(leftHand, 0.0F, 0.3490658503988659F, 0.0F);
        this.legLeft2 = new AdvancedModelRenderer(this, 81, 77);
        this.legLeft2.setRotationPoint(0.0F, 0.0F, -15.0F);
        this.legLeft2.addBox(-7.0F, -6.0F, -12.0F, 14, 14, 16, 0.0F);
        this.setRotateAngle(legLeft2, 1.2217304763960306F, 0.0F, 0.0F);
        this.rightThumb = new AdvancedModelRenderer(this, 63, 0);
        this.rightThumb.mirror = true;
        this.rightThumb.setRotationPoint(10.0F, 0.5F, -5.0F);
        this.rightThumb.addBox(0.0F, -2.5F, -2.5F, 12, 6, 6, 0.0F);
        this.legRight1 = new AdvancedModelRenderer(this, 37, 56);
        this.legRight1.mirror = true;
        this.legRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legRight1.addBox(-4.5F, -4.5F, -17.0F, 9, 11, 21, 0.0F);
        this.setRotateAngle(legRight1, 0.7853981633974483F, 0.6981317007977318F, 0.0F);
        this.tuskRight2 = new AdvancedModelRenderer(this, 0, 80);
        this.tuskRight2.setRotationPoint(1.0F, -7.0F, 0.0F);
        this.tuskRight2.addBox(-10.0F, -2.0F, -2.0F, 11, 4, 4, 0.0F);
        this.setRotateAngle(tuskRight2, 0.0F, 0.0F, 0.5235987755982988F);
        this.jawRotator = new AdvancedModelRenderer(this, 0, 0);
        this.jawRotator.setRotationPoint(0.0F, 7.353768176172814F, -12.24856180331474F);
        this.jawRotator.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(jawRotator, 0.0F, 0.7853981633974483F, 0.0F);
        this.leftThumb = new AdvancedModelRenderer(this, 63, 0);
        this.leftThumb.setRotationPoint(-10.0F, 0.5F, -5.0F);
        this.leftThumb.addBox(-12.0F, -2.5F, -2.5F, 12, 6, 6, 0.0F);
        this.armRightJoint2 = new AdvancedModelRenderer(this, 67, 0);
        this.armRightJoint2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.armRightJoint2.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armRightJoint2, -0.1710422666954443F, -0.15079644737231007F, -0.7155849933176751F);
        this.legLeft1 = new AdvancedModelRenderer(this, 37, 56);
        this.legLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legLeft1.addBox(-4.5F, -4.5F, -17.0F, 9, 11, 21, 0.0F);
        this.setRotateAngle(legLeft1, 0.7853981633974483F, -0.6981317007977318F, 0.0F);
        this.teethUpper = new AdvancedModelRenderer(this, 376, 0);
        this.teethUpper.setRotationPoint(14.0F, 12.0F, -14.0F);
        this.teethUpper.addBox(-13.0F, 0.0F, -13.0F, 26, 6, 26, 0.0F);
        this.leftHandJoint = new AdvancedModelRenderer(this, 8, 0);
        this.leftHandJoint.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.leftHandJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leftHandJoint, 0.8726646259971648F, -0.3490658503988659F, -0.2617993877991494F);
        this.jawSpikes2 = new AdvancedModelRenderer(this, 212, 104);
        this.jawSpikes2.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.jawSpikes2.addBox(-19.0F, 0.0F, -19.0F, 38, 9, 38, 0.0F);
        this.antlerLeft = new AdvancedModelRenderer(this, 178, 77);
        this.antlerLeft.mirror = true;
        this.antlerLeft.setRotationPoint(22.0F, -6.0F, -15.0F);
        this.antlerLeft.addBox(-15.0F, -40.0F, 0.0F, 30, 43, 0, 0.0F);
        this.setRotateAngle(antlerLeft, -0.9599310885968813F, 0.3490658503988659F, 0.08726646259971647F);
        this.rightHand = new AdvancedModelRenderer(this, 240, 0);
        this.rightHand.setRotationPoint(2.0F, 1.0F, -4.5F);
        this.rightHand.addBox(-10.0F, -2.0F, -7.52F, 20, 20, 9, 0.0F);
        this.setRotateAngle(rightHand, 0.0F, -0.3490658503988659F, 0.0F);
        this.armLeft1 = new AdvancedModelRenderer(this, 0, 88);
        this.armLeft1.mirror = true;
        this.armLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armLeft1.addBox(-8.5F, -10.0F, -8.5F, 17, 34, 17, 0.0F);
        this.setRotateAngle(armLeft1, 0.22759093446006054F, 0.0F, -0.7285004297824331F);
        this.leftFoot = new AdvancedModelRenderer(this, 80, 12);
        this.leftFoot.setRotationPoint(0.0F, 0.2F, -12.0F);
        this.leftFoot.addBox(-6.5F, -14.75F, -6.3F, 13, 20, 6, 0.0F);
        this.setRotateAngle(leftFoot, -0.4363323129985824F, 0.0F, 0.0F);
        this.rightFingers = new AdvancedModelRenderer(this, 0, 62);
        this.rightFingers.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.rightFingers.addBox(-10.0F, -7.5F, -2.5F, 20, 10, 5, 0.0F);
        this.jawJoint = new AdvancedModelRenderer(this, 0, 0);
        this.jawJoint.setRotationPoint(6.41F, 11.0F, -6.41F);
        this.jawJoint.addBox(0.0F, -5.65F, -4.25F, 0, 0, 0, 0.0F);
        this.setRotateAngle(jawJoint, -0.17453292519943295F, -0.7853981633974483F, 0.0F);
        this.leftFingers = new AdvancedModelRenderer(this, 0, 62);
        this.leftFingers.mirror = true;
        this.leftFingers.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.leftFingers.addBox(-10.0F, -7.5F, -2.5F, 20, 10, 5, 0.0F);
        this.headRotator = new AdvancedModelRenderer(this, 0, 0);
        this.headRotator.setRotationPoint(0.0F, -6.0F, -16.0F);
        this.headRotator.addBox(0.0F, 0.0F, -0.1F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headRotator, 0.0F, 0.7853981633974483F, 0.0F);
        this.armLeft2Fur = new AdvancedModelRenderer(this, 326, 113);
        this.armLeft2Fur.setRotationPoint(0.0F, 28.0F, 0.0F);
        this.armLeft2Fur.addBox(-11.0F, -5.0F, -11.0F, 22, 7, 22, 0.0F);
        this.armRightJoint = new AdvancedModelRenderer(this, 0, 0);
        this.armRightJoint.setRotationPoint(-28.0F, 0.0F, -15.0F);
        this.armRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armRightJoint, 0.08726646259971647F, 0.0F, 0.0F);
        this.jaw = new AdvancedModelRenderer(this, 242, 52);
        this.jaw.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.jaw.addBox(-19.0F, 0.0F, -19.0F, 38, 14, 38, 0.0F);
        this.eyeLidLeft = new AdvancedModelRenderer(this, 92, 107);
        this.eyeLidLeft.mirror = true;
        this.eyeLidLeft.setRotationPoint(30.01F, -5.0F, -12.5F);
        this.eyeLidLeft.addBox(-7.5F, 0.0F, 0.0F, 15, 14, 0, 0.0F);
        this.setRotateAngle(eyeLidLeft, 0.0F, -1.5707963267948966F, 0.0F);
        this.jawSpikes1 = new AdvancedModelRenderer(this, 380, 48);
        this.jawSpikes1.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.jawSpikes1.addBox(-14.0F, 0.0F, -14.0F, 28, 14, 28, 0.0F);
        this.tuskRightJoint = new AdvancedModelRenderer(this, 0, 0);
        this.tuskRightJoint.setRotationPoint(-12.0F, 0.0F, -19.0F);
        this.tuskRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tuskRightJoint, 0.0F, 1.5707963267948966F, 0.0F);
        this.antlerRight = new AdvancedModelRenderer(this, 178, 77);
        this.antlerRight.setRotationPoint(-22.0F, -6.0F, -15.0F);
        this.antlerRight.addBox(-15.0F, -40.0F, 0.0F, 30, 43, 0, 0.0F);
        this.setRotateAngle(antlerRight, -0.9599310885968813F, -0.3490658503988659F, -0.08726646259971647F);
        this.armRight2Fur = new AdvancedModelRenderer(this, 326, 113);
        this.armRight2Fur.setRotationPoint(0.0F, 28.0F, 0.0F);
        this.armRight2Fur.addBox(-11.0F, -5.0F, -11.0F, 22, 7, 22, 0.0F);
        this.legRightFur = new AdvancedModelRenderer(this, 144, 77);
        this.legRightFur.mirror = true;
        this.legRightFur.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.legRightFur.addBox(-7.0F, -6.0F, -12.0F, 14, 14, 3, 0.0F);
        this.tuskLeft2 = new AdvancedModelRenderer(this, 0, 80);
        this.tuskLeft2.setRotationPoint(1.0F, -7.0F, 0.0F);
        this.tuskLeft2.addBox(-10.0F, -2.0F, -2.0F, 11, 4, 4, 0.0F);
        this.setRotateAngle(tuskLeft2, 0.0F, 0.0F, 0.5235987755982988F);
        this.legRightJoint = new AdvancedModelRenderer(this, 0, 0);
        this.legRightJoint.setRotationPoint(-9.0F, 3.14F, 0.0F);
        this.legRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legRightJoint, -0.6981317007977318F, 0.0F, 0.0F);
        this.tuskRight1 = new AdvancedModelRenderer(this, 68, 109);
        this.tuskRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tuskRight1.addBox(-3.0F, -8.0F, -3.0F, 6, 13, 6, 0.0F);
        this.setRotateAngle(tuskRight1, 0.0F, 0.0F, 2.0943951023931953F);
        this.rightFingersJoint = new AdvancedModelRenderer(this, 0, 47);
        this.rightFingersJoint.setRotationPoint(0.0F, 15.5F, -3.0F);
        this.rightFingersJoint.addBox(-10.0F, -2.5F, 0.0F, 20, 5, 7, 0.0F);
        this.teethLower = new AdvancedModelRenderer(this, 383, 120);
        this.teethLower.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teethLower.addBox(-14.0F, -6.0F, -17.0F, 31, 6, 31, 0.0F);
        this.chest = new AdvancedModelRenderer(this, 80, 0);
        this.chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.chest.addBox(-30.0F, -25.0F, -30.0F, 60, 37, 40, 0.0F);
        this.setRotateAngle(chest, 0.0F, 0.0F, 0.0F);
        this.chestJoint = new AdvancedModelRenderer(this, 80, 0);
        this.chestJoint.setRotationPoint(0.0F, -24.96F, -1.0F);
        this.setRotateAngle(chestJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.leftFingersJoint = new AdvancedModelRenderer(this, 0, 47);
        this.leftFingersJoint.mirror = true;
        this.leftFingersJoint.setRotationPoint(0.0F, 15.5F, -3.0F);
        this.leftFingersJoint.addBox(-10.0F, -2.5F, 0.0F, 20, 5, 7, 0.0F);
        this.headBack = new AdvancedModelRenderer(this, 0, 139);
        this.headBack.setRotationPoint(14.0F, 12.0F, -14.0F);
        this.headBack.addBox(-16.0F, 0.0F, -16.0F, 32, 6, 32, 0.0F);
        this.legRight2 = new AdvancedModelRenderer(this, 81, 77);
        this.legRight2.mirror = true;
        this.legRight2.setRotationPoint(0.0F, 0.0F, -15.0F);
        this.legRight2.addBox(-7.0F, -6.0F, -12.0F, 14, 14, 16, 0.0F);
        this.setRotateAngle(legRight2, 1.2217304763960306F, 0.0F, 0.0F);
        this.eyeLidRight = new AdvancedModelRenderer(this, 92, 107);
        this.eyeLidRight.setRotationPoint(12.5F, -5.0F, -30.01F);
        this.eyeLidRight.addBox(-7.5F, 0.0F, 0.0F, 15, 14, 0, 0.0F);
        this.armLeftJoint = new AdvancedModelRenderer(this, 0, 0);
        this.armLeftJoint.setRotationPoint(28.0F, 0.0F, -15.0F);
        this.armLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armLeftJoint, 0.08726646259971647F, 0.0F, 0.0F);
        this.armLeftJoint2 = new AdvancedModelRenderer(this, 4, 0);
        this.armLeftJoint2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.armLeftJoint2.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armLeftJoint2, -0.1710422666954443F, 0.15079644737231007F, 0.7155849933176751F);
        this.armLeft2 = new AdvancedModelRenderer(this, 112, 109);
        this.armLeft2.mirror = true;
        this.armLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armLeft2.addBox(-11.0F, -5.0F, -11.0F, 22, 28, 22, 0.0F);
        this.setRotateAngle(armLeft2, -0.8726646259971648F, 0.4363323129985824F, -0.08726646259971647F);
        this.armRight2 = new AdvancedModelRenderer(this, 112, 109);
        this.armRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRight2.addBox(-11.0F, -5.0F, -11.0F, 22, 28, 22, 0.0F);
        this.setRotateAngle(armRight2, -0.8726646259971648F, -0.4363323129985824F, 0.08726646259971647F);
        this.waist = new AdvancedModelRenderer(this, 0, 0);
        this.waist.setRotationPoint(0.0F, -30.0F, 5.0F);
        this.waist.addBox(-11.5F, -23.0F, -8.5F, 23, 30, 17, 0.0F);
        this.setRotateAngle(waist, 0.6981317007977318F, 0.0F, 0.0F);
        this.head = new AdvancedModelRenderer(this, 280, 0);
        this.head.setRotationPoint(-13.0F, 5.18F, 13.0F);
        this.head.addBox(-2.0F, -5.0F, -30.0F, 32, 17, 32, 0.0F);
        this.armRight1 = new AdvancedModelRenderer(this, 0, 88);
        this.armRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRight1.addBox(-8.5F, -10.0F, -8.5F, 17, 34, 17, 0.0F);
        this.setRotateAngle(armRight1, 0.22759093446006054F, 0.0F, 0.7285004297824331F);
        this.tuskLeftJoint = new AdvancedModelRenderer(this, 0, 0);
        this.tuskLeftJoint.setRotationPoint(19.0F, 0.0F, 12.0F);
        this.tuskLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.headJoint = new AdvancedModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -10.0F, -30.0F);
        this.headJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, 0.3490658503988659F, 0.0F, 0.0F);
        this.tuskLeft1 = new AdvancedModelRenderer(this, 68, 109);
        this.tuskLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tuskLeft1.addBox(-3.0F, -8.0F, -3.0F, 6, 13, 6, 0.0F);
        this.setRotateAngle(tuskLeft1, 0.0F, 0.0F, 2.0943951023931953F);
        this.leftRightJoint = new AdvancedModelRenderer(this, 71, 0);
        this.leftRightJoint.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.leftRightJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leftRightJoint, 0.8726646259971648F, 0.3490658503988659F, 0.2617993877991494F);
        this.rightFoot = new AdvancedModelRenderer(this, 80, 12);
        this.rightFoot.setRotationPoint(0.0F, 0.2F, -12.0F);
        this.rightFoot.addBox(-6.5F, -14.75F, -6.3F, 13, 20, 6, 0.0F);
        this.setRotateAngle(rightFoot, -0.4363323129985824F, 0.0F, 0.0F);
        this.root = new AdvancedModelRenderer(this, 0, 0);
        this.root.setRotationPoint(0.0F, 24.0F, 10.0F);
        this.root.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.legLeftFur = new AdvancedModelRenderer(this, 144, 77);
        this.legLeftFur.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.legLeftFur.addBox(-7.0F, -6.0F, -12.0F, 14, 14, 3, 0.0F);
        this.legLeftJoint = new AdvancedModelRenderer(this, 0, 0);
        this.legLeftJoint.setRotationPoint(9.0F, 3.14F, 0.0F);
        this.legLeftJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legLeftJoint, -0.6981317007977318F, 0.0F, 0.0F);
        handController = new AdvancedModelRenderer(this, 0, 0);
        swingOffsetController = new AdvancedModelRenderer(this, 0, 0);
        roarController = new AdvancedModelRenderer(this, 0, 0);

        this.leftHandJoint.addChild(this.leftHand);
        this.legLeft1.addChild(this.legLeft2);
        this.rightHand.addChild(this.rightThumb);
        this.legRightJoint.addChild(this.legRight1);
        this.tuskRight1.addChild(this.tuskRight2);
        this.jawJoint.addChild(this.jawRotator);
        this.leftHand.addChild(this.leftThumb);
        this.armRight1.addChild(this.armRightJoint2);
        this.legLeftJoint.addChild(this.legLeft1);
        this.head.addChild(this.teethUpper);
        this.armLeft2.addChild(this.leftHandJoint);
        this.jaw.addChild(this.jawSpikes2);
        this.headJoint.addChild(this.antlerLeft);
        this.leftRightJoint.addChild(this.rightHand);
        this.armLeftJoint.addChild(this.armLeft1);
        this.legLeft2.addChild(this.leftFoot);
        this.rightFingersJoint.addChild(this.rightFingers);
        this.head.addChild(this.jawJoint);
        this.leftFingersJoint.addChild(this.leftFingers);
        this.headJoint.addChild(this.headRotator);
        this.armLeft2.addChild(this.armLeft2Fur);
        this.chest.addChild(this.armRightJoint);
        this.jawRotator.addChild(this.jaw);
        this.head.addChild(this.eyeLidLeft);
        this.jaw.addChild(this.jawSpikes1);
        this.jaw.addChild(this.tuskRightJoint);
        this.headJoint.addChild(this.antlerRight);
        this.armRight2.addChild(this.armRight2Fur);
        this.legRight2.addChild(this.legRightFur);
        this.tuskLeft1.addChild(this.tuskLeft2);
        this.waist.addChild(this.legRightJoint);
        this.tuskRightJoint.addChild(this.tuskRight1);
        this.rightHand.addChild(this.rightFingersJoint);
        this.jaw.addChild(this.teethLower);
        this.waist.addChild(this.chestJoint);
        this.chestJoint.addChild(this.chest);
        this.leftHand.addChild(this.leftFingersJoint);
        this.head.addChild(this.headBack);
        this.legRight1.addChild(this.legRight2);
        this.head.addChild(this.eyeLidRight);
        this.chest.addChild(this.armLeftJoint);
        this.armLeft1.addChild(this.armLeftJoint2);
        this.armLeftJoint2.addChild(this.armLeft2);
        this.armRightJoint2.addChild(this.armRight2);
        this.root.addChild(this.waist);
        this.headRotator.addChild(this.head);
        this.armRightJoint.addChild(this.armRight1);
        this.jaw.addChild(this.tuskLeftJoint);
        this.chest.addChild(this.headJoint);
        this.tuskLeftJoint.addChild(this.tuskLeft1);
        this.armRight2.addChild(this.leftRightJoint);
        this.legRight2.addChild(this.rightFoot);
        this.legLeft2.addChild(this.legLeftFur);
        this.waist.addChild(this.legLeftJoint);

        antlerLeft.setScale(1, 1, -1);
        antlerRight.setScale(1, 1, -1);
        eyeLidLeft.isHidden = true;
        eyeLidRight.isHidden = true;
        leftHand.setScale(1.001f, 1.001f, 1.001f);
        rightHand.setScale(1.001f, 1.001f, 1.001f);
        leftFingersJoint.setScale(1.002f, 1.002f, 1.002f);
        rightFingersJoint.setScale(1.002f, 1.002f, 1.002f);
        leftThumb.rotateAngleY = (float) (Math.PI);
        leftThumb.rotationPointZ = 4;
        rightThumb.rotateAngleY = (float) (Math.PI);
        rightThumb.rotationPointZ = 4;

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((EntityFrostmaw) entity, f, f1, f2, f3, f4, f5);
        this.root.render(f5);
    }

    public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityFrostmaw entity) {
        resetToDefaultPose();
        float delta = LLibrary.PROXY.getPartialTicks();

        LegArticulator.articulateQuadruped(entity, entity.legSolver, waist, headJoint,
                legLeft1, legLeft2, legRight1, legRight2, armLeftJoint, armLeftJoint2, armRightJoint, armRightJoint2,
                0.6f, 0.6f, -0.65f, -0.65f,
                delta
        );
        legLeftJoint.rotateAngleX -= waist.rotateAngleX - waist.defaultRotationX;
        legRightJoint.rotateAngleX -= waist.rotateAngleX - waist.defaultRotationX;

//        f = 0.5f * (entity.ticksExisted + LLibrary.PROXY.getPartialTicks());
//        f1 = 1f;
        float globalSpeed = 0.5f;
        float globalHeight = 1.2f;
        float globalDegree = 0.8f;
        float frontDegree = 1.1f;
        float frontOffset = (float) (Math.PI/2);

        float lookLimit = 50;
        if (f3 > lookLimit) {
            f3 = lookLimit;
        }
        if (f3 < -lookLimit) {
            f3 = -lookLimit;
        }

        if (entity.getAnimation() == entity.ROAR_ANIMATION) {
            f3 = f3 / (entity.getAnimationTick() + delta);
            f4 = f4 / (entity.getAnimationTick() + delta);
        }

        faceTarget(f3, f4, 1, headJoint);

        waist.rotationPointZ += 10;
        bob(waist, globalSpeed, globalHeight * 3f, false, f, f1);
        walk(waist, globalSpeed, globalHeight * 0.12f, false, frontOffset, 0.08f, f, f1);
        walk(headJoint, globalSpeed, globalHeight * 0.12f, true, frontOffset + 0.4f, 0.08f, f, f1);
        walk(legLeftJoint, globalSpeed, globalHeight * 0.12f, true, frontOffset, 0.08f, f, f1);
        walk(legRightJoint, globalSpeed, globalHeight * 0.12f, true, frontOffset, 0.08f, f, f1);
        walk(armLeftJoint, globalSpeed, globalHeight * 0.12f, true, frontOffset, 0.08f, f, f1);
        walk(armRightJoint, globalSpeed, globalHeight * 0.12f, true, frontOffset, 0.08f, f, f1);

        swing(waist, 0.5f * globalSpeed, globalDegree * 0.2f, true, 0, 0, f, f1);
        swing(headJoint, 0.5f * globalSpeed, globalDegree * 0.2f, false, 0, 0, f, f1);

        flap(waist, 0.5f * globalSpeed, 0.15f * globalHeight, false, 1, 0, f, f1);
        flap(legLeft1, 0.5f * globalSpeed, 0.15f * globalHeight, true, 1, 0, f, f1);
        flap(legRight1, 0.5f * globalSpeed, 0.15f * globalHeight, true, 1, 0, f, f1);
        flap(chest, 0.5f * globalSpeed, 0.15f * globalHeight, true, 1, 0, f, f1);
        swing(legLeft1, 0.5F * globalSpeed, 0.2F * globalDegree, false, 0, 0.6F, f, f1);
        swing(legRight1, 0.5F * globalSpeed, 0.2F * globalDegree, false, 0, -0.6F, f, f1);
        walk(legLeft1, 0.5f * globalSpeed, 0.7f * globalDegree, false, 0, 0.4f, f, f1);
        walk(legRight1, 0.5f * globalSpeed, 0.7f * globalDegree, true, 0, -0.4f, f, f1);
        walk(legLeft2, 0.5f * globalSpeed, 0.6f * globalDegree, false, -1.8f, 0.2f, f, f1);
        walk(legRight2, 0.5f * globalSpeed, 0.6f * globalDegree, true, -1.8f, -0.2f, f, f1);
        walk(leftFoot, 0.5f * globalSpeed, 0.4f * globalDegree, false, -1.5f, 0.4f * globalDegree, f, f1);
        walk(rightFoot, 0.5f * globalSpeed, 0.4f * globalDegree, true, -1.5f, -0.4f * globalDegree, f, f1);

        swing(chest, 0.5f * globalSpeed, 0.3f * globalDegree * frontDegree, false, frontOffset, 0, f, f1);
        swing(headJoint, 0.5f * globalSpeed, 0.3f * globalDegree * frontDegree, true, frontOffset, 0, f, f1);
        swing(armLeft2, 0.5f * globalSpeed, 0.3f * globalDegree * frontDegree, true, frontOffset, 0.4f * globalDegree * frontDegree, f, f1);
        swing(armRight2, 0.5f * globalSpeed, 0.3f * globalDegree * frontDegree, true, frontOffset, -0.4f * globalDegree * frontDegree, f, f1);
        flap(chest, 0.5f * globalSpeed, 0.1f * globalDegree * frontDegree, true, frontOffset + 1, 0, f, f1);
        flap(armLeftJoint, 0.5f * globalSpeed, 0.1f * globalDegree * frontDegree, false, frontOffset + 1, 0, f, f1);
        flap(armRightJoint, 0.5f * globalSpeed, 0.1f * globalDegree * frontDegree, false, frontOffset + 1, 0, f, f1);
        flap(headJoint, 0.5f * globalSpeed, 0.1f * globalDegree * frontDegree, false, frontOffset + 1, 0, f, f1);

        walk(armLeftJoint, 0.5f * globalSpeed, 0.4f * globalDegree * frontDegree, true, frontOffset, -0.7f * globalDegree * frontDegree, f, f1);
        walk(armRightJoint, 0.5f * globalSpeed, 0.4f * globalDegree * frontDegree, false, frontOffset, 0.7f * globalDegree * frontDegree, f, f1);
        walk(armLeftJoint2, 0.5f * globalSpeed, 0.4f * globalDegree * frontDegree, true, frontOffset + 2f, 0.6f * globalDegree * frontDegree, f, f1);
        walk(armRightJoint2, 0.5f * globalSpeed, 0.4f * globalDegree * frontDegree, false, frontOffset + 2f, -0.6f * globalDegree * frontDegree, f, f1);
        walk(leftHand, 0.5f * globalSpeed, 0.5f * globalDegree * frontDegree, false, frontOffset + 1.5f, 0.05f * globalDegree * frontDegree, f, f1);
        walk(rightHand, 0.5f * globalSpeed, 0.5f * globalDegree * frontDegree, true, frontOffset + 1.5f, 0.05f * globalDegree * frontDegree, f, f1);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityFrostmaw frostmaw = (EntityFrostmaw) entity;
        animator.update(frostmaw);
        setRotationAngles(f, f1, f2, f3, f4, f5, frostmaw);
        float frame = frostmaw.ticksExisted + LLibrary.PROXY.getPartialTicks();

        if (frostmaw.getAnimation() == EntityFrostmaw.SWIPE_ANIMATION) {
            animator.setAnimation(EntityFrostmaw.SWIPE_ANIMATION);
            if (frostmaw.swingWhichArm) {
                animator.startKeyframe(7);
                animator.rotate(waist, -0.3f, 0.08f, 0);
                animator.rotate(legRightJoint, 0.3f, 0, 0);
                animator.rotate(legLeftJoint, 0.3f, 0, 0);
                animator.rotate(chest, 0, 0.08f, 0.5f);
                animator.rotate(headJoint, 0.2f, 0, -0.35f);
                animator.rotate(armLeftJoint, 0.3f, 0, -0.5f);
                animator.rotate(armLeftJoint, 0.2f, 0, -0.25f);
                animator.rotate(armLeftJoint2, 0f, 0, 0.18f);
                animator.rotate(leftHand, -0.1f, 0, 0.05f);

                animator.rotate(armRightJoint, -1.5f, 0.2f, 0f);
                animator.rotate(armRight1, 0, 0, 0.5f);
                animator.rotate(armRight2, 0.4f, 0.4f, 0f);
                animator.rotate(rightHand, -0.8f, 0.2f, -0.8f);
                animator.move(handController, 0, 1, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(2);

                animator.startKeyframe(5);
                animator.rotate(waist, 0.15f, -0.2f, 0);
                animator.rotate(chest, 0, -0.2f, -0.5f);
                animator.rotate(headJoint, -0.15f, 0.35f, 0.4f);
                animator.rotate(legRightJoint, -0.15f, 0, 0);
                animator.rotate(legLeftJoint, -0.15f, 0, 0);

                animator.rotate(armLeftJoint, -0.8f, 0.4f, 0.8f);
                animator.move(armLeftJoint, 0, 0, 1f);
                animator.rotate(armLeftJoint, 0.2f, 0, -0.25f);
                animator.rotate(armLeftJoint2, 1f, 0, -0.2f);
                animator.rotate(armLeft2, 0, 0.2f, 0);
                animator.rotate(leftHand, -0.5f, 0, -0.1f);

                animator.rotate(armRightJoint, -0.8f, -0.4f, 0f);
                animator.move(armRightJoint, 0, 0, -13);
                animator.rotate(armRight1, 0, 0, -0.5f);
                animator.rotate(armRight2, 0.5f, 0.4f, 0f);
                animator.rotate(rightHand, -0.4f, 0.6f, -0.8f);
                animator.move(handController, 0, 1, 0);
                animator.move(swingOffsetController, 7, 0, 0);
                animator.endKeyframe();
                animator.setStaticKeyframe(3);
                animator.resetKeyframe(10);

                float swingFrame = swingOffsetController.rotationPointX;
                if (entity.getAnimationTick() <= 14) {
                    waist.rotateAngleX += 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armRightJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleY += 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
            }
            else {
                animator.startKeyframe(7);
                animator.rotate(waist, -0.3f, -0.08f, 0);
                animator.rotate(legLeftJoint, 0.3f, 0, 0);
                animator.rotate(legRightJoint, 0.3f, 0, 0);
                animator.rotate(chest, 0, -0.08f, -0.5f);
                animator.rotate(headJoint, 0.2f, 0, 0.35f);
                animator.rotate(armRightJoint, 0.3f, 0, 0.5f);
                animator.rotate(armRightJoint, 0.2f, 0, 0.25f);
                animator.rotate(armRightJoint2, 0f, 0, -0.18f);
                animator.rotate(rightHand, -0.1f, 0, -0.05f);

                animator.rotate(armLeftJoint, -1.5f, -0.2f, 0f);
                animator.rotate(armLeft1, 0, 0, -0.5f);
                animator.rotate(armLeft2, 0.4f, -0.4f, 0f);
                animator.rotate(leftHand, -0.8f, -0.2f, 0.8f);
                animator.move(handController, 1, 0, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(2);

                animator.startKeyframe(5);
                animator.rotate(waist, 0.15f, 0.2f, 0);
                animator.rotate(chest, 0, 0.2f, 0.5f);
                animator.rotate(headJoint, -0.15f, -0.35f, -0.4f);
                animator.rotate(legLeftJoint, -0.15f, 0, 0);
                animator.rotate(legRightJoint, -0.15f, 0, 0);

                animator.rotate(armRightJoint, -0.8f, -0.4f, -0.8f);
                animator.move(armRightJoint, 0, 0, -1f);
                animator.rotate(armRightJoint, 0.2f, 0, 0.25f);
                animator.rotate(armRightJoint2, 1f, 0, 0.2f);
                animator.rotate(armRight2, 0, -0.2f, 0);
                animator.rotate(rightHand, -0.5f, 0, 0.1f);

                animator.rotate(armLeftJoint, -0.8f, 0.4f, 0f);
                animator.move(armLeftJoint, 0, 0, -13);
                animator.rotate(armLeft1, 0, 0, 0.5f);
                animator.rotate(armLeft2, 0.5f, -0.4f, 0f);
                animator.rotate(leftHand, -0.4f, -0.6f, 0.8f);
                animator.move(handController, 1, 0, 0);
                animator.move(swingOffsetController, 7, 0, 0);
                animator.endKeyframe();
                animator.setStaticKeyframe(3);
                animator.resetKeyframe(10);

                float swingFrame = swingOffsetController.rotationPointX;
                if (entity.getAnimationTick() <= 14) {
                    waist.rotateAngleX += 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armLeftJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleY -= 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
            }
        }

        if (frostmaw.getAnimation() == EntityFrostmaw.SWIPE_TWICE_ANIMATION) {
            animator.setAnimation(EntityFrostmaw.SWIPE_TWICE_ANIMATION);
            if (frostmaw.swingWhichArm) {
                animator.startKeyframe(7);
                animator.rotate(waist, -0.3f, 0.08f, 0);
                animator.rotate(legRightJoint, 0.3f, 0, 0);
                animator.rotate(legLeftJoint, 0.3f, 0, 0);
                animator.rotate(chest, 0, 0.08f, 0.5f);
                animator.rotate(headJoint, 0.2f, 0, -0.35f);
                animator.rotate(armLeftJoint, 0.3f, 0, -0.5f);
                animator.rotate(armLeftJoint, 0.2f, 0, -0.25f);
                animator.rotate(armLeftJoint2, 0f, 0, 0.18f);
                animator.rotate(leftHand, -0.1f, 0, 0.05f);

                animator.rotate(armRightJoint, -1.5f, 0.2f, 0f);
                animator.rotate(armRight1, 0, 0, 0.5f);
                animator.rotate(armRight2, 0.4f, 0.4f, 0f);
                animator.rotate(rightHand, -0.8f, 0.2f, -0.8f);
                animator.move(handController, 0, 1, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(2);

                animator.startKeyframe(6);
                animator.rotate(waist, -0.15f, -0.2f, 0);
                animator.rotate(chest, 0, -0.2f, -0.5f);
                animator.rotate(headJoint, 0.15f, 0.35f, 0.4f);
                animator.rotate(legRightJoint, 0.15f, 0, 0);
                animator.rotate(legLeftJoint, 0.15f, 0, 0);

                animator.rotate(armLeftJoint, -1.5f, -0.2f, 0f);
                animator.rotate(armLeft1, 0, 0, -0.8f);
                animator.rotate(armLeft2, 0.4f, -0.4f, 0f);
                animator.rotate(leftHand, -0.8f, -0.2f, 0.8f);
                animator.move(handController, 1, 0, 0);

                animator.rotate(armRightJoint, -0.5f, -0.4f, 0f);
                animator.move(armRightJoint, 0, 0, -13);
                animator.rotate(armRight1, 0, 0, -0.5f);
                animator.rotate(armRight2, 0.5f, 0.4f, 0f);
                animator.rotate(rightHand, -0.4f, 0.6f, -0.8f);
                animator.move(handController, 0, 1, 0);
                animator.move(swingOffsetController, 7, 0, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(3);

                animator.startKeyframe(6);
                animator.rotate(waist, 0.15f, 0.2f, 0);
                animator.rotate(chest, 0, 0.2f, 0.5f);
                animator.rotate(headJoint, -0.15f, -0.35f, -0.4f);
                animator.rotate(legLeftJoint, -0.15f, 0, 0);
                animator.rotate(legRightJoint, -0.15f, 0, 0);

                animator.rotate(armRightJoint, -0.8f, -0.4f, -0.8f);
                animator.move(armRightJoint, 0, 0, 1f);
                animator.rotate(armRightJoint, 0.2f, 0, 0.25f);
                animator.rotate(armRightJoint2, 1f, 0, 0.2f);
                animator.rotate(armRight2, 0, -0.2f, 0);
                animator.rotate(rightHand, -0.5f, 0, 0.1f);

                animator.rotate(armLeftJoint, -0.8f, 0.4f, 0f);
                animator.move(armLeftJoint, 0, 0, -13);
                animator.rotate(armLeft1, 0, 0, 0.5f);
                animator.rotate(armLeft2, 0.5f, -0.4f, 0f);
                animator.rotate(leftHand, -0.4f, -0.6f, 0.8f);
                animator.move(handController, 1, 0, 0);
                animator.move(swingOffsetController, 0, 0, 0);
                animator.endKeyframe();
                animator.setStaticKeyframe(3);
                animator.resetKeyframe(10);

                float swingFrame = swingOffsetController.rotationPointX;
                if (entity.getAnimationTick() <= 15) {
                    waist.rotateAngleX += 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    headJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armRightJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleY += 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
                if (entity.getAnimationTick() > 15 && entity.getAnimationTick() <= 25) {
                    waist.rotateAngleX += 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armLeftJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleY -= 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
            }
            else {
                animator.startKeyframe(7);
                animator.rotate(waist, -0.3f, -0.08f, 0);
                animator.rotate(legLeftJoint, 0.3f, 0, 0);
                animator.rotate(legRightJoint, 0.3f, 0, 0);
                animator.rotate(chest, 0, -0.08f, -0.5f);
                animator.rotate(headJoint, 0.2f, 0, 0.35f);
                animator.rotate(armRightJoint, 0.3f, 0, 0.5f);
                animator.rotate(armRightJoint, 0.2f, 0, 0.25f);
                animator.rotate(armRightJoint2, 0f, 0, -0.18f);
                animator.rotate(rightHand, -0.1f, 0, -0.05f);

                animator.rotate(armLeftJoint, -1.5f, -0.2f, 0f);
                animator.rotate(armLeft1, 0, 0, -0.5f);
                animator.rotate(armLeft2, 0.4f, -0.4f, 0f);
                animator.rotate(leftHand, -0.8f, -0.2f, 0.8f);
                animator.move(handController, 1, 0, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(2);

                animator.startKeyframe(6);
                animator.rotate(waist, -0.15f, 0.2f, 0);
                animator.rotate(chest, 0, 0.2f, 0.5f);
                animator.rotate(headJoint, 0.15f, -0.35f, -0.4f);
                animator.rotate(legLeftJoint, 0.15f, 0, 0);
                animator.rotate(legRightJoint, 0.15f, 0, 0);

                animator.rotate(armRightJoint, -1.5f, 0.2f, 0f);
                animator.rotate(armRight1, 0, 0, 0.8f);
                animator.rotate(armRight2, 0.4f, 0.4f, 0f);
                animator.rotate(rightHand, -0.8f, 0.2f, -0.8f);
                animator.move(handController, 0, 1, 0);

                animator.rotate(armLeftJoint, -0.5f, 0.4f, 0f);
                animator.move(armLeftJoint, 0, 0, -13);
                animator.rotate(armLeft1, 0, 0, 0.5f);
                animator.rotate(armLeft2, 0.5f, -0.4f, 0f);
                animator.rotate(leftHand, -0.4f, -0.6f, 0.8f);
                animator.move(handController, 1, 0, 0);
                animator.move(swingOffsetController, 7, 0, 0);
                animator.endKeyframe();

                animator.setStaticKeyframe(3);

                animator.startKeyframe(6);
                animator.rotate(waist, 0.15f, -0.2f, 0);
                animator.rotate(chest, 0, -0.2f, -0.5f);
                animator.rotate(headJoint, -0.15f, 0.35f, 0.4f);
                animator.rotate(legRightJoint, -0.15f, 0, 0);
                animator.rotate(legLeftJoint, -0.15f, 0, 0);

                animator.rotate(armLeftJoint, -0.8f, 0.4f, 0.8f);
                animator.move(armLeftJoint, 0, 0, 1f);
                animator.rotate(armLeftJoint, 0.2f, 0, -0.25f);
                animator.rotate(armLeftJoint2, 1f, 0, -0.2f);
                animator.rotate(armLeft2, 0, 0.2f, 0);
                animator.rotate(leftHand, -0.5f, 0, -0.1f);

                animator.rotate(armRightJoint, -0.8f, -0.4f, 0f);
                animator.move(armRightJoint, 0, 0, -13);
                animator.rotate(armRight1, 0, 0, -0.5f);
                animator.rotate(armRight2, 0.5f, 0.4f, 0f);
                animator.rotate(rightHand, -0.4f, 0.6f, -0.8f);
                animator.move(handController, 0, 1, 0);
                animator.move(swingOffsetController, 0, 0, 0);
                animator.endKeyframe();
                animator.setStaticKeyframe(3);
                animator.resetKeyframe(10);

                float swingFrame = swingOffsetController.rotationPointX;
                if (entity.getAnimationTick() <= 15) {
                    waist.rotateAngleX += 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    headJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.3f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRightJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armLeftJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeft2.rotateAngleY -= 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
                if (entity.getAnimationTick() > 15 && entity.getAnimationTick() <= 25) {
                    waist.rotateAngleX += 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legRightJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    legLeftJoint.rotateAngleX -= 0.1f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armLeftJoint.rotationPointY -= 6f * (0.0817 * -swingFrame * (swingFrame - 7));

                    armRightJoint.rotateAngleX += 0.4f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleX -= 0.2f * (0.0817 * -swingFrame * (swingFrame - 7));
                    armRight2.rotateAngleY += 1f * (0.0817 * -swingFrame * (swingFrame - 7));
                }
            }
        }

        if (frostmaw.getAnimation() == EntityFrostmaw.ROAR_ANIMATION) {
            animator.setAnimation(EntityFrostmaw.ROAR_ANIMATION);
            animator.startKeyframe(8);
            animator.rotate(waist, 0.2f, 0, 0);
            animator.rotate(legRightJoint, -0.2f, 0, 0);
            animator.rotate(legLeftJoint, -0.2f, 0, 0);
            animator.rotate(headJoint, 0.3f, 0, 0);

            animator.rotate(armLeftJoint, 0.15f, 0, 0);
            animator.move(armLeftJoint, 0, 2, 0);
            animator.rotate(armLeftJoint2, -0.6f, 0, 0);
            animator.rotate(leftHand, 0.3f, 0, 0.15f);
            animator.rotate(armRightJoint, 0.15f, 0, 0);
            animator.move(armRightJoint, 0, 2, 0);
            animator.rotate(armRightJoint2, -0.6f, 0, 0);
            animator.rotate(rightHand, 0.3f, 0, -0.15f);
            animator.endKeyframe();

            animator.setStaticKeyframe(4);

            animator.startKeyframe(5);
            animator.rotate(waist, -0.2f, 0, 0);
            animator.rotate(legRightJoint, 0.2f, 0, 0);
            animator.rotate(legLeftJoint, 0.2f, 0, 0);
            animator.rotate(headJoint, -0.3f, 0, 0);
            animator.rotate(jawJoint, 1.3f, 0, 0);
            animator.move(roarController, 1, 1, 0);

            animator.rotate(armLeftJoint, -0.4f, 0, 0);
            animator.rotate(armLeftJoint2, 0.9f, 0, 0);
            animator.rotate(leftHand, -0.3f, 0, -0.15f);
            animator.rotate(armRightJoint, -0.4f, 0, 0);
            animator.rotate(armRightJoint2, 0.9f, 0, 0);
            animator.rotate(rightHand, -0.3f, 0, 0.15f);
            animator.endKeyframe();
            animator.setStaticKeyframe(50);
            animator.resetKeyframe(8);
        }

        if (frostmaw.getAnimation() == EntityFrostmaw.ICE_BREATH_ANIMATION) {
            animator.setAnimation(EntityFrostmaw.ICE_BREATH_ANIMATION);
            animator.startKeyframe(10);
            animator.rotate(waist, -0.2f, 0, 0);
            animator.rotate(legRightJoint, 0.2f, 0, 0);
            animator.rotate(legLeftJoint, 0.2f, 0, 0);
            animator.rotate(headJoint, 0.6f, 0, 0);

            animator.rotate(armLeftJoint, -0.4f, 0, 0);
            animator.rotate(armLeftJoint2, 0.9f, 0, 0);
            animator.rotate(leftHand, -0.3f, 0, -0.15f);
            animator.rotate(armRightJoint, -0.4f, 0, 0);
            animator.rotate(armRightJoint2, 0.9f, 0, 0);
            animator.rotate(rightHand, -0.3f, 0, 0.15f);
            animator.endKeyframe();

            animator.setStaticKeyframe(4);

            animator.startKeyframe(5);
            animator.rotate(waist, 0.2f, 0, 0);
            animator.rotate(legRightJoint, -0.2f, 0, 0);
            animator.rotate(legLeftJoint, -0.2f, 0, 0);
            animator.rotate(headJoint, -0.9f, 0, 0);
            animator.rotate(jawJoint, 1.6f, 0, 0);

            animator.rotate(armLeftJoint, 0.15f, 0, 0);
            animator.move(armLeftJoint, 0, 2, 0);
            animator.rotate(armLeftJoint2, -0.6f, 0, 0);
            animator.rotate(leftHand, 0.3f, 0, 0.15f);
            animator.rotate(armRightJoint, 0.15f, 0, 0);
            animator.move(armRightJoint, 0, 2, 0);
            animator.rotate(armRightJoint2, -0.6f, 0, 0);
            animator.rotate(rightHand, 0.3f, 0, -0.15f);
            animator.move(roarController, 1, 1, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(50);
            animator.resetKeyframe(7);
        }

        jawJoint.rotateAngleX += 0.08 * roarController.rotationPointX * Math.cos(2 * frame);
        headBack.setScale(1, 1 - roarController.rotationPointY, 1);

        rightFingersJoint.rotateAngleX -= handController.rotationPointY * Math.PI/2;
        rightFingers.rotateAngleX -= handController.rotationPointY * Math.PI/2;
        rightThumb.rotateAngleY += (float) (handController.rotationPointY * Math.PI);
        rightThumb.rotateAngleZ += handController.rotationPointY * 0.7f;
        rightThumb.rotationPointZ -= handController.rotationPointY * 6;

        leftFingersJoint.rotateAngleX -= handController.rotationPointX * Math.PI/2;
        leftFingers.rotateAngleX -= handController.rotationPointX * Math.PI/2;
        leftThumb.rotateAngleY -= (float) (handController.rotationPointX * Math.PI);
        leftThumb.rotateAngleZ -= handController.rotationPointX * 0.7f;
        leftThumb.rotationPointZ -= handController.rotationPointX * 6;
    }
}