package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntitySuikaModel extends EntityTouhouCharacterModel {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer hand1;
    ModelRenderer hand2;
    ModelRenderer footL;
    ModelRenderer footR;
    ModelRenderer hornL1;
    ModelRenderer hornR1;
    ModelRenderer hornL2;
    ModelRenderer hornL3;
    ModelRenderer hornR2;
    ModelRenderer hornR3;
    ModelRenderer gourd1;
    ModelRenderer gourd2;
    ModelRenderer gourd3;
    ModelRenderer headdress1;
    ModelRenderer headdress2;
    ModelRenderer headdress3;
    ModelRenderer headdress4;
    ModelRenderer headdress5;
    ModelRenderer hairL;
    ModelRenderer hairR;
    ModelRenderer headdress6;

    public EntitySuikaModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 2F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 6, 6);
        body1.setRotationPoint(0F, 10F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 6, 8);
        body2.setRotationPoint(0F, 16F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        hand1 = new ModelRenderer(this, 91, 0);
        hand1.addBox(0F, 0F, -1F, 2, 8, 2);
        hand1.setRotationPoint(3F, 11F, 0F);
        hand1.setTextureSize(128, 32);
        hand1.mirror = true;
        setRotation(hand1, 0F, 0F, -0.4363323F);
        hand2 = new ModelRenderer(this, 91, 0);
        hand2.addBox(-2F, 0F, -1F, 2, 8, 2);
        hand2.setRotationPoint(-3F, 11F, 0F);
        hand2.setTextureSize(128, 32);
        hand2.mirror = true;
        setRotation(hand2, 0F, 0F, 0.4363323F);
        footL = new ModelRenderer(this, 100, 0);
        footL.addBox(0F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(1F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 100, 0);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-1F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        hornL1 = new ModelRenderer(this, 109, 0);
        hornL1.addBox(0F, -1F, -1F, 5, 1, 2);
        hornL1.setRotationPoint(3F, 3F, 0F);
        hornL1.setTextureSize(128, 32);
        hornL1.mirror = true;
        setRotation(hornL1, 0F, 0F, -0.6108652F);
        hornR1 = new ModelRenderer(this, 109, 0);
        hornR1.addBox(-5F, -1F, -1F, 5, 1, 2);
        hornR1.setRotationPoint(-3F, 3F, 0F);
        hornR1.setTextureSize(128, 32);
        hornR1.mirror = true;
        setRotation(hornR1, 0F, 0F, 0.6108652F);
        hornL2 = new ModelRenderer(this, 100, 5);
        hornL2.addBox(0F, -1F, -0.5F, 3, 1, 1);
        hornL2.setRotationPoint(7F, 0F, 0F);
        hornL2.setTextureSize(128, 32);
        hornL2.mirror = true;
        setRotation(hornL2, 0F, 0F, -0.9773844F);
        hornL3 = new ModelRenderer(this, 100, 8);
        hornL3.addBox(0F, -1F, -0.5F, 3, 1, 1);
        hornL3.setRotationPoint(8.3F, -2F, 0F);
        hornL3.setTextureSize(128, 32);
        hornL3.mirror = true;
        setRotation(hornL3, 0F, 0F, -0.6108652F);
        hornR2 = new ModelRenderer(this, 100, 5);
        hornR2.addBox(-3F, -1F, -0.5F, 3, 1, 1);
        hornR2.setRotationPoint(-7F, 0F, 0F);
        hornR2.setTextureSize(128, 32);
        hornR2.mirror = true;
        setRotation(hornR2, 0F, 0F, 0.9773844F);
        hornR3 = new ModelRenderer(this, 100, 8);
        hornR3.addBox(-3F, -1F, -0.5F, 3, 1, 1);
        hornR3.setRotationPoint(-8.3F, -2F, 0F);
        hornR3.setTextureSize(128, 32);
        hornR3.mirror = true;
        setRotation(hornR3, 0F, 0F, 0.6108652F);
        gourd1 = new ModelRenderer(this, 109, 4);
        gourd1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
        gourd1.setRotationPoint(2F, 17F, -5F);
        gourd1.setTextureSize(128, 32);
        gourd1.mirror = true;
        setRotation(gourd1, 0F, 0F, -0.5235988F);
        gourd2 = new ModelRenderer(this, 91, 11);
        gourd2.addBox(-1F, 0F, -1F, 2, 2, 2);
        gourd2.setRotationPoint(1F, 15F, -5F);
        gourd2.setTextureSize(128, 32);
        gourd2.mirror = true;
        setRotation(gourd2, 0F, 0F, -0.5235988F);
        gourd3 = new ModelRenderer(this, 122, 4);
        gourd3.addBox(-1F, 0F, -0.5F, 1, 4, 1);
        gourd3.setRotationPoint(1F, 14F, -5F);
        gourd3.setTextureSize(128, 32);
        gourd3.mirror = true;
        setRotation(gourd3, 0F, 0F, -0.5235988F);
        headdress1 = new ModelRenderer(this, 100, 11);
        headdress1.addBox(-4F, -1F, 0F, 7, 2, 1);
        headdress1.setRotationPoint(0F, 3F, 4F);
        headdress1.setTextureSize(128, 32);
        headdress1.mirror = true;
        setRotation(headdress1, 0F, 0F, 0.5235988F);
        headdress2 = new ModelRenderer(this, 100, 11);
        headdress2.addBox(-3F, -1F, 0F, 7, 2, 1);
        headdress2.setRotationPoint(0F, 3F, 4F);
        headdress2.setTextureSize(128, 32);
        headdress2.mirror = true;
        setRotation(headdress2, 0F, 0F, -0.5235988F);
        headdress3 = new ModelRenderer(this, 117, 11);
        headdress3.addBox(-2F, -2F, -0.5F, 2, 2, 1);
        headdress3.setRotationPoint(7F, -1F, 1F);
        headdress3.setTextureSize(128, 32);
        headdress3.mirror = true;
        setRotation(headdress3, -0.0872665F, 0F, 0.7853982F);
        headdress4 = new ModelRenderer(this, 117, 11);
        headdress4.addBox(-2F, -2F, -0.5F, 2, 2, 1);
        headdress4.setRotationPoint(7F, -1F, -1F);
        headdress4.setTextureSize(128, 32);
        headdress4.mirror = true;
        setRotation(headdress4, 0.0872665F, 0F, 0.7853982F);
        headdress5 = new ModelRenderer(this, 117, 11);
        headdress5.addBox(-1F, -1F, -0.5F, 2, 2, 1);
        headdress5.setRotationPoint(7.5F, -1.5F, 0F);
        headdress5.setTextureSize(128, 32);
        headdress5.mirror = true;
        setRotation(headdress5, 0.8726646F, 1.570796F, 0F);
        hairL = new ModelRenderer(this, 0, 17);
        hairL.addBox(0F, 0F, 0F, 2, 6, 2);
        hairL.setRotationPoint(2F, 10F, 2F);
        hairL.setTextureSize(128, 32);
        hairL.mirror = true;
        setRotation(hairL, 0.3490659F, 0.0698132F, -0.3490659F);
        hairR = new ModelRenderer(this, 0, 17);
        hairR.addBox(-2F, 0F, 0F, 2, 6, 2);
        hairR.setRotationPoint(-2F, 10F, 2F);
        hairR.setTextureSize(128, 32);
        hairR.mirror = true;
        setRotation(hairR, 0.3490659F, -0.0698132F, 0.3490659F);
        headdress6 = new ModelRenderer(this, 91, 16);
        headdress6.addBox(-2F, 0F, 0F, 4, 2, 1);
        headdress6.setRotationPoint(0F, 2F, 4.5F);
        headdress6.setTextureSize(128, 32);
        headdress6.mirror = true;
        setRotation(headdress6, 0F, 0F, 0F);

        head.addChild(hornL1);
        head.addChild(hornL2);
        head.addChild(hornL3);
        head.addChild(hornR1);
        head.addChild(hornR2);
        head.addChild(hornR3);
        head.addChild(headdress1);
        head.addChild(headdress2);
        head.addChild(headdress3);
        head.addChild(headdress4);
        head.addChild(headdress5);
        head.addChild(headdress6);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        hand1.render(f5);
        hand2.render(f5);
        footL.render(f5);
        footR.render(f5);
        gourd1.render(f5);
        gourd2.render(f5);
        gourd3.render(f5);
        hairL.render(f5);
        hairR.render(f5);
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
        this.hand1.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.hand1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.523f;
        this.hand2.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.hand2.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.523f;

        // 头发的周期运动
        this.hairL.rotateAngleZ = MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.hairR.rotateAngleZ = -MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
