package com.github.tartaricacid.bakaintouhou.client.render.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityNormalDanmaku;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuInit;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class EntityNormalDanmakuRender extends Render<EntityNormalDanmaku> {
    public static final Factory FACTORY = new EntityNormalDanmakuRender.Factory();
    private double[] size = DanmakuInit.danmakuSize;

    public EntityNormalDanmakuRender(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void doRender(EntityNormalDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        // 获取相关数据
        int type = (entity.getDanmakuType()) > DanmakuInit.danmakuTypeMax ? 0 : entity.getDanmakuType();
        int color = (entity.getDanmakuColor()) > DanmakuInit.danmakuColorMax ? 0 : entity.getDanmakuColor();
        int w = DanmakuInit.danmakuTextureWidth; // 材质宽度
        int l = DanmakuInit.danmakuTextureLength; // 材质长度

        // 依据类型颜色开始定位材质位置（材质块都是 32 * 32 大小）
        double pStartU = 32 * color;
        double pStartV = 32 * type;

        GlStateManager.disableLighting();
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        // GlStateManager.depthMask(false); 不透明效果
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX,
                1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufbuilder = tessellator.getBuffer();

        bufbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        this.renderManager.renderEngine.bindTexture(getEntityTexture(entity));

        bufbuilder.pos(-size[type], size[type], 0).tex((pStartU + 0) / w, (pStartV + 32) / l).endVertex();
        bufbuilder.pos(-size[type], -size[type], 0).tex((pStartU + 0) / w, (pStartV + 0) / l).endVertex();
        bufbuilder.pos(size[type], -size[type], 0).tex((pStartU + 32) / w, (pStartV + 0) / l).endVertex();
        bufbuilder.pos(size[type], size[type], 0).tex((pStartU + 32) / w, (pStartV + 32) / l).endVertex();
        tessellator.draw();

        GlStateManager.disableBlend();
        // GlStateManager.depthMask(true);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNormalDanmaku entity) {
        return new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/danmaku/normal_danmaku.png");
    }

    public static class Factory implements IRenderFactory<EntityNormalDanmaku> {
        @Override
        public Render<? super EntityNormalDanmaku> createRenderFor(RenderManager manager) {
            return new EntityNormalDanmakuRender(manager);
        }
    }
}
