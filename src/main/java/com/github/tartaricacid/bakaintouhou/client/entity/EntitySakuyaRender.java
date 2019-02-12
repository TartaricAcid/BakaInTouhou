package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntitySakuyaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntitySakuya;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntitySakuyaRender extends RenderLiving<EntitySakuya> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/sakuya.png");

    public EntitySakuyaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySakuya entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntitySakuya entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntitySakuya> {
        @Override
        public Render<? super EntitySakuya> createRenderFor(RenderManager manager) {
            return new EntitySakuyaRender(manager, new EntitySakuyaModel(), 0.5f);
        }
    }
}
