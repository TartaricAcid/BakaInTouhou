package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityPrismriverModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityLyrica;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityLyricaRender extends RenderEntityTouhouCharacter<EntityLyrica> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/lyrica.png");

    public EntityLyricaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLyrica entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityLyrica entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityLyrica> {
        @Override
        public Render<? super EntityLyrica> createRenderFor(RenderManager manager) {
            return new EntityLyricaRender(manager, new EntityPrismriverModel(), 0.5f);
        }
    }
}
