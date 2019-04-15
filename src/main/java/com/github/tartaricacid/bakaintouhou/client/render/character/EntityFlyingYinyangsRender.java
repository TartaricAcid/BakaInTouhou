package com.github.tartaricacid.bakaintouhou.client.render.character;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.model.EntityFlyingYinyangsModel;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityFlyingYinyangs;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class EntityFlyingYinyangsRender extends RenderEntityTouhouCharacter<EntityFlyingYinyangs> {
    public static final Factory FACTORY = new Factory();
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/character/flying_yinyangs.png");

    public EntityFlyingYinyangsRender(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }

    @Override
    public void doRender(EntityFlyingYinyangs entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.enableBlend();

        GlStateManager.translate(x, y + 0.8, z);
        GlStateManager.scale(0.6, 0.6, 0.6);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, 0, 0, entity.ticksExisted + partialTicks, 0, 0, 0.0625F);

        GlStateManager.disableBlend();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFlyingYinyangs entity) {
        return resourceLocation;
    }

    @Override
    protected void preRenderCallback(EntityFlyingYinyangs entity, float partialTickTime) {
        GlStateManager.scale(1.5f, 1.5f, 1.5f);
    }

    public static class Factory implements IRenderFactory<EntityFlyingYinyangs> {
        @Override
        public Render<? super EntityFlyingYinyangs> createRenderFor(RenderManager manager) {
            return new EntityFlyingYinyangsRender(manager, new EntityFlyingYinyangsModel(), 0.5f);
        }
    }
}
