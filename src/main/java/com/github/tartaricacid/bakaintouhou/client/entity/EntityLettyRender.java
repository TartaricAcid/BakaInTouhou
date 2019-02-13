package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntityLettyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityLetty;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityLettyRender extends RenderLiving<EntityLetty> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/letty.png");

    public EntityLettyRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLetty entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityLetty entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityLetty> {
        @Override
        public Render<? super EntityLetty> createRenderFor(RenderManager manager) {
            return new EntityLettyRender(manager, new EntityLettyModel(), 0.5f);
        }
    }
}
