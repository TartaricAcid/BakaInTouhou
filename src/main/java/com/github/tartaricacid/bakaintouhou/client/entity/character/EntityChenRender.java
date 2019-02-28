package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityChenModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityChen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityChenRender extends RenderEntityTouhouCharacter<EntityChen> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/chen.png");

    public EntityChenRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityChen entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityChen entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityChen> {
        @Override
        public Render<? super EntityChen> createRenderFor(RenderManager manager) {
            return new EntityChenRender(manager, new EntityChenModel(), 0.5f);
        }
    }
}
