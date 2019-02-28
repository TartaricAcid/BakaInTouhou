package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityDaiyouseiModel extends ModelBase {

    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer hair;
    ModelRenderer headdressM;
    ModelRenderer headdressB;
    ModelRenderer headdressF;
    ModelRenderer wingL;
    ModelRenderer wingR;
    ModelRenderer handR;
    ModelRenderer handL;

    public EntityDaiyouseiModel() {
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
        footR = new ModelRenderer(this, 91, 0);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 91, 0);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        hair = new ModelRenderer(this, 100, 0);
        hair.addBox(0F, 0F, -1F, 2, 9, 2);
        hair.setRotationPoint(3.2F, 0F, -1F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0F, 0F, -0.3490659F);
        headdressM = new ModelRenderer(this, 109, 0);
        headdressM.addBox(-1F, -1F, -1F, 2, 2, 2);
        headdressM.setRotationPoint(4.5F, -0.2F, -1F);
        headdressM.setTextureSize(128, 32);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, -0.2974289F);
        headdressB = new ModelRenderer(this, 109, 5);
        headdressB.addBox(0F, -1F, 0F, 1, 3, 5);
        headdressB.setRotationPoint(4F, -0.5F, 0F);
        headdressB.setTextureSize(128, 32);
        headdressB.mirror = true;
        setRotation(headdressB, 0.2935045F, 0.5235988F, 0F);
        headdressF = new ModelRenderer(this, 109, 5);
        headdressF.addBox(0F, -1F, -5F, 1, 3, 5);
        headdressF.setRotationPoint(4F, -0.5F, -2F);
        headdressF.setTextureSize(128, 32);
        headdressF.mirror = true;
        setRotation(headdressF, -0.3827331F, -0.3490659F, 0F);
        wingL = new ModelRenderer(this, 41, 17);
        wingL.addBox(0F, -3F, 0F, 16, 6, 0);
        wingL.setRotationPoint(1F, 12F, 3.5F);
        wingL.setTextureSize(128, 32);
        wingL.mirror = true;
        setRotation(wingL, 0F, -0.1745329F, -0.3141593F);
        wingR = new ModelRenderer(this, 41, 24);
        wingR.addBox(-16F, -3F, 0F, 16, 6, 0);
        wingR.setRotationPoint(-2F, 12F, 3.5F);
        wingR.setTextureSize(128, 32);
        wingR.mirror = true;
        setRotation(wingR, 0F, 0.1745329F, 0.3141593F);
        handR = new ModelRenderer(this, 91, 5);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.5235988F);
        handL = new ModelRenderer(this, 91, 5);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.5235988F);

        head.addChild(hair);
        head.addChild(headdressB);
        head.addChild(headdressF);
        head.addChild(headdressM);
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
        wingL.render(f5);
        wingR.render(f5);
        handR.render(f5);
        handL.render(f5);
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
        this.headdressF.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.3f;
        this.headdressB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.3f;

        // 头发的周期运动
        this.hair.rotateAngleZ = MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0.3f;
    }
}
