package com.github.tartaricacid.bakaintouhou.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityBakaModel extends ModelBase {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer wingR1;
    ModelRenderer wingR2;
    ModelRenderer wingR3;
    ModelRenderer wingL1;
    ModelRenderer wingL2;
    ModelRenderer wingL3;
    ModelRenderer headdress1;
    ModelRenderer headdress2;
    ModelRenderer headdress3;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer hand1;
    ModelRenderer hand2;

    public EntityBakaModel() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(0F, 0F, 0F, 8, 8, 8);
        head.setRotationPoint(-4F, 0F, -4F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 32, 0);
        body1.addBox(0F, 0F, 0F, 6, 3, 6);
        body1.setRotationPoint(-3F, 8F, -3F);
        body1.setTextureSize(128, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 56, 0);
        body2.addBox(0F, 0F, 0F, 8, 5, 8);
        body2.setRotationPoint(-4F, 11F, -4F);
        body2.setTextureSize(128, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 42, 16);
        body3.addBox(0F, 0F, 0F, 10, 6, 10);
        body3.setRotationPoint(-5F, 16F, -5F);
        body3.setTextureSize(128, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        wingR1 = new ModelRenderer(this, 8, 28);
        wingR1.addBox(0F, 0F, -1F, 10, 2, 2);
        wingR1.setRotationPoint(1F, 7F, -4F);
        wingR1.setTextureSize(128, 32);
        wingR1.mirror = true;
        setRotation(wingR1, 0F, 0F, -0.3141593F);
        wingR2 = new ModelRenderer(this, 8, 28);
        wingR2.addBox(0F, 0F, 0F, 10, 2, 2);
        wingR2.setRotationPoint(2F, 9F, -5F);
        wingR2.setTextureSize(128, 32);
        wingR2.mirror = true;
        setRotation(wingR2, 0F, 0F, 0F);
        wingR3 = new ModelRenderer(this, 8, 28);
        wingR3.addBox(0F, 0F, 0F, 10, 2, 2);
        wingR3.setRotationPoint(2F, 11F, -5F);
        wingR3.setTextureSize(128, 32);
        wingR3.mirror = true;
        setRotation(wingR3, 0F, 0F, 0.3141593F);
        wingL1 = new ModelRenderer(this, 8, 28);
        wingL1.addBox(0F, 0F, 0F, 10, 2, 2);
        wingL1.setRotationPoint(-11F, 4F, -5F);
        wingL1.setTextureSize(128, 32);
        wingL1.mirror = true;
        setRotation(wingL1, 0F, 0F, 0.3141593F);
        wingL2 = new ModelRenderer(this, 8, 28);
        wingL2.addBox(0F, 0F, 0F, 10, 2, 2);
        wingL2.setRotationPoint(-12F, 9F, -5F);
        wingL2.setTextureSize(128, 32);
        wingL2.mirror = true;
        setRotation(wingL2, 0F, 0F, 0F);
        wingL3 = new ModelRenderer(this, 8, 28);
        wingL3.addBox(0F, 0F, 0F, 10, 2, 2);
        wingL3.setRotationPoint(-11F, 14F, -5F);
        wingL3.setTextureSize(128, 32);
        wingL3.mirror = true;
        setRotation(wingL3, 0F, 0F, -0.3141593F);
        headdress1 = new ModelRenderer(this, 8, 23);
        headdress1.addBox(0F, 0F, 0F, 6, 4, 1);
        headdress1.setRotationPoint(1F, -1F, -5F);
        headdress1.setTextureSize(128, 32);
        headdress1.mirror = true;
        setRotation(headdress1, 0F, 0F, 0F);
        headdress2 = new ModelRenderer(this, 8, 23);
        headdress2.addBox(0F, 0F, 0F, 6, 4, 1);
        headdress2.setRotationPoint(-7F, -1F, -5F);
        headdress2.setTextureSize(128, 32);
        headdress2.mirror = true;
        setRotation(headdress2, 0F, 0F, 0F);
        headdress3 = new ModelRenderer(this, 22, 24);
        headdress3.addBox(0F, 0F, 0F, 2, 2, 2);
        headdress3.setRotationPoint(-1F, 0F, -6F);
        headdress3.setTextureSize(128, 32);
        headdress3.mirror = true;
        setRotation(headdress3, 0F, 0F, 0F);
        foot1 = new ModelRenderer(this, 32, 28);
        foot1.addBox(0F, 0F, 0F, 3, 2, 2);
        foot1.setRotationPoint(1F, 22F, -1F);
        foot1.setTextureSize(128, 32);
        foot1.mirror = true;
        setRotation(foot1, 0F, 0F, 0F);
        foot2 = new ModelRenderer(this, 32, 28);
        foot2.addBox(0F, 0F, 0F, 3, 2, 2);
        foot2.setRotationPoint(-4F, 22F, -1F);
        foot2.setTextureSize(128, 32);
        foot2.mirror = true;
        setRotation(foot2, 0F, 0F, 0F);
        hand1 = new ModelRenderer(this, 0, 20);
        hand1.addBox(1F, -2F, 0F, 2, 10, 2);
        hand1.setRotationPoint(3F, 12F, -1F);
        hand1.setTextureSize(128, 32);
        hand1.mirror = true;
        setRotation(hand1, 0.8625438F, -0.3490659F, 0F);
        hand2 = new ModelRenderer(this, 0, 20);
        hand2.addBox(0F, 0F, 0F, 2, 10, 2);
        hand2.setRotationPoint(-6F, 11F, -1F);
        hand2.setTextureSize(128, 32);
        hand2.mirror = true;
        setRotation(hand2, 0.8625438F, 0.3490659F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body1.render(f5);
        body2.render(f5);
        body3.render(f5);
        wingR1.render(f5);
        wingR2.render(f5);
        wingR3.render(f5);
        wingL1.render(f5);
        wingL2.render(f5);
        wingL3.render(f5);
        headdress1.render(f5);
        headdress2.render(f5);
        headdress3.render(f5);
        foot1.render(f5);
        foot2.render(f5);
        hand1.render(f5);
        hand2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
