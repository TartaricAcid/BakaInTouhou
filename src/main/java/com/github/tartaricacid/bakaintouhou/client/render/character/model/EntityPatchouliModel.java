package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityPatchouliModel extends EntityTouhouCharacterModel {

    //fields
    private ModelRenderer head;
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer hat1;
    private ModelRenderer hat2;
    private ModelRenderer headdress1;
    private ModelRenderer headdress2;
    private ModelRenderer headdress3;
    private ModelRenderer hairB;
    private ModelRenderer hairR;
    private ModelRenderer hairL;
    private ModelRenderer footR;
    private ModelRenderer footL;
    private ModelRenderer handR;
    private ModelRenderer handL;

    public EntityPatchouliModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, 0F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 33, 0);
        body1.addBox(-3F, 0F, -3F, 6, 4, 6);
        body1.setRotationPoint(0F, 8F, 0F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 58, 0);
        body2.addBox(-4F, 0F, -4F, 8, 5, 8);
        body2.setRotationPoint(0F, 12F, 0F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 17);
        body3.addBox(-5F, 0F, -5F, 10, 5, 10);
        body3.setRotationPoint(0F, 17F, 0F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        hat1 = new ModelRenderer(this, 41, 17);
        hat1.addBox(-5F, 0F, -5F, 10, 2, 10);
        hat1.setRotationPoint(0F, 0.5F, 0F);
        hat1.setTextureSize(128, 32);
        hat1.mirror = true;
        setRotation(hat1, 0F, 0F, 0F);
        hat2 = new ModelRenderer(this, 82, 17);
        hat2.addBox(-4F, 0F, -4F, 8, 3, 8);
        hat2.setRotationPoint(0F, -2.5F, 0F);
        hat2.setTextureSize(128, 32);
        hat2.mirror = true;
        setRotation(hat2, 0F, 0F, 0F);
        headdress1 = new ModelRenderer(this, 91, 0);
        headdress1.addBox(-1F, -1F, -1F, 1, 2, 2);
        headdress1.setRotationPoint(-4F, -1F, -1F);
        headdress1.setTextureSize(128, 32);
        headdress1.mirror = true;
        setRotation(headdress1, 0F, 0F, 0F);
        headdress2 = new ModelRenderer(this, 98, 0);
        headdress2.addBox(-6F, -2F, 0F, 6, 4, 0);
        headdress2.setRotationPoint(-5F, -1F, -0.5F);
        headdress2.setTextureSize(128, 32);
        headdress2.mirror = true;
        setRotation(headdress2, 0F, 0.5235988F, 0.3490659F);
        headdress3 = new ModelRenderer(this, 91, 5);
        headdress3.addBox(-2F, -2F, 0F, 4, 4, 0);
        headdress3.setRotationPoint(3F, -2F, -5F);
        headdress3.setTextureSize(128, 32);
        headdress3.mirror = true;
        setRotation(headdress3, 0F, -0.6108652F, 0.0872665F);
        hairB = new ModelRenderer(this, 111, 0);
        hairB.addBox(-4F, 0F, 0F, 8, 10, 0);
        hairB.setRotationPoint(0F, 7F, 4F);
        hairB.setTextureSize(128, 32);
        hairB.mirror = true;
        setRotation(hairB, 0.6108652F, 0F, 0F);
        hairR = new ModelRenderer(this, 100, 5);
        hairR.addBox(0F, 0F, 0F, 0, 4, 1);
        hairR.setRotationPoint(-4F, 8F, -3.5F);
        hairR.setTextureSize(128, 32);
        hairR.mirror = true;
        setRotation(hairR, 0F, 0F, 0.3490659F);
        hairL = new ModelRenderer(this, 100, 5);
        hairL.addBox(0F, 0F, 0F, 0, 4, 1);
        hairL.setRotationPoint(4F, 8F, -3.5F);
        hairL.setTextureSize(128, 32);
        hairL.mirror = true;
        setRotation(hairL, 0F, 0F, -0.3490659F);
        footR = new ModelRenderer(this, 91, 10);
        footR.addBox(-1F, 0F, -1F, 2, 2, 2);
        footR.setRotationPoint(-2F, 22F, 0F);
        footR.setTextureSize(128, 32);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        footL = new ModelRenderer(this, 91, 10);
        footL.addBox(-1F, 0F, -1F, 2, 2, 2);
        footL.setRotationPoint(2F, 22F, 0F);
        footL.setTextureSize(128, 32);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 115, 17);
        handR.addBox(-1F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-4F, 9F, 0F);
        handR.setTextureSize(128, 32);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.5235988F);
        handL = new ModelRenderer(this, 115, 17);
        handL.addBox(-1F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(4F, 9F, 0F);
        handL.setTextureSize(128, 32);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.5235988F);

        head.addChild(hat1);
        head.addChild(hat2);
        head.addChild(headdress1);
        head.addChild(headdress2);
        head.addChild(headdress3);
        head.addChild(hairB);
        head.addChild(hairR);
        head.addChild(hairL);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        hairL.render(f5);
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
        this.hairB.rotateAngleX = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.5f;
        this.hairL.rotateAngleZ = MathHelper.sin(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.hairR.rotateAngleZ = -MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.2f;

        // 头饰
        this.headdress2.rotateAngleY = MathHelper.sin(ageInTicks * 0.2f) * 0.05f + 0.5f;
    }
}
