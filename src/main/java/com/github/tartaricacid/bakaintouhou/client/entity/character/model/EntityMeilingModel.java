package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityMeilingModel extends ModelBase {

    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer hat;
    ModelRenderer hair;
    ModelRenderer hairR;
    ModelRenderer hairL;
    ModelRenderer handR;
    ModelRenderer handL;

    public EntityMeilingModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 6, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 8, 8);
        body2.setRotationPoint(0F, 14F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 68, 18);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 68, 18);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        hat = new ModelRenderer(this, 0, 19);
        hat.addBox(-3.5F, 0F, -3.5F, 7, 2, 7);
        hat.setRotationPoint(0F, -2F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        hair = new ModelRenderer(this, 29, 19);
        hair.addBox(-4F, 0F, 0F, 8, 10, 0);
        hair.setRotationPoint(0F, 8F, 4F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0.535372F, 0F, 0F);
        hairR = new ModelRenderer(this, 46, 19);
        hairR.addBox(0F, 0F, 0F, 0, 4, 1);
        hairR.setRotationPoint(-4F, 8F, -3.5F);
        hairR.setTextureSize(128, 32);
        hairR.mirror = true;
        setRotation(hairR, 0F, 0F, 0.1745329F);
        hairL = new ModelRenderer(this, 46, 19);
        hairL.addBox(0F, 0F, 0F, 0, 4, 1);
        hairL.setRotationPoint(4F, 8F, -3.5F);
        hairL.setTextureSize(128, 32);
        hairL.mirror = true;
        setRotation(hairL, 0F, 0F, -0.1745329F);
        handR = new ModelRenderer(this, 58, 18);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 58, 18);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);

        head.addChild(hat);
        head.addChild(hair);
        head.addChild(hairR);
        head.addChild(hairL);
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

        // 头发的周期运动
        this.hair.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.5f;
        this.hairL.rotateAngleZ = MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.hairR.rotateAngleZ = -MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }

}
