package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityMarisaModel extends EntityTouhouCharacterModel {
    //fields
    private ModelRenderer face;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer footR;
    private ModelRenderer footL;
    private ModelRenderer hat1;
    private ModelRenderer hat2;
    private ModelRenderer hat3;
    private ModelRenderer hat4;
    private ModelRenderer headdressM;
    private ModelRenderer headdressR;
    private ModelRenderer headdressL;
    private ModelRenderer handR;
    private ModelRenderer handL;
    private ModelRenderer bowM;
    private ModelRenderer bowLB;
    private ModelRenderer bowLT;
    private ModelRenderer bowRT;
    private ModelRenderer bowRB;

    public EntityMarisaModel() {
        textureWidth = 128;
        textureHeight = 64;

        face = new ModelRenderer(this, 0, 0);
        face.addBox(-4F, 0F, -4F, 8, 8, 8);
        face.setRotationPoint(0F, 0F, 0F);
        face.setTextureSize(128, 64);
        face.mirror = true;
        setRotation(face, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 0, 19);
        body1.addBox(-3F, 0F, -3F, 6, 5, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 34, 0);
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 13F, 0F);
        body2.setTextureSize(128, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 26, 17);
        body3.addBox(-5F, 0F, -5F, 10, 5, 10);
        body3.setRotationPoint(0F, 17F, 0F);
        body3.setTextureSize(128, 64);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 69, 25);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 64);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 69, 25);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 64);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        hat1 = new ModelRenderer(this, 0, 34);
        hat1.addBox(-8F, 0F, -8F, 16, 2, 16);
        hat1.setRotationPoint(0F, 1F, 0F);
        hat1.setTextureSize(128, 64);
        hat1.mirror = true;
        setRotation(hat1, 0F, 0F, 0.0349066F);
        hat2 = new ModelRenderer(this, 68, 0);
        hat2.addBox(-5F, 0F, -5F, 10, 5, 10);
        hat2.setRotationPoint(0F, -3F, 0F);
        hat2.setTextureSize(128, 64);
        hat2.mirror = true;
        setRotation(hat2, 0F, 0F, 0.0349066F);
        hat3 = new ModelRenderer(this, 84, 18);
        hat3.addBox(-3F, 0F, -2F, 6, 6, 6);
        hat3.setRotationPoint(1F, -8F, 0F);
        hat3.setTextureSize(128, 64);
        hat3.mirror = true;
        setRotation(hat3, 0F, 0F, 0.1396263F);
        hat4 = new ModelRenderer(this, 69, 17);
        hat4.addBox(-1F, 0F, -1F, 2, 4, 2);
        hat4.setRotationPoint(1.5F, -11F, 1F);
        hat4.setTextureSize(128, 64);
        hat4.mirror = true;
        setRotation(hat4, 0F, 0F, 0.1396263F);
        headdressM = new ModelRenderer(this, 69, 32);
        headdressM.addBox(-1F, -1F, 0F, 2, 2, 2);
        headdressM.setRotationPoint(0F, -2F, -7F);
        headdressM.setTextureSize(128, 64);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, 0.1745329F);
        headdressR = new ModelRenderer(this, 69, 38);
        headdressR.addBox(-6F, -2F, 0F, 6, 4, 1);
        headdressR.setRotationPoint(-1F, -2F, -6F);
        headdressR.setTextureSize(128, 64);
        headdressR.mirror = true;
        setRotation(headdressR, 0F, 0F, 0.1661728F);
        headdressL = new ModelRenderer(this, 69, 38);
        headdressL.addBox(0F, -2F, 0F, 6, 4, 1);
        headdressL.setRotationPoint(1F, -2F, -6F);
        headdressL.setTextureSize(128, 64);
        headdressL.mirror = true;
        setRotation(headdressL, 0F, 0F, 0.1745329F);
        handR = new ModelRenderer(this, 69, 45);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 8F, 0F);
        handR.setTextureSize(128, 64);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 69, 45);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 8F, 0F);
        handL.setTextureSize(128, 64);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        bowM = new ModelRenderer(this, 85, 33);
        bowM.addBox(-1F, -1F, 0F, 2, 2, 2);
        bowM.setRotationPoint(0F, 11F, 3F);
        bowM.setTextureSize(128, 64);
        bowM.mirror = true;
        setRotation(bowM, 0F, 0F, 0F);
        bowLB = new ModelRenderer(this, 85, 39);
        bowLB.addBox(0F, -2F, 0F, 7, 4, 1);
        bowLB.setRotationPoint(1F, 11F, 3.5F);
        bowLB.setTextureSize(128, 64);
        bowLB.mirror = true;
        setRotation(bowLB, 0F, 0F, 0.6981317F);
        bowLT = new ModelRenderer(this, 85, 46);
        bowLT.addBox(0F, -1F, 0F, 5, 2, 1);
        bowLT.setRotationPoint(0.5F, 10F, 4F);
        bowLT.setTextureSize(128, 64);
        bowLT.mirror = true;
        setRotation(bowLT, 0F, 0F, -0.2617994F);
        bowRT = new ModelRenderer(this, 85, 46);
        bowRT.addBox(-6F, -1F, 0F, 5, 2, 1);
        bowRT.setRotationPoint(0.5F, 10.2F, 4F);
        bowRT.setTextureSize(128, 64);
        bowRT.mirror = true;
        setRotation(bowRT, 0F, 0F, 0.2617994F);
        bowRB = new ModelRenderer(this, 85, 39);
        bowRB.addBox(-7F, -2F, 0F, 7, 4, 1);
        bowRB.setRotationPoint(-1F, 11F, 3.5F);
        bowRB.setTextureSize(128, 64);
        bowRB.mirror = true;
        setRotation(bowRB, 0F, 0F, -0.6981317F);

        face.addChild(hat1);
        face.addChild(hat2);
        face.addChild(hat3);
        face.addChild(hat4);
        face.addChild(headdressL);
        face.addChild(headdressR);
        face.addChild(headdressM);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        face.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        footR.render(f5);
        footL.render(f5);
        handR.render(f5);
        handL.render(f5);
        bowM.render(f5);
        bowLB.render(f5);
        bowLT.render(f5);
        bowRT.render(f5);
        bowRB.render(f5);
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
        this.face.rotateAngleX = headPitch / 45f / (float) Math.PI;
        this.face.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;

        // 左脚右脚，左手右手的运动
        this.footL.rotateAngleX = MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.footR.rotateAngleX = -MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.handL.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.523f;
        this.handR.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.523f;

        // 蝴蝶结的周期运动
        this.bowLB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.bowLT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.bowRB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.bowRT.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;

        // 头饰周期性运动
        this.headdressL.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.headdressR.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
    }
}
