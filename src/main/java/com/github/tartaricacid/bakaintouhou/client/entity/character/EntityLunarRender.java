package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityLunarModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityLunar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityLunarRender extends RenderLiving<EntityLunar> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lunar.png");

    public EntityLunarRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLunar entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityLunar entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityLunar> {
        @Override
        public Render<? super EntityLunar> createRenderFor(RenderManager manager) {
            return new EntityLunarRender(manager, new EntityLunarModel(), 0.5f);
        }
    }
}
