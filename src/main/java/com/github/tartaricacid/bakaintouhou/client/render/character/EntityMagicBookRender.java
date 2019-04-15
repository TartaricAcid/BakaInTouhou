package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityMagicBookModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMagicBook;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityMagicBookRender extends RenderEntityTouhouCharacter<EntityMagicBook> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/magic_book.png");

    public EntityMagicBookRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMagicBook entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityMagicBook entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityMagicBook> {
        @Override
        public Render<? super EntityMagicBook> createRenderFor(RenderManager manager) {
            return new EntityMagicBookRender(manager, new EntityMagicBookModel(), 0.5f);
        }
    }
}
