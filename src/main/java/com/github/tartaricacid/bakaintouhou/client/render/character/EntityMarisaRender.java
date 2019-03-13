package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityMarisaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMarisa;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMarisaRender extends RenderEntityTouhouCharacter<EntityMarisa> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/marisa.png");

    public EntityMarisaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMarisa entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityMarisa entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityMarisa> {
        @Override
        public Render<? super EntityMarisa> createRenderFor(RenderManager manager) {
            return new EntityMarisaRender(manager, new EntityMarisaModel(), 0.5f);
        }
    }
}
