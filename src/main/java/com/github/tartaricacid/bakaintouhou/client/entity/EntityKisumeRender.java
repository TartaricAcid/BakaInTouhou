package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.model.EntityKisumeModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityKisume;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityKisumeRender extends RenderLiving<EntityKisume> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/kisume.png");

    public EntityKisumeRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKisume entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityKisume entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        GlStateManager.translate(0f, -0.3f, 0f);
    }

    public static class Factory implements IRenderFactory<EntityKisume> {
        @Override
        public Render<? super EntityKisume> createRenderFor(RenderManager manager) {
            return new EntityKisumeRender(manager, new EntityKisumeModel(), 0.5f);
        }
    }
}
