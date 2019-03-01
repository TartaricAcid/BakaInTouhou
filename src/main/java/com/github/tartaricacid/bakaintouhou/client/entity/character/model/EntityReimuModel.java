package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityReimuModel extends EntityTouhouCharacterModel {

    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer footL;
    private ModelRenderer footR;
    private ModelRenderer headdressM;
    private ModelRenderer hair;
    private ModelRenderer headdressLT;
    private ModelRenderer headdressRT;
    private ModelRenderer headdressLB;
    private ModelRenderer headdressRB;
    private ModelRenderer handR;
    private ModelRenderer handL;
    private ModelRenderer hair2;

    public EntityReimuModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 32, 0);
        body1.addBox(-3F, 0F, -3F, 6, 4, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 0, 16);
        body2.addBox(-4F, 0F, -4F, 8, 3, 8);
        body2.setRotationPoint(0F, 12F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 56, 0);
        body3.addBox(-5F, 0F, -5F, 10, 6, 10);
        body3.setRotationPoint(0F, 15F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 0, 27);
        footL.addBox(0F, 0F, -1F, 2, 3, 2);
        footL.setRotationPoint(1F, 21F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 0, 27);
        footR.addBox(-1F, 0F, -1F, 2, 3, 2);
        footR.setRotationPoint(-2F, 21F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        headdressM = new ModelRenderer(this, 32, 16);
        headdressM.addBox(-1F, -1F, 0F, 2, 2, 3);
        headdressM.setRotationPoint(0F, 0F, 4F);
        headdressM.setTextureSize(128, 32);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, 0F);
        hair = new ModelRenderer(this, 52, 17);
        hair.addBox(0F, 0F, 0F, 2, 9, 1);
        hair.setRotationPoint(-1F, 0F, 5F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0.1745329F, 0F, -0.2617994F);
        headdressLT = new ModelRenderer(this, 32, 21);
        headdressLT.addBox(0F, -2F, 0F, 8, 4, 1);
        headdressLT.setRotationPoint(1F, 0F, 4F);
        headdressLT.setTextureSize(128, 32);
        headdressLT.mirror = true;
        setRotation(headdressLT, 0F, 0F, -0.1745329F);
        headdressRT = new ModelRenderer(this, 32, 26);
        headdressRT.addBox(-9F, -2F, 0F, 8, 4, 1);
        headdressRT.setRotationPoint(0F, 0F, 4F);
        headdressRT.setTextureSize(128, 32);
        headdressRT.mirror = true;
        setRotation(headdressRT, 0F, 0F, 0.1745329F);
        headdressLB = new ModelRenderer(this, 42, 11);
        headdressLB.addBox(-2F, 0F, 0F, 4, 9, 1);
        headdressLB.setRotationPoint(1F, 1F, 4F);
        headdressLB.setTextureSize(128, 32);
        headdressLB.mirror = true;
        setRotation(headdressLB, 0F, 0F, -0.6981317F);
        headdressRB = new ModelRenderer(this, 42, 11);
        headdressRB.addBox(-2F, 0F, 0F, 4, 9, 1);
        headdressRB.setRotationPoint(-1F, 1F, 4F);
        headdressRB.setTextureSize(128, 32);
        headdressRB.mirror = true;
        setRotation(headdressRB, 0F, 0F, 0.6981317F);
        handR = new ModelRenderer(this, 96, 0);
        handR.addBox(-1F, 0F, -1F, 2, 9, 2);
        handR.setRotationPoint(-4F, 8F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.3490659F);
        handL = new ModelRenderer(this, 96, 0);
        handL.addBox(-1F, 0F, -1F, 2, 9, 2);
        handL.setRotationPoint(4F, 8F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.3490659F);
        hair2 = new ModelRenderer(this, 58, 18);
        hair2.addBox(-4F, 0F, 0F, 8, 9, 0);
        hair2.setRotationPoint(0F, 8F, 4F);
        hair2.setTextureSize(128, 32);
        hair2.mirror = true;
        setRotation(hair2, 0.3490659F, 0F, 0F);

        head.addChild(hair);
        head.addChild(hair2);
        head.addChild(headdressM);
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
        footL.render(f5);
        footR.render(f5);
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

        // 头饰的周期运动
        this.headdressLB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressLT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressRB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.headdressRT.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }
}
