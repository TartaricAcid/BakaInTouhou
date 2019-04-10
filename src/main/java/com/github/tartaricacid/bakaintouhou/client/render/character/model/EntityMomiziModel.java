package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityMomiziModel extends ModelBase {

    //fields
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer head;
    ModelRenderer earL1;
    ModelRenderer earL2;
    ModelRenderer earR2;
    ModelRenderer earR1;
    ModelRenderer headdressL;
    ModelRenderer headdressR;
    ModelRenderer bodydress;
    ModelRenderer tail1;
    ModelRenderer tail2;

    public EntityMomiziModel() {
        textureWidth = 128;
        textureHeight = 32;
        setTextureOffset("head.headM", 0, 0);
        setTextureOffset("head.hat", 42, 12);

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
        head = new ModelRenderer(this, "head");
        head.setRotationPoint(0F, 0F, 0F);
        setRotation(head, 0, 0F, 0);
        head.mirror = true;
        head.addBox("headM", -4F, 0F, -4F, 8, 8, 8);
        head.addBox("hat", -1.5F, -2F, -1.5F, 3, 2, 3);
        earL1 = new ModelRenderer(this, 55, 13);
        earL1.addBox(-4F, -3F, 0F, 2, 3, 1);
        earL1.setRotationPoint(0F, 0F, 0F);
        earL1.setTextureSize(128, 32);
        earL1.mirror = true;
        setRotation(earL1, 0F, 0F, -0.1745329F);
        earL2 = new ModelRenderer(this, 55, 13);
        earL2.addBox(-2F, -4F, 0F, 2, 4, 1);
        earL2.setRotationPoint(0F, 0F, 0F);
        earL2.setTextureSize(128, 32);
        earL2.mirror = true;
        setRotation(earL2, 0F, 0F, -0.7330383F);
        earR2 = new ModelRenderer(this, 55, 13);
        earR2.addBox(0F, -4F, 0F, 2, 4, 1);
        earR2.setRotationPoint(0F, 0F, 0F);
        earR2.setTextureSize(128, 32);
        earR2.mirror = true;
        setRotation(earR2, 0F, 0F, 0.7330383F);
        earR1 = new ModelRenderer(this, 55, 13);
        earR1.addBox(2F, -3F, 0F, 2, 3, 1);
        earR1.setRotationPoint(0F, 0F, 0F);
        earR1.setTextureSize(128, 32);
        earR1.mirror = true;
        setRotation(earR1, 0F, 0F, 0.1745329F);
        headdressL = new ModelRenderer(this, 100, 0);
        headdressL.addBox(-1.8F, 0F, -0.5F, 1, 7, 0);
        headdressL.setRotationPoint(0F, 0F, 0F);
        headdressL.setTextureSize(128, 32);
        headdressL.mirror = true;
        setRotation(headdressL, 0F, 0F, 1.22173F);
        headdressR = new ModelRenderer(this, 100, 0);
        headdressR.addBox(0.8F, 0F, 0F, 1, 7, 0);
        headdressR.setRotationPoint(0F, 0F, -0.5F);
        headdressR.setTextureSize(128, 32);
        headdressR.mirror = true;
        setRotation(headdressR, 0F, 0F, -1.22173F);
        bodydress = new ModelRenderer(this, 63, 13);
        bodydress.addBox(-1F, -1F, 0F, 2, 2, 1);
        bodydress.setRotationPoint(0F, 9.6F, -4F);
        bodydress.setTextureSize(128, 32);
        bodydress.mirror = true;
        setRotation(bodydress, 0F, 0F, 0F);
        tail1 = new ModelRenderer(this, 41, 21);
        tail1.addBox(-2F, -2F, 0F, 4, 4, 7);
        tail1.setRotationPoint(0F, 17F, 4F);
        tail1.setTextureSize(128, 32);
        tail1.mirror = true;
        setRotation(tail1, 0.6108652F, -0.1745329F, 0F);
        tail2 = new ModelRenderer(this, 64, 21);
        tail2.addBox(-1F, -1F, 0F, 2, 2, 5);
        tail2.setRotationPoint(-1.5F, 14F, 8.5F);
        tail2.setTextureSize(128, 32);
        tail2.mirror = true;
        setRotation(tail2, 0.6108652F, 0.2617994F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        footR.render(f5);
        footL.render(f5);
        handR.render(f5);
        handL.render(f5);
        head.render(f5);
        earL1.render(f5);
        earL2.render(f5);
        earR2.render(f5);
        earR1.render(f5);
        headdressL.render(f5);
        headdressR.render(f5);
        bodydress.render(f5);
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
        //this.head.rotateAngleX = headPitch / 45f / (float) Math.PI;
        this.head.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;

        // 左脚右脚，左手右手的运动
        this.footL.rotateAngleX = MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.footR.rotateAngleX = -MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.handL.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.523f;
        this.handR.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.523f;

        // 尾巴的周期运动
        //this.tail1.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 1.9f;
        this.tail1.rotateAngleY = MathHelper.cos(ageInTicks * 0.1f) * 0.05f - 0.2f;
        this.tail2.rotateAngleY = MathHelper.cos(ageInTicks * 0.1f) * 0.05f - 0.2f;
    }
}
