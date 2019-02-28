package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

public abstract class RenderEntityTouhouCharacter<T extends EntityTouhouCharacter> extends RenderLiving<T> {
    public RenderEntityTouhouCharacter(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    protected void renderEntityName(T entityIn, double x, double y, double z, String name, double distanceSq) {
        super.renderEntityName(entityIn, x, y, z, entityIn.getName(), distanceSq);
    }

    @Override
    protected boolean canRenderName(T entity) {
        return true;
    }
}
