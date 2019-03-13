package com.github.tartaricacid.bakaintouhou.client.render.danmaku.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityKnifeDanmakuModel extends ModelBase {
    private ModelRenderer blade;
    private ModelRenderer middle;
    private ModelRenderer handle;

    public EntityKnifeDanmakuModel() {
        textureWidth = 32;
        textureHeight = 32;

        blade = new ModelRenderer(this, -10, 0);
        blade.addBox(-1.5F, 0F, -10F, 3, 0, 10);
        blade.setRotationPoint(0F, 22F, 2F);
        blade.setTextureSize(32, 32);
        blade.mirror = true;
        setRotation(blade, 0F, 0F, 0F);
        middle = new ModelRenderer(this, 7, 0);
        middle.addBox(-2.5F, -1.5F, 0F, 5, 3, 1);
        middle.setRotationPoint(0F, 22F, 2F);
        middle.setTextureSize(32, 32);
        middle.mirror = true;
        setRotation(middle, 0F, 0F, 0F);
        handle = new ModelRenderer(this, 0, 11);
        handle.addBox(-1F, -1F, 0F, 2, 2, 5);
        handle.setRotationPoint(0F, 22F, 3F);
        handle.setTextureSize(32, 32);
        handle.mirror = true;
        setRotation(handle, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        blade.render(f5);
        middle.render(f5);
        handle.render(f5);
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
