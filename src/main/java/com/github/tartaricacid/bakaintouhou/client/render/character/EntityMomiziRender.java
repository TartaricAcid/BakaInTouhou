package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityMomiziModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMomizi;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMomiziRender extends RenderEntityTouhouCharacter<EntityMomizi> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/momizi.png");

    public EntityMomiziRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMomizi entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityMomizi entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityMomizi> {
        @Override
        public Render<? super EntityMomizi> createRenderFor(RenderManager manager) {
            return new EntityMomiziRender(manager, new EntityMomiziModel(), 0.5f);
        }
    }
}
