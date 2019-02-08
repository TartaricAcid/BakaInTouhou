package com.github.tartaricacid.bakaintouhou.client.entity;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.model.EntityBakaModel;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityBaka;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityBakaRender extends RenderLiving<EntityBaka> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/baka.png");

    public EntityBakaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBaka entity) {
        return resourceLocation;
    }

    public static class Factory implements IRenderFactory<EntityBaka> {
        @Override
        public Render<? super EntityBaka> createRenderFor(RenderManager manager) {
            return new EntityBakaRender(manager, new EntityBakaModel(), 0.5f);
        }
    }
}
