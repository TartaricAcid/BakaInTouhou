package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityStarModel extends EntityTouhouCharacterModel {
    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer footR;
    private ModelRenderer footL;
    private ModelRenderer handR;
    private ModelRenderer handL;
    private ModelRenderer headdressLT;
    private ModelRenderer headdressRT;
    private ModelRenderer headdressRB;
    private ModelRenderer headdressLB;
    private ModelRenderer hair;
    private ModelRenderer wingL;
    private ModelRenderer wingR;

    public EntityStarModel() {
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
        headdressLT = new ModelRenderer(this, 42, 12);
        headdressLT.addBox(0F, -1F, 0F, 3, 2, 1);
        headdressLT.setRotationPoint(0F, -0.5F, -5F);
        headdressLT.setTextureSize(128, 32);
        headdressLT.mirror = true;
        setRotation(headdressLT, -0.1745329F, 0F, -0.1745329F);
        headdressRT = new ModelRenderer(this, 42, 12);
        headdressRT.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdressRT.setRotationPoint(0F, -0.5F, -5F);
        headdressRT.setTextureSize(128, 32);
        headdressRT.mirror = true;
        setRotation(headdressRT, -0.1745329F, 0F, 0.1745329F);
        headdressRB = new ModelRenderer(this, 51, 12);
        headdressRB.addBox(-1F, 0F, 0F, 2, 3, 1);
        headdressRB.setRotationPoint(0F, -1F, -5F);
        headdressRB.setTextureSize(128, 32);
        headdressRB.mirror = true;
        setRotation(headdressRB, -0.3490659F, 0F, 0.6108652F);
        headdressLB = new ModelRenderer(this, 51, 12);
        headdressLB.addBox(-1F, 0F, 0F, 2, 3, 1);
        headdressLB.setRotationPoint(0F, -1F, -5F);
        headdressLB.setTextureSize(128, 32);
        headdressLB.mirror = true;
        setRotation(headdressLB, -0.3490659F, 0F, -0.6108652F);
        hair = new ModelRenderer(this, 41, 17);
        hair.addBox(-4F, 0F, 0F, 8, 10, 0);
        hair.setRotationPoint(0F, 8F, 4F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0.4363323F, 0F, 0F);
        wingL = new ModelRenderer(this, 90, 12);
        wingL.addBox(0F, -10F, 0F, 16, 20, 0);
        wingL.setRotationPoint(1F, 11F, 4F);
        wingL.setTextureSize(128, 32);
        wingL.mirror = true;
        setRotation(wingL, 0.0872665F, -0.3490659F, 0F);
        wingR = new ModelRenderer(this, 58, 12);
        wingR.addBox(-16F, -10F, 0F, 16, 20, 0);
        wingR.setRotationPoint(-1F, 11F, 5F);
        wingR.setTextureSize(128, 32);
        wingR.mirror = true;
        setRotation(wingR, 0.0872665F, 0.3490659F, 0F);

        head.addChild(hair);
        head.addChild(headdressLB);
        head.addChild(headdressLT);
        head.addChild(headdressRB);
        head.addChild(headdressRT);
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
        this.headdressLB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressLT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressRB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.headdressRT.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
