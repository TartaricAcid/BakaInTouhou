package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityPatchouliModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityPatchouli;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityPatchouliRender extends RenderEntityTouhouCharacter<EntityPatchouli> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/patchouli.png");

    public EntityPatchouliRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPatchouli entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityPatchouli entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityPatchouli> {
        @Override
        public Render<? super EntityPatchouli> createRenderFor(RenderManager manager) {
            return new EntityPatchouliRender(manager, new EntityPatchouliModel(), 0.5f);
        }
    }
}
