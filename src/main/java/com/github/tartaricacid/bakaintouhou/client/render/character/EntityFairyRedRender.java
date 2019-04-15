package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityFairyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityFairyRed;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityFairyRedRender extends RenderEntityTouhouCharacter<EntityFairyRed> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/fairy_r.png");

    public EntityFairyRedRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFairyRed entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityFairyRed entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityFairyRed> {
        @Override
        public Render<? super EntityFairyRed> createRenderFor(RenderManager manager) {
            return new EntityFairyRedRender(manager, new EntityFairyModel(), 0.5f);
        }
    }
}
