package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityKisumeModel extends EntityTouhouCharacterModel {
    //fields
    private ModelRenderer barrel1;
    private ModelRenderer barrel2;
    private ModelRenderer barrel3;
    private ModelRenderer barrel4;
    private ModelRenderer barrel5;
    private ModelRenderer barrel6;
    private ModelRenderer barrel7;
    private ModelRenderer barrel8;
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer handL;
    private ModelRenderer handR;
    private ModelRenderer hairL;
    private ModelRenderer hairR;
    private ModelRenderer barrelB;

    public EntityKisumeModel() {
        textureWidth = 128;
        textureHeight = 32;

        barrel1 = new ModelRenderer(this, 0, 0);
        barrel1.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel1.setRotationPoint(0F, 24F, 5F);
        barrel1.setTextureSize(128, 32);
        barrel1.mirror = true;
        setRotation(barrel1, -0.1047198F, 0F, 0F);
        barrel2 = new ModelRenderer(this, 0, 0);
        barrel2.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel2.setRotationPoint(0F, 24F, -5F);
        barrel2.setTextureSize(128, 32);
        barrel2.mirror = true;
        setRotation(barrel2, -0.1047198F, 3.141593F, 0F);
        barrel3 = new ModelRenderer(this, 0, 0);
        barrel3.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel3.setRotationPoint(5F, 24F, 0F);
        barrel3.setTextureSize(128, 32);
        barrel3.mirror = true;
        setRotation(barrel3, -0.1047198F, 1.570796F, 0F);
        barrel4 = new ModelRenderer(this, 0, 0);
        barrel4.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel4.setRotationPoint(-5F, 24F, 0F);
        barrel4.setTextureSize(128, 32);
        barrel4.mirror = true;
        setRotation(barrel4, -0.1047198F, -1.570796F, 0F);
        barrel5 = new ModelRenderer(this, 0, 0);
        barrel5.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel5.setRotationPoint(-3F, 24F, 3F);
        barrel5.setTextureSize(128, 32);
        barrel5.mirror = true;
        setRotation(barrel5, -0.1570796F, -0.7853982F, 0F);
        barrel6 = new ModelRenderer(this, 0, 0);
        barrel6.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel6.setRotationPoint(3F, 24F, 3F);
        barrel6.setTextureSize(128, 32);
        barrel6.mirror = true;
        setRotation(barrel6, -0.1570796F, 0.7853982F, 0F);
        barrel7 = new ModelRenderer(this, 0, 0);
        barrel7.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel7.setRotationPoint(3F, 24F, -3F);
        barrel7.setTextureSize(128, 32);
        barrel7.mirror = true;
        setRotation(barrel7, -0.1570796F, 2.356194F, 0F);
        barrel8 = new ModelRenderer(this, 0, 0);
        barrel8.addBox(-2.5F, -12F, 0F, 5, 12, 1);
        barrel8.setRotationPoint(-3F, 24F, -3F);
        barrel8.setTextureSize(128, 32);
        barrel8.mirror = true;
        setRotation(barrel8, -0.1570796F, -2.356194F, 0F);
        body = new ModelRenderer(this, 58, 0);
        body.addBox(-3F, -16F, -3F, 6, 15, 6);
        body.setRotationPoint(0F, 24F, 0F);
        body.setTextureSize(128, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        head = new ModelRenderer(this, 25, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 8F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        handL = new ModelRenderer(this, 27, 19);
        handL.addBox(-1F, -1F, -8F, 2, 2, 8);
        handL.setRotationPoint(4F, 10F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0.2617994F, -0.1745329F, 0F);
        handR = new ModelRenderer(this, 27, 19);
        handR.addBox(-1F, -1F, -8F, 2, 2, 8);
        handR.setRotationPoint(-4F, 10F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0.2617994F, 0.1745329F, 0F);
        hairL = new ModelRenderer(this, 13, 0);
        hairL.addBox(0F, 0F, -1F, 2, 7, 3);
        hairL.setRotationPoint(4F, 1F, -1F);
        hairL.setTextureSize(128, 32);
        hairL.mirror = true;
        setRotation(hairL, 0F, 0F, -0.3490659F);
        hairR = new ModelRenderer(this, 13, 0);
        hairR.addBox(0F, 0F, -2F, 2, 7, 3);
        hairR.setRotationPoint(-4F, 1F, -1F);
        hairR.setTextureSize(128, 32);
        hairR.mirror = true;
        setRotation(hairR, 0F, -3.141593F, 0.3490659F);
        barrelB = new ModelRenderer(this, 83, 0);
        barrelB.addBox(-6F, 0F, -6F, 12, 7, 12);
        barrelB.setRotationPoint(0F, 16.5F, 0F);
        barrelB.setTextureSize(128, 32);
        barrelB.mirror = true;
        setRotation(barrelB, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        barrel1.render(f5);
        barrel2.render(f5);
        barrel3.render(f5);
        barrel4.render(f5);
        barrel5.render(f5);
        barrel6.render(f5);
        barrel7.render(f5);
        barrel8.render(f5);
        body.render(f5);
        head.render(f5);
        handL.render(f5);
        handR.render(f5);
        hairL.render(f5);
        hairR.render(f5);
        barrelB.render(f5);
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

        // 左手右手的运动
        this.handL.rotateAngleX = MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.26f;
        this.handR.rotateAngleX = MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.26f;

        // 头发的周期运动
        this.hairL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.3f;
        this.hairR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.3f;
    }
}
