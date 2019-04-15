package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityFairyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityFairyBlue;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityFairyBlueRender extends RenderEntityTouhouCharacter<EntityFairyBlue> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/fairy_b.png");

    public EntityFairyBlueRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFairyBlue entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityFairyBlue entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityFairyBlue> {
        @Override
        public Render<? super EntityFairyBlue> createRenderFor(RenderManager manager) {
            return new EntityFairyBlueRender(manager, new EntityFairyModel(), 0.5f);
        }
    }
}
