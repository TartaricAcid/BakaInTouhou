package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityMagicCircleModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEntityTouhouCharacter<T extends EntityTouhouCharacter> extends RenderLiving<T> {
    private static ModelBase mgaicCircle = new EntityMagicCircleModel();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/magic_circle.png");

    public RenderEntityTouhouCharacter(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        // 绘制魔法阵
        /*
        GlStateManager.pushMatrix();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
        GlStateManager.enableBlend();

        GlStateManager.translate(x, y + 0.01, z);
        GlStateManager.rotate(entity.ticksExisted * 4, 0, 1, 0);

        this.bindTexture(resourceLocation);
        mgaicCircle.render(entity, 0, 0, 0, 0, 0, 0.0625F);

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();*/
    }

    @Override
    protected void renderEntityName(T entityIn, double x, double y, double z, String name, double distanceSq) {
        super.renderLivingLabel(entityIn, entityIn.getName(), x, y, z, 20);
    }

    @Override
    protected boolean canRenderName(T entity) {
        return true;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return null;
    }
}
