package com.github.tartaricacid.bakaintouhou.client.render.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ReimuHeaddressModel extends ModelBiped {
    //fields
    private ModelRenderer headdressM;
    private ModelRenderer hair;
    private ModelRenderer headdressLT;
    private ModelRenderer headdressRT;
    private ModelRenderer headdressLB;
    private ModelRenderer headdressRB;

    public ReimuHeaddressModel() {
        textureWidth = 128;
        textureHeight = 32;

        bipedHead = new ModelRenderer(this, 0, 0);
        bipedHeadwear = new ModelRenderer(this, 0, 0);

        headdressM = new ModelRenderer(this, 32, 16);
        headdressM.addBox(-1F, -1F, 0F, 2, 2, 3);
        headdressM.setRotationPoint(0F, -8F, 4F);
        headdressM.setTextureSize(128, 32);
        headdressM.mirror = true;
        setRotation(headdressM, 0F, 0F, 0F);
        hair = new ModelRenderer(this, 52, 17);
        hair.addBox(0F, 0F, 0F, 2, 9, 1);
        hair.setRotationPoint(-1F, -8F, 5F);
        hair.setTextureSize(128, 32);
        hair.mirror = true;
        setRotation(hair, 0.1745329F, 0F, -0.2617994F);
        headdressLT = new ModelRenderer(this, 32, 21);
        headdressLT.addBox(0F, -2F, 0F, 8, 4, 1);
        headdressLT.setRotationPoint(1F, -8F, 4F);
        headdressLT.setTextureSize(128, 32);
        headdressLT.mirror = true;
        setRotation(headdressLT, 0F, 0F, -0.1745329F);
        headdressRT = new ModelRenderer(this, 32, 26);
        headdressRT.addBox(-9F, -2F, 0F, 8, 4, 1);
        headdressRT.setRotationPoint(0F, -8F, 4F);
        headdressRT.setTextureSize(128, 32);
        headdressRT.mirror = true;
        setRotation(headdressRT, 0F, 0F, 0.1745329F);
        headdressLB = new ModelRenderer(this, 42, 11);
        headdressLB.addBox(-2F, 0F, 0F, 4, 9, 1);
        headdressLB.setRotationPoint(1F, -9F, 4F);
        headdressLB.setTextureSize(128, 32);
        headdressLB.mirror = true;
        setRotation(headdressLB, 0F, 0F, -0.6981317F);
        headdressRB = new ModelRenderer(this, 42, 11);
        headdressRB.addBox(-2F, 0F, 0F, 4, 9, 1);
        headdressRB.setRotationPoint(-1F, -9F, 4F);
        headdressRB.setTextureSize(128, 32);
        headdressRB.mirror = true;
        setRotation(headdressRB, 0F, 0F, 0.6981317F);

        this.bipedHead.addChild(hair);
        this.bipedHead.addChild(headdressM);
        this.bipedHead.addChild(headdressLB);
        this.bipedHead.addChild(headdressLT);
        this.bipedHead.addChild(headdressRB);
        this.bipedHead.addChild(headdressRT);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        // 头饰的周期运动
        this.headdressLB.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressLT.rotateAngleY = MathHelper.cos(ageInTicks * 0.2f) * 0.05f - 0.2f;
        this.headdressRB.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
        this.headdressRT.rotateAngleY = -MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.2f;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
