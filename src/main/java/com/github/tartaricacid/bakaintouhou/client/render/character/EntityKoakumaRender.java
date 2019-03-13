package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityKoakumaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityKoakuma;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityKoakumaRender extends RenderEntityTouhouCharacter<EntityKoakuma> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/koakuma.png");

    public EntityKoakumaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKoakuma entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityKoakuma entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityKoakuma> {
        @Override
        public Render<? super EntityKoakuma> createRenderFor(RenderManager manager) {
            return new EntityKoakumaRender(manager, new EntityKoakumaModel(), 0.5f);
        }
    }
}
