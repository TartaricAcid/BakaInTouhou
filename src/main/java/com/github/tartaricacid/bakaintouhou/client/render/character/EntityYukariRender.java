package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityYukariModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityYukari;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityYukariRender extends RenderEntityTouhouCharacter<EntityYukari> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/yukari.png");

    public EntityYukariRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityYukari entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityYukari entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityYukari> {
        @Override
        public Render<? super EntityYukari> createRenderFor(RenderManager manager) {
            return new EntityYukariRender(manager, new EntityYukariModel(), 0.5f);
        }
    }
}
