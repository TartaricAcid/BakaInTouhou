package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityCirnoModel extends EntityTouhouCharacterModel {
    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer wingR1;
    private ModelRenderer wingR2;
    private ModelRenderer wingR3;
    private ModelRenderer wingL1;
    private ModelRenderer wingL2;
    private ModelRenderer wingL3;
    private ModelRenderer headdress1;
    private ModelRenderer headdress2;
    private ModelRenderer headdress3;
    private ModelRenderer footL;
    private ModelRenderer footR;
    private ModelRenderer handL;
    private ModelRenderer handR;

    public EntityCirnoModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 32, 0);
        body1.addBox(0F, 0F, 0F, 6, 3, 6);
        body1.setRotationPoint(-3F, 8F, -3F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 56, 0);
        body2.addBox(0F, 0F, 0F, 8, 5, 8);
        body2.setRotationPoint(-4F, 11F, -4F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 42, 16);
        body3.addBox(0F, 0F, 0F, 10, 6, 10);
        body3.setRotationPoint(-5F, 16F, -5F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        wingR1 = new ModelRenderer(this, 8, 28);
        wingR1.addBox(0F, 0F, -1F, 10, 2, 2);
        wingR1.setRotationPoint(1.3F, 7F, 4F);
        wingR1.setTextureSize(128, 32);
        wingR1.mirror = true;
        setRotation(wingR1, 0F, 0F, -0.3141593F);
        wingR2 = new ModelRenderer(this, 8, 28);
        wingR2.addBox(0F, 0F, 0F, 10, 2, 2);
        wingR2.setRotationPoint(2F, 9F, 3F);
        wingR2.setTextureSize(128, 32);
        wingR2.mirror = true;
        setRotation(wingR2, 0F, 0F, 0F);
        wingR3 = new ModelRenderer(this, 8, 28);
        wingR3.addBox(0F, 0F, 0F, 10, 2, 2);
        wingR3.setRotationPoint(2F, 11F, 3F);
        wingR3.setTextureSize(128, 32);
        wingR3.mirror = true;
        setRotation(wingR3, 0F, 0F, 0.3141593F);
        wingL1 = new ModelRenderer(this, 8, 28);
        wingL1.addBox(-10F, 0F, 0F, 10, 2, 2);
        wingL1.setRotationPoint(-1F, 7F, 3F);
        wingL1.setTextureSize(128, 32);
        wingL1.mirror = true;
        setRotation(wingL1, 0F, 0F, 0.3141593F);
        wingL2 = new ModelRenderer(this, 8, 28);
        wingL2.addBox(-10F, 0F, 0F, 10, 2, 2);
        wingL2.setRotationPoint(-2F, 9F, 3F);
        wingL2.setTextureSize(128, 32);
        wingL2.mirror = true;
        setRotation(wingL2, 0F, 0F, 0F);
        wingL3 = new ModelRenderer(this, 8, 28);
        wingL3.addBox(-10F, 0F, 0F, 10, 2, 2);
        wingL3.setRotationPoint(-2F, 11F, 3F);
        wingL3.setTextureSize(128, 32);
        wingL3.mirror = true;
        setRotation(wingL3, 0F, 0F, -0.3141593F);
        headdress1 = new ModelRenderer(this, 8, 23);
        headdress1.addBox(0F, -2F, 0F, 6, 4, 1);
        headdress1.setRotationPoint(1F, 1F, 4F);
        headdress1.setTextureSize(128, 32);
        headdress1.mirror = true;
        setRotation(headdress1, -0.0594858F, 0F, 0F);
        headdress2 = new ModelRenderer(this, 8, 23);
        headdress2.addBox(-6F, -2F, 0F, 6, 4, 1);
        headdress2.setRotationPoint(-1F, 1F, 4F);
        headdress2.setTextureSize(128, 32);
        headdress2.mirror = true;
        setRotation(headdress2, 0.0892287F, 0F, 0F);
        headdress3 = new ModelRenderer(this, 22, 24);
        headdress3.addBox(0F, 0F, 0F, 2, 2, 2);
        headdress3.setRotationPoint(-1F, 0F, 4F);
        headdress3.setTextureSize(128, 32);
        headdress3.mirror = true;
        setRotation(headdress3, 0.0892287F, 0F, 0F);
        footL = new ModelRenderer(this, 32, 28);
        footL.addBox(0F, 0F, 0F, 3, 2, 2);
        footL.setRotationPoint(1F, 22F, -1F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 32, 28);
        footR.addBox(0F, 0F, 0F, 3, 2, 2);
        footR.setRotationPoint(-4F, 22F, -1F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        handL = new ModelRenderer(this, 0, 20);
        handL.addBox(0F, 0F, 0F, 2, 10, 2);
        handL.setRotationPoint(5F, 8F, 1F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 3.141593F, -0.5235988F);
        handR = new ModelRenderer(this, 0, 20);
        handR.addBox(0F, 0F, 0F, 2, 10, 2);
        handR.setRotationPoint(-3F, 9F, 1F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 3.141593F, 0.5235988F);

        head.addChild(headdress1);
        head.addChild(headdress2);
        head.addChild(headdress3);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        wingR1.render(f5);
        wingR2.render(f5);
        wingR3.render(f5);
        wingL1.render(f5);
        wingL2.render(f5);
        wingL3.render(f5);
        footL.render(f5);
        footR.render(f5);
        handL.render(f5);
        handR.render(f5);
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
        this.wingR1.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingR2.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingR3.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingL1.rotateAngleY = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.8f;
        this.wingL2.rotateAngleY = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.8f;
        this.wingL3.rotateAngleY = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.8f;

        // 头饰的周期运动
        this.headdress1.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdress2.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
