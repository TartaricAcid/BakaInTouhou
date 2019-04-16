package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityLaserDanmaku;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.util.List;

public class EntityLaserDanmakuRender extends Render<EntityLaserDanmaku> {

    public static final EntityLaserDanmakuRender.Factory FACTORY = new EntityLaserDanmakuRender.Factory();

    public EntityLaserDanmakuRender(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    private static List<BakedQuad> getBakedQuard() throws Exception {
        IModel model = ModelLoaderRegistry.getModel(new ResourceLocation(BakaInTouhou.MOD_ID,
                "entity/laser_danmaku.obj"));
        IBakedModel bakedModel = model.bake(model.getDefaultState(), DefaultVertexFormats.ITEM, ModelLoader.defaultTextureGetter());
        return bakedModel.getQuads(null, null, 0);
    }

    @Override
    public void doRender(EntityLaserDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.disableAlpha();
        GlStateManager.enableCull();
        GlStateManager.enableRescaleNormal();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-entity.rotationPitch, 1.0f, 0.0f, 0.0f);

        GlStateManager.scale(1f, 1f, entity.getLength());

        try {
            List<BakedQuad> quads = getBakedQuard();
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buff = tessellator.getBuffer();
            buff.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

            for (BakedQuad quad : quads) {
                LightUtil.renderQuadColor(buff, quad, 0xee_00_00_00 // 透明度硬编码为 aa
                        + entity.getDanmakuColor());
            }

            tessellator.draw();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLaserDanmaku entity) {
        return null;
    }

    public static class Factory implements IRenderFactory<EntityLaserDanmaku> {
        @Override
        public Render<? super EntityLaserDanmaku> createRenderFor(RenderManager manager) {
            return new EntityLaserDanmakuRender(manager);
        }
    }
}

