package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityLilyModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer armR;
    ModelRenderer armL;
    ModelRenderer hat1;
    ModelRenderer hat2;
    ModelRenderer hat3;
    ModelRenderer hat4;
    ModelRenderer headdress;
    ModelRenderer hair;
    ModelRenderer wingL;
    ModelRenderer wingR;

    public EntityLilyModel() {
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
        body2.addBox(-4F, 0F, -4F, 8, 7, 8);
        body2.setRotationPoint(0F, 13F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 33, 12);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 20F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 33, 12);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 20F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 91, 0);
        handR.addBox(-1F, 0F, -1F, 2, 7, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.7853982F);
        handL = new ModelRenderer(this, 91, 0);
        handL.addBox(-1F, 0F, -1F, 2, 7, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.7853982F);
        armR = new ModelRenderer(this, 100, 0);
        armR.addBox(-1.5F, -1F, -1.5F, 4, 6, 3);
        armR.setRotationPoint(-4F, 9F, 0F);
        armR.setTextureSize(128, 32);
        armR.mirror = true;
        setRotation(armR, 0F, 0F, 0.7853982F);
        armL = new ModelRenderer(this, 100, 0);
        armL.addBox(-1.5F, -1F, -1.5F, 4, 6, 3);
        armL.setRotationPoint(3.5F, 9.5F, 0F);
        armL.setTextureSize(128, 32);
        armL.mirror = true;
        setRotation(armL, 0F, 0F, -0.7853982F);
        hat1 = new ModelRenderer(this, 0, 17);
        hat1.addBox(-3F, 0F, -3F, 6, 2, 6);
        hat1.setRotationPoint(0F, -3F, 0F);
        hat1.setTextureSize(128, 32);
        hat1.mirror = true;
        setRotation(hat1, 0F, 0F, 0F);
        hat2 = new ModelRenderer(this, 0, 26);
        hat2.addBox(-2F, 0F, -2F, 4, 1, 4);
        hat2.setRotationPoint(0F, -4F, 0F);
        hat2.setTextureSize(128, 32);
        hat2.mirror = true;
        setRotation(hat2, 0F, 0F, 0F);
        hat3 = new ModelRenderer(this, 17, 26);
        hat3.addBox(-1F, 0F, -1F, 2, 1, 2);
        hat3.setRotationPoint(0F, -5F, 0F);
        hat3.setTextureSize(128, 32);
        hat3.mirror = true;
        setRotation(hat3, 0F, 0F, 0F);
        hat4 = new ModelRenderer(this, 26, 17);
        hat4.addBox(-4.5F, 0F, -4.5F, 9, 3, 9);
        hat4.setRotationPoint(0F, -1.6F, 0F);
        hat4.setTextureSize(128, 32);
        hat4.mirror = true;
        setRotation(hat4, 0F, 0F, 0F);
        headdress = new ModelRenderer(this, 42, 12);
        headdress.addBox(-3F, -2F, 0F, 6, 4, 0);
        headdress.setRotationPoint(5F, 0F, -4F);
        headdress.setTextureSize(128, 32);
        headdress.mirror = true;
        setRotation(headdress, 0F, -1.047198F, 0F);
        hair = new ModelRenderer(this, 63, 17);
        hair.addBox(-4F, 0F, 0F, 8, 10, 0);
        hair.setRotationPoint(0F, 8F, 4F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0.5235988F, 0F, 0F);
        wingL = new ModelRenderer(this, 91, 10);
        wingL.addBox(0F, -5F, 0F, 16, 10, 0);
        wingL.setRotationPoint(1F, 12F, 4F);
        wingL.setTextureSize(128, 32);
        wingL.mirror = true;
        setRotation(wingL, 0.1745329F, -0.4363323F, 0F);
        wingR = new ModelRenderer(this, 91, 21);
        wingR.addBox(0F, -5F, 0F, 16, 10, 0);
        wingR.setRotationPoint(-1F, 12F, 4F);
        wingR.setTextureSize(128, 32);
        wingR.mirror = true;
        setRotation(wingR, -0.1745329F, 0.4363323F, 3.141593F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        footR.render(f5);
        footL.render(f5);
        handR.render(f5);
        handL.render(f5);
        armR.render(f5);
        armL.render(f5);
        hat1.render(f5);
        hat2.render(f5);
        hat3.render(f5);
        hat4.render(f5);
        headdress.render(f5);
        hair.render(f5);
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
        this.armL.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.armL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.523f;
        this.armR.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.armR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.523f;

        // 翅膀的周期运动
        this.wingL.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingR.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;

        // 头饰的周期运动
        this.headdress.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 1.0f;

        // 头发的周期运动
        this.hair.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.5f;
    }
}
