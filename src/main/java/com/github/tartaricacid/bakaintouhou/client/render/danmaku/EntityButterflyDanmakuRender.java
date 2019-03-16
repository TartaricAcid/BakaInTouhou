package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.danmaku.model.EntityButterflyDanmakuModel;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityButterflyDanmaku;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class EntityButterflyDanmakuRender extends Render<EntityButterflyDanmaku> {

    public static final EntityButterflyDanmakuRender.Factory FACTORY = new EntityButterflyDanmakuRender.Factory();
    private ModelBase mainModel;

    public EntityButterflyDanmakuRender(RenderManager renderManagerIn, ModelBase modelbaseIn) {
        super(renderManagerIn);
        this.mainModel = modelbaseIn;
    }

    @Override
    public void doRender(EntityButterflyDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.disableAlpha();
        GlStateManager.color(0f, 0f, 1f, 1f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y, z);
        GlStateManager.scale(0.3, 0.3, 0.3);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-entity.rotationPitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(180, 1.0F, 0.0F, 0.0F);

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, 0, 0, entity.ticksExisted + partialTicks, 0, 0, 0.0625F);

        GlStateManager.disableBlend();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.enableAlpha();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityButterflyDanmaku entity) {
        return new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/danmaku/butterfly_danmaku.png");
    }

    public static class Factory implements IRenderFactory<EntityButterflyDanmaku> {
        @Override
        public Render<? super EntityButterflyDanmaku> createRenderFor(RenderManager manager) {
            return new EntityButterflyDanmakuRender(manager, new EntityButterflyDanmakuModel());
        }
    }
}
