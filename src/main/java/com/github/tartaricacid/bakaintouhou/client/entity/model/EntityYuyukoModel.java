package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityYuyukoModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer band;
    ModelRenderer bow1;
    ModelRenderer bow2;
    ModelRenderer hat;
    ModelRenderer headdress;
    ModelRenderer soul1;
    ModelRenderer soul2;
    ModelRenderer soul3;
    ModelRenderer soul4;

    public EntityYuyukoModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 7, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 17);
        body3.addBox(-4F, 0F, -4F, 8, 7, 8);
        body3.setRotationPoint(0F, 15F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 33, 14);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 33, 14);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 33, 19);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 33, 19);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        band = new ModelRenderer(this, 58, 0);
        band.addBox(-3.5F, 0F, -3.5F, 7, 1, 7);
        band.setRotationPoint(0F, 14F, 0F);
        band.setTextureSize(128, 32);
        band.mirror = true;
        setRotation(band, 0F, 0F, 0F);
        bow1 = new ModelRenderer(this, 42, 14);
        bow1.addBox(-4F, -1F, 0F, 4, 2, 1);
        bow1.setRotationPoint(3.5F, 14F, -3F);
        bow1.setTextureSize(128, 32);
        bow1.mirror = true;
        setRotation(bow1, -0.3839724F, -1.390067F, -0.4046272F);
        bow2 = new ModelRenderer(this, 42, 18);
        bow2.addBox(-4F, -1F, 0F, 4, 2, 1);
        bow2.setRotationPoint(3F, 14.5F, -3F);
        bow2.setTextureSize(128, 32);
        bow2.mirror = true;
        setRotation(bow2, -0.3839724F, 0.6919353F, -3.141593F);
        hat = new ModelRenderer(this, 58, 9);
        hat.addBox(-3.5F, -2F, -3.5F, 7, 2, 7);
        hat.setRotationPoint(0F, 0F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        headdress = new ModelRenderer(this, 42, 22);
        headdress.addBox(-3.5F, -4F, -1F, 7, 4, 0);
        headdress.setRotationPoint(0F, 0F, -2.6F);
        headdress.setTextureSize(128, 32);
        headdress.mirror = true;
        setRotation(headdress, 0F, 0F, 0F);
        soul1 = new ModelRenderer(this, 58, 19);
        soul1.addBox(-1F, 0F, -1F, 2, 3, 2);
        soul1.setRotationPoint(-8F, 9F, 2F);
        soul1.setTextureSize(128, 32);
        soul1.mirror = true;
        setRotation(soul1, 0F, 0F, 0F);
        soul2 = new ModelRenderer(this, 67, 19);
        soul2.addBox(0.5F, -5F, -0.5F, 1, 5, 1);
        soul2.setRotationPoint(-9F, 9F, 2F);
        soul2.setTextureSize(128, 32);
        soul2.mirror = true;
        setRotation(soul2, 0F, 0F, 0.2379431F);
        soul3 = new ModelRenderer(this, 58, 26);
        soul3.addBox(-1F, 0F, -1F, 2, 3, 2);
        soul3.setRotationPoint(8F, 10F, 2F);
        soul3.setTextureSize(128, 32);
        soul3.mirror = true;
        setRotation(soul3, 0F, 0F, 0F);
        soul4 = new ModelRenderer(this, 67, 26);
        soul4.addBox(0.5F, -5F, -0.5F, 1, 5, 1);
        soul4.setRotationPoint(7F, 11F, 2F);
        soul4.setTextureSize(128, 32);
        soul4.mirror = true;
        setRotation(soul4, 0F, 0F, -0.2268928F);

        head.addChild(hat);
        head.addChild(headdress);
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
        band.render(f5);
        bow1.render(f5);
        bow2.render(f5);
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
        this.bow1.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 1.4f;
        this.bow2.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.7f;
    }
}
