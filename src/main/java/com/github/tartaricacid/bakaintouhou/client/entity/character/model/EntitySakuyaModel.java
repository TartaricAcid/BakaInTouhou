package com.github.tartaricacid.bakaintouhou.client.entity.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntitySakuyaModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer headdress;
    ModelRenderer hairR;
    ModelRenderer hairL;
    ModelRenderer handR;
    ModelRenderer handL;

    public EntitySakuyaModel() {
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
        footR = new ModelRenderer(this, 0, 17);
        footR.addBox(-1F, 0F, -1F, 2, 4, 2);
        footR.setRotationPoint(-2F, 20F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 0, 17);
        footL.addBox(-1F, 0F, -1F, 2, 4, 2);
        footL.setRotationPoint(2F, 20F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        headdress = new ModelRenderer(this, 9, 17);
        headdress.addBox(-4F, 0F, 0F, 8, 2, 0);
        headdress.setRotationPoint(0F, -2F, -2F);
        headdress.setTextureSize(128, 32);
        headdress.mirror = true;
        setRotation(headdress, 0F, 0F, 0F);
        hairR = new ModelRenderer(this, 26, 17);
        hairR.addBox(0F, 0F, -1F, 0, 3, 1);
        hairR.setRotationPoint(-4F, 8F, -2.5F);
        hairR.setTextureSize(128, 32);
        hairR.mirror = true;
        setRotation(hairR, 0F, 0F, 0.3490659F);
        hairL = new ModelRenderer(this, 26, 17);
        hairL.addBox(0F, 0F, -1F, 0, 3, 1);
        hairL.setRotationPoint(4F, 8F, -2.5F);
        hairL.setTextureSize(128, 32);
        hairL.mirror = true;
        setRotation(hairL, 0F, 0F, -0.3490659F);
        handR = new ModelRenderer(this, 29, 17);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.6108652F);
        handL = new ModelRenderer(this, 29, 17);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.6108652F);

        head.addChild(hairR);
        head.addChild(hairL);
        head.addChild(headdress);
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
        this.hairL.rotateAngleZ = MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.hairR.rotateAngleZ = -MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.2f;

        // 头饰
        this.headdress.rotateAngleX = -MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0f;
    }
}

