package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityRemiliaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityRemilia;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityRemiliaRender extends RenderEntityTouhouCharacter<EntityRemilia> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/remilia.png");

    public EntityRemiliaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRemilia entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityRemilia entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityRemilia> {
        @Override
        public Render<? super EntityRemilia> createRenderFor(RenderManager manager) {
            return new EntityRemiliaRender(manager, new EntityRemiliaModel(), 0.5f);
        }
    }
}
