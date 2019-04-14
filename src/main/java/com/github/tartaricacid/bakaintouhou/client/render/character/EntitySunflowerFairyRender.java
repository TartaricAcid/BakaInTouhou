package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntitySunflowerFairyModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntitySunflowerFairy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntitySunflowerFairyRender extends RenderEntityTouhouCharacter<EntitySunflowerFairy> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/sunflower_fairy.png");

    public EntitySunflowerFairyRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySunflowerFairy entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntitySunflowerFairy entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntitySunflowerFairy> {
        @Override
        public Render<? super EntitySunflowerFairy> createRenderFor(RenderManager manager) {
            return new EntitySunflowerFairyRender(manager, new EntitySunflowerFairyModel(), 0.5f);
        }
    }
}
