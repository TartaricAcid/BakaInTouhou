package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityPrismriverModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityLunasa;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityLunasaRender extends RenderEntityTouhouCharacter<EntityLunasa> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/lunasa.png");

    public EntityLunasaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLunasa entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityLunasa entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityLunasa> {
        @Override
        public Render<? super EntityLunasa> createRenderFor(RenderManager manager) {
            return new EntityLunasaRender(manager, new EntityPrismriverModel(), 0.5f);
        }
    }
}
