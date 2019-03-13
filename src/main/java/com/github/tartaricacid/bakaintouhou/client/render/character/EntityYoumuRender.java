package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityYoumuModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityYoumu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityYoumuRender extends RenderEntityTouhouCharacter<EntityYoumu> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/youmu.png");

    public EntityYoumuRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityYoumu entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityYoumu entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityYoumu> {
        @Override
        public Render<? super EntityYoumu> createRenderFor(RenderManager manager) {
            return new EntityYoumuRender(manager, new EntityYoumuModel(), 0.5f);
        }
    }
}
