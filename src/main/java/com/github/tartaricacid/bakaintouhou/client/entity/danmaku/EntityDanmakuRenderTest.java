package com.github.tartaricacid.bakaintouhou.client.entity.danmaku;

import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityDanmaku;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class EntityDanmakuRenderTest extends Render<EntityDanmaku> {
    private static double[][] dVec = {
            {0.000000,50.000000,0.000000},
            {0.000000,35.355339,35.355339},
            {30.618624,35.355339,17.677670},
            {30.618624,35.355339,-17.677670},
            {0.000000,35.355339,-35.355339},
            {-30.618624,35.355339,-17.677670},
            {-30.618624,35.355339,17.677670},
            {0.000000,0.000000,50.000000},
            {43.301270,0.000000,25.000000},
            {43.301270,0.000000,-25.000000},
            {0.000000,0.000000,-50.000000},
            {-43.301270,0.000000,-25.000000},
            {-43.301270,0.000000,25.000000},
            {0.000000,-35.355339,35.355339},
            {30.618624,-35.355339,17.677670},
            {30.618624,-35.355339,-17.677670},
            {0.000000,-35.355339,-35.355339},
            {-30.618624,-35.355339,-17.677670},
            {-30.618624,-35.355339,17.677670},
            {0.000000,-50.000000,0.000000}
    };

    private static int[][] nVecPos = {
            {0,2,1},
            {0,3,2},
            {0,4,3},
            {0,5,4},
            {0,6,5},
            {0,1,6},
            {13,14,19},
            {14,15,19},
            {15,16,19},
            {16,17,19},
            {17,18,19},
            {18,13,19},
            {2,8,7},
			{2,7,1},
			{2,3,9},
			{2,9,8},
			{3,4,10},
			{3,10,9},
			{5,11,10},
			{5,10,4},
			{5,6,12},
			{5,12,11},
			{6,1,7},
			{6,7,12},
			{7,8,14},
			{7,14,13},
			{9,15,14},
			{9,14,8},
			{9,10,16},
			{9,16,15},
			{10,11,17},
			{10,17,16},
			{12,18,17},
			{12,17,11},
			{12,7,13},
			{12,13,18}
    };
    
	public EntityDanmakuRenderTest(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}


    @Override
	public void doRender(EntityDanmaku entity, double x, double y, double z, float entityYaw, float partialTicks) {
        Tessellator tessellator = Tessellator.getInstance();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();

        int color = 0xff0000;

        boolean inverse = color < 0;

        color = Math.abs(color);

        if(!inverse){
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ZERO);
        }
        else{
        	GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ZERO);
        }

        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y+0.5f, z);

        //f
        GlStateManager.rotate(lerpDegrees(entity.prevRotationYaw, entity.rotationYaw, entityYaw), 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-lerpDegrees(entity.prevRotationPitch, entity.rotationPitch, entityYaw), 1.0F, 0.0F, 0.0F);
        //        GL11.glRotatef(entity.getRoll(),0,0,1);


        float scale = 0.0045f;
        GlStateManager.scale(scale, scale, scale);
        GlStateManager.scale(0.5f, 0.5f, 1.0f);
//        float lifetime = entityPhantomSword.getLifeTime();
//        float ticks = entityPhantomSword.ticksExisted;
        BufferBuilder wr = tessellator.getBuffer();
        wr.begin(4, DefaultVertexFormats.POSITION_COLOR);

        int r = color >> 16 & 255;
        int g = color >> 8 & 255;
        int b = color & 255;

        double dScale = 1.0;
        for(int idx = 0; idx < nVecPos.length; idx++)
        {
            //tessellator.setColorRGBA_F(fScale, 1.0F, 1.0F, 0.2F + (float)idx*0.02F);
            wr.pos(dVec[nVecPos[idx][0]][0] * dScale, dVec[nVecPos[idx][0]][1] * dScale, dVec[nVecPos[idx][0]][2] * dScale).color(r,g,b,255).endVertex();
            wr.pos(dVec[nVecPos[idx][1]][0] * dScale, dVec[nVecPos[idx][1]][1] * dScale, dVec[nVecPos[idx][1]][2] * dScale).color(r,g,b,255).endVertex();
            wr.pos(dVec[nVecPos[idx][2]][0] * dScale, dVec[nVecPos[idx][2]][1] * dScale, dVec[nVecPos[idx][2]][2] * dScale).color(r,g,b,255).endVertex();
        }

        tessellator.draw();

        GlStateManager.popMatrix();
        GlStateManager.disableBlend();
//        GL11.glEnable(GL11.GL_LIGHTING);
//        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityDanmaku entity) {
		// TODO Auto-generated method stub
		return null;
	}

   

    float lerp(float start, float end, float percent){
        return (start + percent*(end - start));
    }

    float lerpDegrees(float start, float end, float percent){
        float diff = end - start;

        while (diff < -180.0F)
            diff += 360.0F;

        while (diff >= 180.0F)
            diff -= 360.0F;

        return start + percent * diff;
    }


}
