package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.danmaku.model.EntityTrainDanmakuModel;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityTrainDanmaku;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class EntityTrainDanmakuRender extends Render<EntityTrainDanmaku> {

    public static final EntityTrainDanmakuRender.Factory FACTORY = new EntityTrainDanmakuRender.Factory();
    private ModelBase mainModel;

    public EntityTrainDanmakuRender(RenderManager renderManagerIn, ModelBase modelbaseIn) {
        super(renderManagerIn);
        this.mainModel = modelbaseIn;
    }

    @Override
    public void doRender(EntityTrainDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y + 1, z);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-entity.rotationPitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(180, 0.0F, 0.0F, 1.0F);

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, 0, 0, 0, 0, 0, 0.0625F);

        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTrainDanmaku entity) {
        return new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/danmaku/train_danmaku.png");
    }

    public static class Factory implements IRenderFactory<EntityTrainDanmaku> {
        @Override
        public Render<? super EntityTrainDanmaku> createRenderFor(RenderManager manager) {
            return new EntityTrainDanmakuRender(manager, new EntityTrainDanmakuModel());
        }
    }
}
