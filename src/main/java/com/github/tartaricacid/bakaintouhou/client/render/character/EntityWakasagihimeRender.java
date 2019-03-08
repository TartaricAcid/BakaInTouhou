package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityWakasagihimeModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityWakasagihime;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityWakasagihimeRender extends RenderEntityTouhouCharacter<EntityWakasagihime> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/wakasagihime.png");

    public EntityWakasagihimeRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWakasagihime entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityWakasagihime entity, float partialTickTime) {
        GlStateManager.translate(0f, -0.1f, 0f);
    }

    public static class Factory implements IRenderFactory<EntityWakasagihime> {
        @Override
        public Render<? super EntityWakasagihime> createRenderFor(RenderManager manager) {
            return new EntityWakasagihimeRender(manager, new EntityWakasagihimeModel(), 0.5f);
        }
    }
}
