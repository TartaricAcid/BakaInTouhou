package com.github.tartaricacid.bakaintouhou.client.render.item.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EntityMarisaBroomModel extends ModelBase {
    //fields
    private ModelRenderer handle;
    private ModelRenderer head1;
    private ModelRenderer head2;
    private ModelRenderer head3;

    public EntityMarisaBroomModel() {
        textureWidth = 128;
        textureHeight = 128;

        handle = new ModelRenderer(this, 0, 46);
        handle.addBox(-1F, -1F, -24F, 2, 2, 32);
        handle.setRotationPoint(0F, 20F, 0F);
        handle.setTextureSize(128, 128);
        handle.mirror = true;
        setRotation(handle, 0F, 0F, 0F);
        head1 = new ModelRenderer(this, 0, 0);
        head1.addBox(0F, -1.5F, 0F, 6, 3, 12);
        head1.setRotationPoint(-3F, 20F, 5F);
        head1.setTextureSize(128, 128);
        head1.mirror = true;
        setRotation(head1, 0F, 0.3490659F, 0F);
        head2 = new ModelRenderer(this, 37, 0);
        head2.addBox(-3F, -1.5F, 0F, 6, 3, 11);
        head2.setRotationPoint(0F, 20F, 5F);
        head2.setTextureSize(128, 128);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        head3 = new ModelRenderer(this, 0, 0);
        head3.addBox(-6F, -1.5F, 0F, 6, 3, 12);
        head3.setRotationPoint(3F, 20F, 5F);
        head3.setTextureSize(128, 128);
        head3.mirror = true;
        setRotation(head3, 0F, -0.3490659F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        handle.render(f5);
        head1.render(f5);
        head2.render(f5);
        head3.render(f5);
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
