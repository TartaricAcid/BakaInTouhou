package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityRanModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer hand;
    ModelRenderer earR1;
    ModelRenderer earR2;
    ModelRenderer earL1;
    ModelRenderer earL2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer tail6;
    ModelRenderer tail7;
    ModelRenderer tail8;
    ModelRenderer tail9;
    ModelRenderer tail10;
    ModelRenderer tail11;
    ModelRenderer tail12;
    ModelRenderer tail13;
    ModelRenderer tail14;
    ModelRenderer tail15;
    ModelRenderer tail16;
    ModelRenderer tail17;
    ModelRenderer tail18;

    public EntityRanModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 8F, 0F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 17, 19);
        body1.addBox(-3F, 0F, -3F, 6, 6, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(64, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 14, 33);
        body2.addBox(-4F, 0F, -4F, 8, 8, 8);
        body2.setRotationPoint(0F, 14F, 0F);
        body2.setTextureSize(64, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 0, 17);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(64, 64);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 0, 17);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(64, 64);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        hand = new ModelRenderer(this, 33, 0);
        hand.addBox(-4.5F, 1F, -2F, 10, 5, 2);
        hand.setRotationPoint(-0.5F, 9F, 1F);
        hand.setTextureSize(64, 64);
        hand.mirror = true;
        setRotation(hand, -0.7853982F, 0F, 0F);
        earR1 = new ModelRenderer(this, 0, 35);
        earR1.addBox(-1.5F, -2F, 0F, 3, 1, 1);
        earR1.setRotationPoint(-2F, 1F, -1F);
        earR1.setTextureSize(64, 64);
        earR1.mirror = true;
        setRotation(earR1, 0F, 0F, 0F);
        earR2 = new ModelRenderer(this, 0, 38);
        earR2.addBox(-1F, -1F, 0F, 2, 1, 1);
        earR2.setRotationPoint(-2F, -1F, -1F);
        earR2.setTextureSize(64, 64);
        earR2.mirror = true;
        setRotation(earR2, 0F, 0F, 0F);
        earL1 = new ModelRenderer(this, 0, 35);
        earL1.addBox(-1.5F, -2F, 0F, 3, 1, 1);
        earL1.setRotationPoint(2F, 1F, -1F);
        earL1.setTextureSize(64, 64);
        earL1.mirror = true;
        setRotation(earL1, 0F, 0F, 0F);
        earL2 = new ModelRenderer(this, 0, 38);
        earL2.addBox(-1F, -1F, 0F, 2, 1, 1);
        earL2.setRotationPoint(2F, -1F, -1F);
        earL2.setTextureSize(64, 64);
        earL2.mirror = true;
        setRotation(earL2, 0F, 0F, 0F);
        tail1 = new ModelRenderer(this, 44, 9);
        tail1.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail1.setRotationPoint(0F, 16F, 3F);
        tail1.setTextureSize(64, 64);
        tail1.mirror = true;
        setRotation(tail1, -0.296706F, 0F, 0F);
        tail2 = new ModelRenderer(this, 44, 24);
        tail2.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail2.setRotationPoint(0F, 7F, 6F);
        tail2.setTextureSize(64, 64);
        tail2.mirror = true;
        setRotation(tail2, 0.1047198F, 0F, 0F);
        tail3 = new ModelRenderer(this, 44, 9);
        tail3.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail3.setRotationPoint(0F, 16F, 3F);
        tail3.setTextureSize(64, 64);
        tail3.mirror = true;
        setRotation(tail3, -0.2617994F, 0F, -0.5235988F);
        tail4 = new ModelRenderer(this, 44, 24);
        tail4.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail4.setRotationPoint(-4F, 9F, 6F);
        tail4.setTextureSize(64, 64);
        tail4.mirror = true;
        setRotation(tail4, 0.4014257F, 0F, -0.5235988F);
        tail5 = new ModelRenderer(this, 44, 9);
        tail5.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail5.setRotationPoint(0F, 16F, 3F);
        tail5.setTextureSize(64, 64);
        tail5.mirror = true;
        setRotation(tail5, -0.2617994F, 0F, 0.5235988F);
        tail6 = new ModelRenderer(this, 44, 24);
        tail6.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail6.setRotationPoint(4F, 9F, 6F);
        tail6.setTextureSize(64, 64);
        tail6.mirror = true;
        setRotation(tail6, 0.4014257F, 0F, 0.5235988F);
        tail7 = new ModelRenderer(this, 44, 9);
        tail7.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail7.setRotationPoint(0F, 16F, 3F);
        tail7.setTextureSize(64, 64);
        tail7.mirror = true;
        setRotation(tail7, -0.2443461F, 0F, 1.570796F);
        tail7.mirror = false;
        tail8 = new ModelRenderer(this, 44, 24);
        tail8.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail8.setRotationPoint(6F, 16F, 8F);
        tail8.setTextureSize(64, 64);
        tail8.mirror = true;
        setRotation(tail8, 1.204277F, 0F, 1.570796F);
        tail9 = new ModelRenderer(this, 44, 9);
        tail9.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail9.setRotationPoint(0F, 16F, 3F);
        tail9.setTextureSize(64, 64);
        tail9.mirror = true;
        setRotation(tail9, -0.2443461F, 0F, -1.570796F);
        tail10 = new ModelRenderer(this, 44, 24);
        tail10.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail10.setRotationPoint(-6F, 16F, 8F);
        tail10.setTextureSize(64, 64);
        tail10.mirror = true;
        setRotation(tail10, 1.204277F, 0F, -1.570796F);
        tail11 = new ModelRenderer(this, 44, 9);
        tail11.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail11.setRotationPoint(0F, 16F, 3F);
        tail11.setTextureSize(64, 64);
        tail11.mirror = true;
        setRotation(tail11, -0.2617994F, 0F, -1.117011F);
        tail12 = new ModelRenderer(this, 44, 24);
        tail12.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail12.setRotationPoint(-6F, 13F, 7F);
        tail12.setTextureSize(64, 64);
        tail12.mirror = true;
        setRotation(tail12, 0.8028515F, 0F, -1.117011F);
        tail13 = new ModelRenderer(this, 44, 9);
        tail13.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail13.setRotationPoint(0F, 16F, 3F);
        tail13.setTextureSize(64, 64);
        tail13.mirror = true;
        setRotation(tail13, -0.2617994F, 0F, 1.117011F);
        tail14 = new ModelRenderer(this, 44, 24);
        tail14.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail14.setRotationPoint(6F, 13F, 7F);
        tail14.setTextureSize(64, 64);
        tail14.mirror = true;
        setRotation(tail14, 0.8028515F, 0F, 1.117011F);
        tail15 = new ModelRenderer(this, 44, 9);
        tail15.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail15.setRotationPoint(0F, 16F, 3F);
        tail15.setTextureSize(64, 64);
        tail15.mirror = true;
        setRotation(tail15, 0F, 0F, 2.094395F);
        tail16 = new ModelRenderer(this, 44, 24);
        tail16.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail16.setRotationPoint(7F, 20F, 7F);
        tail16.setTextureSize(64, 64);
        tail16.mirror = true;
        setRotation(tail16, 1.570796F, 0F, 2.094395F);
        tail17 = new ModelRenderer(this, 44, 9);
        tail17.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail17.setRotationPoint(0F, 16F, 3F);
        tail17.setTextureSize(64, 64);
        tail17.mirror = true;
        setRotation(tail17, 0F, 0F, -2.094395F);
        tail18 = new ModelRenderer(this, 44, 24);
        tail18.addBox(-2F, -11F, 0F, 4, 11, 4);
        tail18.setRotationPoint(-7F, 20F, 7F);
        tail18.setTextureSize(64, 64);
        tail18.mirror = true;
        setRotation(tail18, 1.570796F, 0F, -2.094395F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        footR.render(f5);
        footL.render(f5);
        hand.render(f5);
        tail1.render(f5);
        tail2.render(f5);
        tail3.render(f5);
        tail4.render(f5);
        tail5.render(f5);
        tail6.render(f5);
        tail7.render(f5);
        tail8.render(f5);
        tail9.render(f5);
        tail10.render(f5);
        tail11.render(f5);
        tail12.render(f5);
        tail13.render(f5);
        tail14.render(f5);
        tail15.render(f5);
        tail16.render(f5);
        tail17.render(f5);
        tail18.render(f5);
        earL1.render(f5);
        earL2.render(f5);
        earR1.render(f5);
        earR2.render(f5);
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
    }
}
