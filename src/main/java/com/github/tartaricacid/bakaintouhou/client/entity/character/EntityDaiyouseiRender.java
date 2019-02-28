package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityDaiyouseiModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityDaiyousei;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityDaiyouseiRender extends RenderLiving<EntityDaiyousei> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/daiyousei.png");

    public EntityDaiyouseiRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDaiyousei entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityDaiyousei entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityDaiyousei> {
        @Override
        public Render<? super EntityDaiyousei> createRenderFor(RenderManager manager) {
            return new EntityDaiyouseiRender(manager, new EntityDaiyouseiModel(), 0.5f);
        }
    }
}
