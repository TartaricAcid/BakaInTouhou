package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityChenModel extends EntityTouhouCharacterModel {

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
    ModelRenderer earR1;
    ModelRenderer earR2;
    ModelRenderer earL1;
    ModelRenderer earL2;
    ModelRenderer tail1;
    ModelRenderer tail2;

    public EntityChenModel() {
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
        hat = new ModelRenderer(this, 41, 17);
        hat.addBox(-4.5F, 0F, -4.5F, 9, 3, 9);
        hat.setRotationPoint(0F, -1F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        earR1 = new ModelRenderer(this, 42, 12);
        earR1.addBox(-1F, -3F, -1F, 1, 3, 1);
        earR1.setRotationPoint(-2.3F, -0.9F, -1F);
        earR1.setTextureSize(128, 32);
        earR1.mirror = true;
        setRotation(earR1, 0F, 0F, -0.8552113F);
        earR2 = new ModelRenderer(this, 42, 12);
        earR2.addBox(-1F, -3F, -1F, 1, 3, 1);
        earR2.setRotationPoint(-3F, 0.5F, -1F);
        earR2.setTextureSize(128, 32);
        earR2.mirror = true;
        setRotation(earR2, 0F, 0F, -0.3665191F);
        earL1 = new ModelRenderer(this, 42, 12);
        earL1.addBox(-1F, -3F, -1F, 1, 3, 1);
        earL1.setRotationPoint(3F, 0F, -1F);
        earL1.setTextureSize(128, 32);
        earL1.mirror = true;
        setRotation(earL1, 0F, 0F, 0.8552113F);
        earL2 = new ModelRenderer(this, 42, 12);
        earL2.addBox(-1F, -3F, -1F, 1, 3, 1);
        earL2.setRotationPoint(4F, 1F, -1F);
        earL2.setTextureSize(128, 32);
        earL2.mirror = true;
        setRotation(earL2, 0F, 0F, 0.3665191F);
        tail1 = new ModelRenderer(this, 78, 14);
        tail1.addBox(0F, 0F, 0F, 1, 14, 1);
        tail1.setRotationPoint(0F, 16F, 4F);
        tail1.setTextureSize(128, 32);
        tail1.mirror = true;
        setRotation(tail1, 2.443461F, -0.2F, -0.4363323F);
        tail2 = new ModelRenderer(this, 83, 16);
        tail2.addBox(0F, 0F, 0F, 1, 12, 1);
        tail2.setRotationPoint(0F, 16F, 4F);
        tail2.setTextureSize(128, 32);
        tail2.mirror = true;
        setRotation(tail2, 2.530727F, 0.3F, -0.4363323F);

        head.addChild(earL1);
        head.addChild(earL2);
        head.addChild(earR1);
        head.addChild(earR2);
        head.addChild(hat);
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
        tail1.render(f5);
        tail2.render(f5);
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

        // 尾巴的周期运动
        this.tail1.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 1.9f;
        this.tail1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.1f) * 0.05f - 0.4f;
        this.tail2.rotateAngleX = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 1.8f;
        this.tail2.rotateAngleZ = MathHelper.sin(ageInTicks * 0.1f) * 0.05f - 0.4f;
    }
}
