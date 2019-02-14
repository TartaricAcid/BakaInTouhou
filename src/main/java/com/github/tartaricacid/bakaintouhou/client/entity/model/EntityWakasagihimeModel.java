package com.github.tartaricacid.bakaintouhou.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityWakasagihimeModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer fishtail1;
    ModelRenderer fishtail2;
    ModelRenderer fishtail3;
    ModelRenderer fishtail4;
    ModelRenderer fishtail5;
    ModelRenderer fishtail6;
    ModelRenderer fishtail7;
    ModelRenderer fishtail8;
    ModelRenderer fishtail9;
    ModelRenderer fishtail10;
    ModelRenderer fishtail11;
    ModelRenderer headdressL;
    ModelRenderer headdressR;

    public EntityWakasagihimeModel() {
        textureWidth = 64;
        textureHeight = 128;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 6F, 0F);
        head.setTextureSize(64, 128);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        handR = new ModelRenderer(this, 0, 24);
        handR.addBox(-2F, 0F, -1F, 2, 8, 2);
        handR.setRotationPoint(-3F, 7F, 0F);
        handR.setTextureSize(64, 128);
        handR.mirror = true;
        setRotation(handR, 0F, 0F, 0.3490659F);
        handL = new ModelRenderer(this, 0, 24);
        handL.addBox(0F, 0F, -1F, 2, 8, 2);
        handL.setRotationPoint(3F, 7F, 0F);
        handL.setTextureSize(64, 128);
        handL.mirror = true;
        setRotation(handL, 0F, 0F, -0.3490659F);
        body1 = new ModelRenderer(this, 0, 85);
        body1.addBox(-3F, 0F, -3F, 6, 11, 6);
        body1.setRotationPoint(0F, 6F, 0F);
        body1.setTextureSize(64, 128);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 0, 102);
        body2.addBox(-4F, 0F, -4F, 8, 4, 8);
        body2.setRotationPoint(0F, 15F, 0F);
        body2.setTextureSize(64, 128);
        body2.mirror = true;
        setRotation(body2, 0.3926991F, 0F, 0F);
        body3 = new ModelRenderer(this, 0, 114);
        body3.addBox(-5F, 0F, -5F, 10, 4, 10);
        body3.setRotationPoint(0F, 17F, 1F);
        body3.setTextureSize(64, 128);
        body3.mirror = true;
        setRotation(body3, 0.7853982F, 0F, 0F);
        fishtail1 = new ModelRenderer(this, 10, 20);
        fishtail1.addBox(-4F, 0F, -2F, 4, 10, 4);
        fishtail1.setRotationPoint(4F, 19F, 3F);
        fishtail1.setTextureSize(64, 128);
        fishtail1.mirror = true;
        setRotation(fishtail1, 1.178097F, -0.1396263F, 0.0523599F);
        fishtail2 = new ModelRenderer(this, 10, 20);
        fishtail2.addBox(0F, 0F, -2F, 4, 10, 4);
        fishtail2.setRotationPoint(-4F, 19F, 3F);
        fishtail2.setTextureSize(64, 128);
        fishtail2.mirror = true;
        setRotation(fishtail2, 1.178097F, 0.1396263F, -0.0523599F);
        fishtail3 = new ModelRenderer(this, 0, 34);
        fishtail3.addBox(-2F, 0F, 0F, 2, 2, 17);
        fishtail3.setRotationPoint(-0.5F, 23F, 11F);
        fishtail3.setTextureSize(64, 128);
        fishtail3.mirror = true;
        setRotation(fishtail3, 0F, 0.0872665F, 0F);
        fishtail4 = new ModelRenderer(this, 0, 34);
        fishtail4.addBox(0F, 0F, 0F, 2, 2, 17);
        fishtail4.setRotationPoint(0.5F, 23F, 11F);
        fishtail4.setTextureSize(64, 128);
        fishtail4.mirror = true;
        setRotation(fishtail4, 0F, -0.0872665F, 0F);
        fishtail5 = new ModelRenderer(this, 0, 34);
        fishtail5.addBox(0F, -2F, 0F, 2, 2, 17);
        fishtail5.setRotationPoint(0.5F, 23F, 11F);
        fishtail5.setTextureSize(64, 128);
        fishtail5.mirror = true;
        setRotation(fishtail5, -0.1134464F, -0.0872665F, 0F);
        fishtail6 = new ModelRenderer(this, 0, 34);
        fishtail6.addBox(-2F, -2F, 0F, 2, 2, 17);
        fishtail6.setRotationPoint(-0.5F, 23F, 11F);
        fishtail6.setTextureSize(64, 128);
        fishtail6.mirror = true;
        setRotation(fishtail6, -0.1134464F, 0.0872665F, 0F);
        fishtail7 = new ModelRenderer(this, 0, 74);
        fishtail7.addBox(-1F, 0F, 0F, 2, 0, 5);
        fishtail7.setRotationPoint(0F, 21F, 12F);
        fishtail7.setTextureSize(64, 128);
        fishtail7.mirror = true;
        setRotation(fishtail7, -0.122173F, 0F, 0F);
        fishtail8 = new ModelRenderer(this, 0, 74);
        fishtail8.addBox(-1F, 0F, 0F, 2, 0, 6);
        fishtail8.setRotationPoint(0F, 25F, 11F);
        fishtail8.setTextureSize(64, 128);
        fishtail8.mirror = true;
        setRotation(fishtail8, 0F, 0F, 0F);
        fishtail9 = new ModelRenderer(this, 0, 64);
        fishtail9.addBox(0F, 0F, 0F, 4, 1, 10);
        fishtail9.setRotationPoint(0F, 24F, 28F);
        fishtail9.setTextureSize(64, 128);
        fishtail9.mirror = true;
        setRotation(fishtail9, 0.1745329F, -0.7853982F, -0.1745329F);
        fishtail10 = new ModelRenderer(this, 0, 53);
        fishtail10.addBox(-4F, 0F, 0F, 4, 1, 10);
        fishtail10.setRotationPoint(0F, 24F, 28F);
        fishtail10.setTextureSize(64, 128);
        fishtail10.mirror = true;
        setRotation(fishtail10, 0.1745329F, 0.7853982F, 0.1745329F);
        fishtail11 = new ModelRenderer(this, 0, 79);
        fishtail11.addBox(-1F, -1F, 0F, 2, 2, 4);
        fishtail11.setRotationPoint(0F, 24F, 28F);
        fishtail11.setTextureSize(64, 128);
        fishtail11.mirror = true;
        setRotation(fishtail11, 0F, 0F, 0F);
        headdressL = new ModelRenderer(this, 0, 16);
        headdressL.addBox(0F, -4F, 0F, 2, 4, 1);
        headdressL.setRotationPoint(3F, 3F, -1F);
        headdressL.setTextureSize(64, 128);
        headdressL.mirror = true;
        setRotation(headdressL, 0F, 0F, 0.5235988F);
        headdressR = new ModelRenderer(this, 0, 16);
        headdressR.addBox(0F, 0F, 0F, 2, 4, 1);
        headdressR.setRotationPoint(-3F, 3F, -1F);
        headdressR.setTextureSize(64, 128);
        headdressR.mirror = true;
        setRotation(headdressR, 0F, 0F, 2.617994F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        handR.render(f5);
        handL.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        fishtail1.render(f5);
        fishtail2.render(f5);
        fishtail3.render(f5);
        fishtail4.render(f5);
        fishtail5.render(f5);
        fishtail6.render(f5);
        fishtail7.render(f5);
        fishtail8.render(f5);
        fishtail9.render(f5);
        fishtail10.render(f5);
        fishtail11.render(f5);
        headdressL.render(f5);
        headdressR.render(f5);
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

        // 头饰的周期运动
        this.headdressL.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 0.5f;
        this.headdressR.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2f) * 0.05f + 2.6f;
    }
}
