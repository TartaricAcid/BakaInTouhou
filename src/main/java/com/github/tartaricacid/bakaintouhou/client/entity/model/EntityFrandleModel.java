package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityFrandleModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer hat;
    ModelRenderer headdressM;
    ModelRenderer headdressB;
    ModelRenderer headdressF;
    ModelRenderer bowM;
    ModelRenderer bowRT;
    ModelRenderer bowLB;
    ModelRenderer bowLT;
    ModelRenderer bowRB;
    ModelRenderer wingL;
    ModelRenderer wingR;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer footR;
    ModelRenderer footL;

    public EntityFrandleModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 4, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 12F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 16);
        body3.addBox(-5F, 0F, -5F, 10, 6, 10);
        body3.setRotationPoint(0F, 16F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        hat = new ModelRenderer(this, 91, 0);
        hat.addBox(-4.5F, 0F, -4.5F, 9, 4, 9);
        hat.setRotationPoint(0F, -1.5F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        headdressM = new ModelRenderer(this, 33, 11);
        headdressM.addBox(-1F, -1F, -1F, 1, 2, 2);
        headdressM.setRotationPoint(5F, 0F, -1F);
        headdressM.setTextureSize(128, 32);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, 0F);
        headdressB = new ModelRenderer(this, 40, 11);
        headdressB.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdressB.setRotationPoint(5F, 0F, -0.2F);
        headdressB.setTextureSize(128, 32);
        headdressB.mirror = true;
        setRotation(headdressB, 0F, 2.617994F, 0.5235988F);
        headdressF = new ModelRenderer(this, 49, 11);
        headdressF.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdressF.setRotationPoint(5F, 0F, -0.8F);
        headdressF.setTextureSize(128, 32);
        headdressF.mirror = true;
        setRotation(headdressF, 0F, -2.617994F, -0.1745329F);
        bowM = new ModelRenderer(this, 41, 15);
        bowM.addBox(-1F, -1F, -1F, 2, 2, 2);
        bowM.setRotationPoint(0F, 12F, 4.5F);
        bowM.setTextureSize(128, 32);
        bowM.mirror = true;
        setRotation(bowM, 0F, 0F, 0F);
        bowRT = new ModelRenderer(this, 50, 15);
        bowRT.addBox(-4F, -1F, 0F, 4, 2, 1);
        bowRT.setRotationPoint(0F, 12.5F, 4.2F);
        bowRT.setTextureSize(128, 32);
        bowRT.mirror = true;
        setRotation(bowRT, 0F, 0.2974289F, 0.2617994F);
        bowLB = new ModelRenderer(this, 41, 20);
        bowLB.addBox(-1F, 0F, 0F, 2, 6, 1);
        bowLB.setRotationPoint(0F, 12F, 4.5F);
        bowLB.setTextureSize(128, 32);
        bowLB.mirror = true;
        setRotation(bowLB, 0.2617994F, -0.1745329F, -0.6981317F);
        bowLT = new ModelRenderer(this, 50, 15);
        bowLT.addBox(0F, -1F, 0F, 4, 2, 1);
        bowLT.setRotationPoint(0F, 12.5F, 4.2F);
        bowLT.setTextureSize(128, 32);
        bowLT.mirror = true;
        setRotation(bowLT, 0F, -0.296706F, -0.2617994F);
        bowRB = new ModelRenderer(this, 41, 20);
        bowRB.addBox(-1F, 0F, 0F, 2, 6, 1);
        bowRB.setRotationPoint(0F, 12F, 4.5F);
        bowRB.setTextureSize(128, 32);
        bowRB.mirror = true;
        setRotation(bowRB, 0.2617994F, -0.1745329F, 0.6981317F);
        wingL = new ModelRenderer(this, 88, 22);
        wingL.addBox(0F, -5F, 0F, 20, 10, 0);
        wingL.setRotationPoint(1F, 10.5F, 3F);
        wingL.setTextureSize(128, 32);
        wingL.mirror = true;
        setRotation(wingL, 0F, -0.2617994F, 0.1745329F);
        wingR = new ModelRenderer(this, 48, 22);
        wingR.addBox(-20F, -5F, 0F, 20, 10, 0);
        wingR.setRotationPoint(-1F, 10.5F, 3F);
        wingR.setTextureSize(128, 32);
        wingR.mirror = true;
        setRotation(wingR, 0F, 0.2617994F, -0.1745329F);
        handR = new ModelRenderer(this, 61, 12);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 61, 12);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        footR = new ModelRenderer(this, 70, 13);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 70, 13);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        hat.render(f5);
        headdressM.render(f5);
        headdressB.render(f5);
        headdressF.render(f5);
        bowM.render(f5);
        bowRT.render(f5);
        bowLB.render(f5);
        bowLT.render(f5);
        bowRB.render(f5);
        wingL.render(f5);
        wingR.render(f5);
        handR.render(f5);
        handL.render(f5);
        footR.render(f5);
        footL.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        // 头部转动
        this.head.rotateAngleX = headPitch / 45f / (float) Math.PI;
        this.head.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;
        this.hat.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;

        // 左脚右脚，左手右手的运动
        this.footL.rotateAngleX = MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.footR.rotateAngleX = -MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.handL.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.523f;
        this.handR.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.523f;

        // 翅膀的周期运动
        this.wingL.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingR.rotateAngleY = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.8f;

        // 头饰的周期运动
        this.headdressF.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 2.6f;
        this.headdressB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 2.6f;

        // 蝴蝶结的周期运动
        this.bowLB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.bowLT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.bowRB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.bowRT.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
