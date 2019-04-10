package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.danmaku.model.EntityHakureDanmakuModel;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityHakureDanmaku;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class EntityHakureDanmakuRender extends Render<EntityHakureDanmaku> {

    public static final EntityHakureDanmakuRender.Factory FACTORY = new EntityHakureDanmakuRender.Factory();
    private ModelBase mainModel;

    public EntityHakureDanmakuRender(RenderManager renderManagerIn, ModelBase modelbaseIn) {
        super(renderManagerIn);
        this.mainModel = modelbaseIn;
    }

    @Override
    public void doRender(EntityHakureDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.enableRescaleNormal();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y + 0.2, z);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-entity.rotationPitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(0.1, 0.1, 0.1);

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, 0, 0, 0, 0, 0, 0.0625F);

        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHakureDanmaku entity) {
        return new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/danmaku/hakure_danmaku.png");
    }

    public static class Factory implements IRenderFactory<EntityHakureDanmaku> {
        @Override
        public Render<? super EntityHakureDanmaku> createRenderFor(RenderManager manager) {
            return new EntityHakureDanmakuRender(manager, new EntityHakureDanmakuModel());
        }
    }
}
