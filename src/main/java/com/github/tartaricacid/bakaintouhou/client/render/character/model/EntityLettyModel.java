package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityLettyModel extends EntityTouhouCharacterModel {
    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer footR;
    private ModelRenderer footL;
    private ModelRenderer handR;
    private ModelRenderer handL;
    private ModelRenderer hat;
    private ModelRenderer headdress;
    private ModelRenderer scarf1;
    private ModelRenderer scarf2;

    public EntityLettyModel() {
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
        footR = new ModelRenderer(this, 33, 12);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 33, 12);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 91, 0);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.4363323F);
        handL = new ModelRenderer(this, 91, 0);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.4363323F);
        hat = new ModelRenderer(this, 41, 18);
        hat.addBox(-3.5F, 0F, -3.5F, 7, 2, 7);
        hat.setRotationPoint(0F, -2F, 0F);
        hat.setTextureSize(128, 32);
        hat.mirror = true;
        setRotation(hat, 0F, 0F, 0F);
        headdress = new ModelRenderer(this, 42, 12);
        headdress.addBox(-4F, -5F, 0F, 8, 5, 0);
        headdress.setRotationPoint(0F, 0F, -3.6F);
        headdress.setTextureSize(128, 32);
        headdress.mirror = true;
        setRotation(headdress, 0F, 0F, 0F);
        scarf1 = new ModelRenderer(this, 70, 13);
        scarf1.addBox(-3.5F, 0F, -3.5F, 7, 2, 7);
        scarf1.setRotationPoint(0F, 8.1F, 0F);
        scarf1.setTextureSize(128, 32);
        scarf1.mirror = true;
        setRotation(scarf1, 0F, 0F, 0F);
        scarf2 = new ModelRenderer(this, 99, 13);
        scarf2.addBox(-1F, 0F, 0F, 2, 10, 1);
        scarf2.setRotationPoint(-2F, 8.7F, 2F);
        scarf2.setTextureSize(128, 32);
        scarf2.mirror = true;
        setRotation(scarf2, 0.5235988F, -0.6981317F, 0.0872665F);

        head.addChild(hat);
        head.addChild(headdress);
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
        scarf1.render(f5);
        scarf2.render(f5);
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
        this.headdress.rotateAngleX = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.1f;

        // 围巾的周期运动
        this.scarf2.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.5f;
    }
}
