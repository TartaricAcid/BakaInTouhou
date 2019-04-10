package com.github.tartaricacid.bakaintouhou.client.render.danmaku.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityHakureDanmakuModel extends ModelBase {
    //fields
    private ModelRenderer body;

    public EntityHakureDanmakuModel() {
        textureWidth = 32;
        textureHeight = 64;

        body = new ModelRenderer(this, -64, 0);
        body.addBox(-16F, 0F, -32F, 32, 0, 64);
        body.setRotationPoint(0F, 22F, 0F);
        body.setTextureSize(32, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
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
