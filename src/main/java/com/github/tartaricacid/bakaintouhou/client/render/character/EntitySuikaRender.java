package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntitySuikaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntitySuika;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntitySuikaRender extends RenderEntityTouhouCharacter<EntitySuika> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/suika.png");

    public EntitySuikaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySuika entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntitySuika entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntitySuika> {
        @Override
        public Render<? super EntitySuika> createRenderFor(RenderManager manager) {
            return new EntitySuikaRender(manager, new EntitySuikaModel(), 0.5f);
        }
    }
}
