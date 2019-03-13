package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityCirnoModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityCirno;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityCirnoRender extends RenderEntityTouhouCharacter<EntityCirno> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/cirno.png");

    public EntityCirnoRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCirno entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityCirno entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityCirno> {
        @Override
        public Render<? super EntityCirno> createRenderFor(RenderManager manager) {
            return new EntityCirnoRender(manager, new EntityCirnoModel(), 0.5f);
        }
    }
}
