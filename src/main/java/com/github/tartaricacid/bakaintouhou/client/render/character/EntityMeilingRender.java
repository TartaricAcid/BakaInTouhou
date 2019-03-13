package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityMeilingModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMeiling;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMeilingRender extends RenderEntityTouhouCharacter<EntityMeiling> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/meiling.png");

    public EntityMeilingRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMeiling entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityMeiling entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityMeiling> {
        @Override
        public Render<? super EntityMeiling> createRenderFor(RenderManager manager) {
            return new EntityMeilingRender(manager, new EntityMeilingModel(), 0.5f);
        }
    }
}
