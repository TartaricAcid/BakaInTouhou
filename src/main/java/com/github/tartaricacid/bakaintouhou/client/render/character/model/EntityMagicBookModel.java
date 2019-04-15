package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class EntityMagicBookModel extends EntityTouhouCharacterModel {
    //fields
    ModelRenderer book1;
    ModelRenderer book2;
    ModelRenderer book3;
    ModelRenderer book4;

    public EntityMagicBookModel() {
        textureWidth = 128;
        textureHeight = 64;

        book1 = new ModelRenderer(this, 0, 0);
        book1.addBox(0F, 0F, -8F, 12, 1, 16);
        book1.setRotationPoint(-0.8F, 22F, 0F);
        book1.setTextureSize(128, 64);
        book1.mirror = true;
        setRotation(book1, 0F, 0F, -0.3490659F);
        book2 = new ModelRenderer(this, 57, 0);
        book2.addBox(-12F, 0F, -8F, 12, 1, 16);
        book2.setRotationPoint(0.8F, 22F, 0F);
        book2.setTextureSize(128, 64);
        book2.mirror = true;
        setRotation(book2, 0F, 0F, 0.3490659F);
        book3 = new ModelRenderer(this, 0, 18);
        book3.addBox(0F, 0F, -7F, 10, 2, 14);
        book3.setRotationPoint(-1F, 20F, 0F);
        book3.setTextureSize(128, 64);
        book3.mirror = true;
        setRotation(book3, 0F, 0F, -0.3490659F);
        book4 = new ModelRenderer(this, 49, 18);
        book4.addBox(-10F, 0F, -7F, 10, 2, 14);
        book4.setRotationPoint(1F, 20F, 0F);
        book4.setTextureSize(128, 64);
        book4.mirror = true;
        setRotation(book4, 0F, 0F, 0.3490659F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        book1.render(f5);
        book2.render(f5);
        book3.render(f5);
        book4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.book1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.3f) * 0.2f - 0.5f;
        this.book2.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.3f) * 0.2f + 0.5f;
        this.book3.rotateAngleZ = MathHelper.cos(ageInTicks * 0.3f) * 0.2f - 0.5f;
        this.book4.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.3f) * 0.2f + 0.5f;
    }
}
