package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityRanModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityRan;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityRanRender extends RenderEntityTouhouCharacter<EntityRan> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/ran.png");

    public EntityRanRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRan entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityRan entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityRan> {
        @Override
        public Render<? super EntityRan> createRenderFor(RenderManager manager) {
            return new EntityRanRender(manager, new EntityRanModel(), 0.5f);
        }
    }
}
