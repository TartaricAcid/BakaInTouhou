package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityStarModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityStar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityStarRender extends RenderEntityTouhouCharacter<EntityStar> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/star.png");

    public EntityStarRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityStar entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityStar entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityStar> {
        @Override
        public Render<? super EntityStar> createRenderFor(RenderManager manager) {
            return new EntityStarRender(manager, new EntityStarModel(), 0.5f);
        }
    }
}
