package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityPrismriverModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMerlin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMerlinRender extends RenderEntityTouhouCharacter<EntityMerlin> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/merlin.png");

    public EntityMerlinRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMerlin entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityMerlin entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityMerlin> {
        @Override
        public Render<? super EntityMerlin> createRenderFor(RenderManager manager) {
            return new EntityMerlinRender(manager, new EntityPrismriverModel(), 0.5f);
        }
    }
}
