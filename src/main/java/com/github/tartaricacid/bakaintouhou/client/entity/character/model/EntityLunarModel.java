package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityLunarModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer hat;
    ModelRenderer headdressR1;
    ModelRenderer headdressR2;
    ModelRenderer headdressL1;
    ModelRenderer headdressL2;
    ModelRenderer bowM;
    ModelRenderer bowR;
    ModelRenderer bowL;
    ModelRenderer wingL;
    ModelRenderer wingR;

    public EntityLunarModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 5, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 13F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 17);
        body3.addBox(-5F, 0F, -5F, 10, 5, 10);
        body3.setRotationPoint(0F, 17F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 33, 12);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 33, 12);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 91, 0);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 91, 0);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        hat = new ModelRenderer(this, 100, 0);
        hat.addBox(-3.5F, 0F, -3.5F, 7, 2, 7);
        hat.setRotationPoint(0F, -2F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        headdressR1 = new ModelRenderer(this, 42, 12);
        headdressR1.addBox(-2F, 0F, 0F, 2, 1, 1);
        headdressR1.setRotationPoint(-3.6F, 0F, 0F);
        headdressR1.setTextureSize(128, 32);
        headdressR1.mirror = true;
        setRotation(headdressR1, 0F, 0F, 0.2617994F);
        headdressR2 = new ModelRenderer(this, 42, 12);
        headdressR2.addBox(-2F, 0F, 0F, 2, 1, 1);
        headdressR2.setRotationPoint(-4F, 1F, 0F);
        headdressR2.setTextureSize(128, 32);
        headdressR2.mirror = true;
        setRotation(headdressR2, 0F, 0F, -0.0872665F);
        headdressL1 = new ModelRenderer(this, 42, 12);
        headdressL1.addBox(0F, 0F, 0F, 2, 1, 1);
        headdressL1.setRotationPoint(3.6F, 0F, 0F);
        headdressL1.setTextureSize(128, 32);
        headdressL1.mirror = true;
        setRotation(headdressL1, 0F, 0F, -0.2617994F);
        headdressL2 = new ModelRenderer(this, 42, 12);
        headdressL2.addBox(0F, 0F, 0F, 2, 1, 1);
        headdressL2.setRotationPoint(4F, 1F, 0F);
        headdressL2.setTextureSize(128, 32);
        headdressL2.mirror = true;
        setRotation(headdressL2, 0F, 0F, 0.0872665F);
        bowM = new ModelRenderer(this, 42, 15);
        bowM.addBox(-2.5F, 0F, 0F, 5, 1, 1);
        bowM.setRotationPoint(0F, 9F, -4F);
        bowM.setTextureSize(128, 32);
        bowM.mirror = true;
        setRotation(bowM, 0F, 0F, 0F);
        bowR = new ModelRenderer(this, 42, 18);
        bowR.addBox(-2F, 0F, 0F, 2, 3, 1);
        bowR.setRotationPoint(0.5F, 10F, -4F);
        bowR.setTextureSize(128, 32);
        bowR.mirror = true;
        setRotation(bowR, 0F, -0.2617994F, 0.4363323F);
        bowL = new ModelRenderer(this, 42, 18);
        bowL.addBox(0F, 0F, 0F, 2, 3, 1);
        bowL.setRotationPoint(-0.5F, 10F, -4F);
        bowL.setTextureSize(128, 32);
        bowL.mirror = true;
        setRotation(bowL, 0F, 0.2617994F, -0.4363323F);
        wingL = new ModelRenderer(this, 58, 12);
        wingL.addBox(0F, -14F, 0F, 16, 20, 0);
        wingL.setRotationPoint(1F, 10F, 4F);
        wingL.setTextureSize(128, 32);
        wingL.mirror = true;
        setRotation(wingL, 0F, -0.2617994F, 0.0872665F);
        wingR = new ModelRenderer(this, 92, 12);
        wingR.addBox(-16F, -14F, 0F, 16, 20, 0);
        wingR.setRotationPoint(-1F, 10F, 4F);
        wingR.setTextureSize(128, 32);
        wingR.mirror = true;
        setRotation(wingR, 0F, 0.2617994F, -0.0872665F);

        head.addChild(hat);
        head.addChild(headdressL1);
        head.addChild(headdressL2);
        head.addChild(headdressR1);
        head.addChild(headdressR2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        footR.render(f5);
        footL.render(f5);
        handR.render(f5);
        handL.render(f5);
        bowM.render(f5);
        bowR.render(f5);
        bowL.render(f5);
        wingL.render(f5);
        wingR.render(f5);
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
        this.bowL.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.bowR.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
