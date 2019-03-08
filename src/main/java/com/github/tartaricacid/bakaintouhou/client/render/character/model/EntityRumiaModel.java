package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityRumiaModel extends EntityTouhouCharacterModel {

    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer footR;
    private ModelRenderer footL;
    private ModelRenderer headdressM;
    private ModelRenderer headdressT;
    private ModelRenderer headdressB;
    private ModelRenderer handR;
    private ModelRenderer handL;

    public EntityRumiaModel() {
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
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 13F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 17);
        body3.addBox(-5F, 0F, -5F, 10, 5, 10);
        body3.setRotationPoint(0F, 17F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 41, 17);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 41, 17);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        headdressM = new ModelRenderer(this, 51, 17);
        headdressM.addBox(0F, 0F, 0F, 1, 1, 2);
        headdressM.setRotationPoint(3.5F, -0.5F, -2F);
        headdressM.setTextureSize(128, 32);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, 0F);
        headdressT = new ModelRenderer(this, 59, 17);
        headdressT.addBox(-3F, -1F, -1F, 3, 2, 1);
        headdressT.setRotationPoint(5F, 0.5F, -1F);
        headdressT.setTextureSize(128, 32);
        headdressT.mirror = true;
        setRotation(headdressT, 0F, 2.094395F, 0.5235988F);
        headdressB = new ModelRenderer(this, 59, 17);
        headdressB.addBox(-3F, -1F, 0F, 3, 2, 1);
        headdressB.setRotationPoint(4F, 0F, -1F);
        headdressB.setTextureSize(128, 32);
        headdressB.mirror = true;
        setRotation(headdressB, 0.1784573F, 2.617994F, -0.3490659F);
        handR = new ModelRenderer(this, 41, 27);
        handR.addBox(-8F, -1F, -1F, 8, 2, 2);
        handR.setRotationPoint(-3F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, -0.1745329F);
        handL = new ModelRenderer(this, 41, 22);
        handL.addBox(0F, -1F, -1F, 8, 2, 2);
        handL.setRotationPoint(3F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, 0.1745329F);

        head.addChild(headdressB);
        head.addChild(headdressT);
        head.addChild(headdressM);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
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
        this.handL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.05f) * 0.05f + 0.1f;
        this.handR.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.05f) * 0.05f - 0.1f;

        // 头饰的周期运动
        this.headdressB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 2.6f;
        this.headdressT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 2.0f;
    }
}
