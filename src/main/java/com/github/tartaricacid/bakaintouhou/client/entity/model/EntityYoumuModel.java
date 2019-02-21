package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityYoumuModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer headdress1;
    ModelRenderer headdress2;
    ModelRenderer slash1;
    ModelRenderer slash2;
    ModelRenderer soul1;
    ModelRenderer soul2;
    ModelRenderer soul3;
    ModelRenderer soul4;

    public EntityYoumuModel() {
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
        body3 = new ModelRenderer(this, 58, 0);
        body3.addBox(-4F, 0F, -4F, 8, 8, 8);
        body3.setRotationPoint(0F, 13F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 9, 17);
        footR.addBox(-1F, 0F, -1F, 2, 3, 2);
        footR.setRotationPoint(-2F, 21F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 9, 17);
        footL.addBox(-1F, 0F, -1F, 2, 3, 2);
        footL.setRotationPoint(2F, 21F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 0, 17);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 0, 17);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        headdress1 = new ModelRenderer(this, 0, 28);
        headdress1.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdress1.setRotationPoint(-3F, 1F, -1F);
        headdress1.setTextureSize(128, 32);
        headdress1.mirror = true;
        setRotation(headdress1, 0F, 0.2617994F, 0.7853982F);
        headdress2 = new ModelRenderer(this, 0, 28);
        headdress2.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdress2.setRotationPoint(-3F, 1F, -1F);
        headdress2.setTextureSize(128, 32);
        headdress2.mirror = true;
        setRotation(headdress2, 0F, -0.4363323F, 0.4363323F);
        slash1 = new ModelRenderer(this, 91, 0);
        slash1.addBox(0F, -14F, 0F, 1, 26, 1);
        slash1.setRotationPoint(0F, 10F, 4F);
        slash1.setTextureSize(128, 32);
        slash1.mirror = true;
        setRotation(slash1, 0F, 0F, 0.6632251F);
        slash2 = new ModelRenderer(this, 18, 17);
        slash2.addBox(0F, -6F, 0F, 1, 12, 1);
        slash2.setRotationPoint(0F, 11F, 3.5F);
        slash2.setTextureSize(128, 32);
        slash2.mirror = true;
        setRotation(slash2, 0F, 0F, 1.396263F);
        soul1 = new ModelRenderer(this, 23, 17);
        soul1.addBox(-4F, -3F, -2F, 8, 6, 6);
        soul1.setRotationPoint(-7F, 10F, 7F);
        soul1.setTextureSize(128, 32);
        soul1.mirror = true;
        setRotation(soul1, 0F, 0F, 0.6108652F);
        soul2 = new ModelRenderer(this, 52, 21);
        soul2.addBox(0F, -2F, -1F, 8, 4, 4);
        soul2.setRotationPoint(-5F, 12F, 7F);
        soul2.setTextureSize(128, 32);
        soul2.mirror = true;
        setRotation(soul2, 0F, 0F, 0.1745329F);
        soul3 = new ModelRenderer(this, 33, 12);
        soul3.addBox(0F, -1F, -1F, 10, 2, 2);
        soul3.setRotationPoint(2F, 14F, 8F);
        soul3.setTextureSize(128, 32);
        soul3.mirror = true;
        setRotation(soul3, 0F, 0F, -0.4363323F);
        soul4 = new ModelRenderer(this, 52, 18);
        soul4.addBox(0F, 0F, 0F, 5, 1, 1);
        soul4.setRotationPoint(10.5F, 9.2F, 7.5F);
        soul4.setTextureSize(128, 32);
        soul4.mirror = true;
        setRotation(soul4, 0F, 0F, 0.1745329F);

        head.addChild(headdress1);
        head.addChild(headdress2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body3.render(f5);
        footR.render(f5);
        footL.render(f5);
        handR.render(f5);
        handL.render(f5);
        slash1.render(f5);
        slash2.render(f5);
        soul1.render(f5);
        soul2.render(f5);
        soul3.render(f5);
        soul4.render(f5);
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
        this.handR.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.3f;
        this.handL.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.3f;
        this.handL.rotateAngleX = MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.handR.rotateAngleX = -MathHelper.cos(limbSwing * 1.7F) * 1F * limbSwingAmount;
        this.footL.rotateAngleX = MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.footR.rotateAngleX = -MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;

        // 头饰的周期运动
        this.headdress1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.8f;
        this.headdress2.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.4f;
    }
}
