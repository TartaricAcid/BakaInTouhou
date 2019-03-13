package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntitySunnyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntitySunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntitySunnyRender extends RenderEntityTouhouCharacter<EntitySunny> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/sunny.png");

    public EntitySunnyRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySunny entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntitySunny entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntitySunny> {
        @Override
        public Render<? super EntitySunny> createRenderFor(RenderManager manager) {
            return new EntitySunnyRender(manager, new EntitySunnyModel(), 0.5f);
        }
    }
}
