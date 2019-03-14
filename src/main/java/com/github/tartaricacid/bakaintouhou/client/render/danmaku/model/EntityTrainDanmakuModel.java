package com.github.tartaricacid.bakaintouhou.client.render.danmaku.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityTrainDanmakuModel extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer top;
    private ModelRenderer topR;
    private ModelRenderer topL;
    private ModelRenderer bottom1;
    private ModelRenderer bottom2;

    public EntityTrainDanmakuModel() {
        textureWidth = 512;
        textureHeight = 512;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-16F, -16F, -64F, 32, 32, 128);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(512, 512);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        top = new ModelRenderer(this, 0, 160);
        top.addBox(-11F, 0F, -64F, 22, 3, 128);
        top.setRotationPoint(0F, -19F, 0F);
        top.setTextureSize(512, 512);
        top.mirror = true;
        setRotation(top, 0F, 0F, 0F);
        topR = new ModelRenderer(this, 0, 294);
        topR.addBox(-3F, 0F, -64F, 7, 3, 128);
        topR.setRotationPoint(12.3F, -18F, 0F);
        topR.setTextureSize(512, 512);
        topR.mirror = true;
        setRotation(topR, 0F, 0F, 0.4886922F);
        topL = new ModelRenderer(this, 0, 294);
        topL.addBox(-3F, 0F, -64F, 7, 3, 128);
        topL.setRotationPoint(-13.5F, -17.5F, 0F);
        topL.setTextureSize(512, 512);
        topL.mirror = true;
        setRotation(topL, 0F, 0F, -0.4886922F);
        bottom1 = new ModelRenderer(this, 0, 300);
        bottom1.addBox(0F, 0F, -64F, 0, 5, 128);
        bottom1.setRotationPoint(-12F, 16F, 0F);
        bottom1.setTextureSize(512, 512);
        bottom1.mirror = true;
        setRotation(bottom1, 0F, 0F, 0F);
        bottom2 = new ModelRenderer(this, 0, 300);
        bottom2.addBox(0F, 0F, -64F, 0, 5, 128);
        bottom2.setRotationPoint(12F, 16F, 0F);
        bottom2.setTextureSize(512, 512);
        bottom2.mirror = true;
        setRotation(bottom2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        top.render(f5);
        topR.render(f5);
        topL.render(f5);
        bottom1.render(f5);
        bottom2.render(f5);
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
