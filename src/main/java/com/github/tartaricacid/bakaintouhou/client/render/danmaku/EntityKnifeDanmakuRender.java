package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.danmaku.model.EntityKnifeDanmakuModel;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityKnifeDanmaku;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class EntityKnifeDanmakuRender extends Render<EntityKnifeDanmaku> {
    public static final EntityKnifeDanmakuRender.Factory FACTORY = new EntityKnifeDanmakuRender.Factory();
    private ModelBase mainModel;

    public EntityKnifeDanmakuRender(RenderManager renderManagerIn, ModelBase modelbaseIn) {
        super(renderManagerIn);
        this.mainModel = modelbaseIn;
    }

    @Override
    public void doRender(EntityKnifeDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y - 1.25, z);
        GlStateManager.rotate(180, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.rotationPitch, 1.0f, 0.0f, 0.0f);

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, 0, 0, 0, 0, 0, 0.0625F);

        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKnifeDanmaku entity) {
        return new ResourceLocation(BakaInTouhou.MOD_ID, String.format("textures/entity/danmaku/knife_danmaku_%d.png", entity.getDanmakuColor()));
    }

    public static class Factory implements IRenderFactory<EntityKnifeDanmaku> {
        @Override
        public Render<? super EntityKnifeDanmaku> createRenderFor(RenderManager manager) {
            return new EntityKnifeDanmakuRender(manager, new EntityKnifeDanmakuModel());
        }
    }
}
