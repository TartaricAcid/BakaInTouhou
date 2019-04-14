package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntitySunflowerFairyModel extends ModelBase {

    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer footR;
    ModelRenderer footL;
    ModelRenderer handL;
    ModelRenderer handR;
    ModelRenderer hairL;
    ModelRenderer hairR;
    ModelRenderer wingL;
    ModelRenderer wingR;
    ModelRenderer sunflower1;
    ModelRenderer sunflower2;

    public EntitySunflowerFairyModel() {
        textureWidth = 128;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 5, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 64);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 13F, 0F);
        body2.setTextureSize(128, 64);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 17);
        body3.addBox(-5F, 0F, -5F, 10, 5, 10);
        body3.setRotationPoint(0F, 17F, 0F);
        body3.setTextureSize(128, 64);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 33, 12);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 64);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 33, 12);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 64);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handL = new ModelRenderer(this, 91, 0);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 64);
        handL.mirror = true;
        setRotation(handL, -0.7733151F, 0.3866576F, -0.3471036F);
        handR = new ModelRenderer(this, 91, 0);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 64);
        handR.mirror = true;
        setRotation(handR, -1.4164004F, -0.13843F, 0.017848F);
        hairL = new ModelRenderer(this, 41, 17);
        hairL.addBox(-4F, 1F, -1F, 2, 6, 2);
        hairL.setRotationPoint(0F, 0F, 0F);
        hairL.setTextureSize(128, 64);
        hairL.mirror = true;
        setRotation(hairL, 0F, 0F, 0.5235988F);
        hairR = new ModelRenderer(this, 41, 17);
        hairR.addBox(2F, 1F, -1F, 2, 6, 2);
        hairR.setRotationPoint(0F, 0F, 0F);
        hairR.setTextureSize(128, 64);
        hairR.mirror = true;
        setRotation(hairR, 0F, 0F, -0.5235988F);
        wingL = new ModelRenderer(this, 50, 13);
        wingL.addBox(0F, -16F, 0F, 16, 32, 0);
        wingL.setRotationPoint(1F, 11F, 4F);
        wingL.setTextureSize(128, 64);
        wingL.mirror = true;
        setRotation(wingL, 0F, -0.2617994F, 0F);
        wingR = new ModelRenderer(this, 83, 13);
        wingR.addBox(-16F, -16F, 0F, 16, 32, 0);
        wingR.setRotationPoint(-1F, 11F, 4F);
        wingR.setTextureSize(128, 64);
        wingR.mirror = true;
        setRotation(wingR, 0F, 0.2617994F, 0F);
        sunflower1 = new ModelRenderer(this, 0, 33);
        sunflower1.addBox(0F, -6F, 0F, 1, 18, 1);
        sunflower1.setRotationPoint(-1F, 11F, -7F);
        sunflower1.setTextureSize(128, 64);
        sunflower1.mirror = true;
        setRotation(sunflower1, 0.2379431F, 0F, -0.7853982F);
        sunflower2 = new ModelRenderer(this, 5, 33);
        sunflower2.addBox(-4F, -4F, 0F, 8, 8, 1);
        sunflower2.setRotationPoint(-6F, 5F, -9F);
        sunflower2.setTextureSize(128, 64);
        sunflower2.mirror = true;
        setRotation(sunflower2, 0F, 0F, 0.7853982F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        GlStateManager.enableBlend();
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        footR.render(f5);
        footL.render(f5);
        handL.render(f5);
        handR.render(f5);
        hairL.render(f5);
        hairR.render(f5);
        wingL.render(f5);
        wingR.render(f5);
        sunflower1.render(f5);
        sunflower2.render(f5);
        GlStateManager.disableBlend();
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
        this.head.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;
        this.hairL.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;
        this.hairR.rotateAngleY = netHeadYaw / 45f / (float) Math.PI;

        // 左脚右脚的运动
        this.footL.rotateAngleX = MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;
        this.footR.rotateAngleX = -MathHelper.cos(limbSwing * 2F) * 1.2F * limbSwingAmount;

        // 翅膀的周期运动
        this.wingL.rotateAngleY = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.8f;
        this.wingR.rotateAngleY = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.8f;
    }
}
