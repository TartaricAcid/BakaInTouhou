package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityRumiaModel;
import com.github.tartaricacid.bakaintouhou.client.util.CustomShape;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityRumia;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class EntityRumiaRender extends RenderEntityTouhouCharacter<EntityRumia> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/rumia.png");

    public EntityRumiaRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    public void doRender(EntityRumia entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        //GlStateManager.disableCull();

        GlStateManager.translate(x, y + 0.8, z);
        GlStateManager.scale(2f, 2f, 2f);
        GlStateManager.color(0f, 0f, 0f, 0.98f);
        GlStateManager.callList(CustomShape.SPHERE_OUT_INDEX);
        GlStateManager.callList(CustomShape.SPHERE_IN_INDEX);

        //GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRumia entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityRumia entity, float partialTickTime) {
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
    }

    public static class Factory implements IRenderFactory<EntityRumia> {
        @Override
        public Render<? super EntityRumia> createRenderFor(RenderManager manager) {
            return new EntityRumiaRender(manager, new EntityRumiaModel(), 0.5f);
        }
    }
}
