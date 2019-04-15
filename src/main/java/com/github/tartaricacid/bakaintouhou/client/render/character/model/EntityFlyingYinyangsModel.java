package com.github.tartaricacid.bakaintouhou.client.render.character.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityFlyingYinyangsModel extends EntityTouhouCharacterModel {
    //fields
    ModelRenderer main;
    ModelRenderer round;

    public EntityFlyingYinyangsModel() {
        textureWidth = 64;
        textureHeight = 128;

        main = new ModelRenderer(this, 0, 0);
        main.addBox(-16F, -16F, 0F, 32, 32, 0);
        main.setRotationPoint(0F, 0F, 0F);
        main.setTextureSize(64, 128);
        main.mirror = true;
        setRotation(main, 0F, 0F, 0F);
        round = new ModelRenderer(this, 0, 33);
        round.addBox(-20F, -20F, 0F, 40, 40, 0);
        round.setRotationPoint(0F, 0F, 0F);
        round.setTextureSize(64, 128);
        round.mirror = true;
        setRotation(round, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        main.render(f5);
        round.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.round.rotateAngleZ = ageInTicks / 15;
    }
}
