package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntityFrandleModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityFrandle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityFrandleRender extends RenderLiving<EntityFrandle> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/frandle.png");

    public EntityFrandleRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFrandle entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityFrandle entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityFrandle> {
        @Override
        public Render<? super EntityFrandle> createRenderFor(RenderManager manager) {
            return new EntityFrandleRender(manager, new EntityFrandleModel(), 0.5f);
        }
    }
}
