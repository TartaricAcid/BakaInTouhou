package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntityRumiaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityRumia;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityRumiaRender extends RenderLiving<EntityRumia> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/rumia.png");

    public EntityRumiaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRumia entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityRumia entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityRumia> {
        @Override
        public Render<? super EntityRumia> createRenderFor(RenderManager manager) {
            return new EntityRumiaRender(manager, new EntityRumiaModel(), 0.5f);
        }
    }
}
