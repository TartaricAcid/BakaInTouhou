package com.github.tartaricacid.bakaintouhou.client.render.item;

import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMiniHakkero;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMiniHakkeroRender extends Render<EntityMiniHakkero> {
    public static final EntityMiniHakkeroRender.Factory FACTORY = new EntityMiniHakkeroRender.Factory();

    public EntityMiniHakkeroRender(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityMiniHakkero entity, double x, double y, double z, float entityYaw, float partialTicks) {
        // TODO：渲染出魔炮
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMiniHakkero entity) {
        return null;
    }

    public static class Factory implements IRenderFactory<EntityMiniHakkero> {
        @Override
        public Render<? super EntityMiniHakkero> createRenderFor(RenderManager manager) {
            return new EntityMiniHakkeroRender(manager);
        }
    }
}
