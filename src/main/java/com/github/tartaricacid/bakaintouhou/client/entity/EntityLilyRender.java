package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntityLilyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityLily;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityLilyRender extends RenderLiving<EntityLily> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lily.png");

    public EntityLilyRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLily entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityLily entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
        GlStateManager.translate(0f, 0.1f, 0f);
    }

    public static class Factory implements IRenderFactory<EntityLily> {
        @Override
        public Render<? super EntityLily> createRenderFor(RenderManager manager) {
            return new EntityLilyRender(manager, new EntityLilyModel(), 0.5f);
        }
    }
}
