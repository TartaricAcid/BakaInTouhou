package com.github.tartaricacid.bakaintouhou.client.render.danmaku.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityButterflyDanmakuModel extends ModelBase {
    private ModelRenderer wingL;
    private ModelRenderer wingR;

    public EntityButterflyDanmakuModel() {
        textureWidth = 64;
        textureHeight = 32;

        wingL = new ModelRenderer(this, -32, 0);
        wingL.addBox(0F, 0F, -16F, 16, 0, 32);
        wingL.setRotationPoint(0F, 0F, 0F);
        wingL.setTextureSize(64, 32);
        wingL.mirror = true;
        setRotation(wingL, 0F, 0F, -0.2617994F);
        wingR = new ModelRenderer(this, 0, 0);
        wingR.addBox(-16F, 0F, -16F, 16, 0, 32);
        wingR.setRotationPoint(0F, 0F, 0F);
        wingR.setTextureSize(64, 32);
        wingR.mirror = true;
        setRotation(wingR, 0F, 0F, 0.2617994F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        wingL.render(f5);
        wingR.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        // 翅膀的周期运动
        this.wingL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.3f) * 0.4f - 0.5f;
        this.wingR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.3f) * 0.4f + 0.5f;
        //System.out.println(ageInTicks);
        //System.out.println(wingR.rotateAngleZ);
    }
}
