package com.github.tartaricacid.bakaintouhou.client.entity.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.entity.character.model.EntityYuyukoModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityYuyuko;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityYuyukoRender extends RenderLiving<EntityYuyuko> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/yuyuko.png");

    public EntityYuyukoRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityYuyuko entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityYuyuko entity, float partialTickTime) {
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
    }

    public static class Factory implements IRenderFactory<EntityYuyuko> {
        @Override
        public Render<? super EntityYuyuko> createRenderFor(RenderManager manager) {
            return new EntityYuyukoRender(manager, new EntityYuyukoModel(), 0.5f);
        }
    }
}
