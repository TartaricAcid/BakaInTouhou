package com.github.tartaricacid.bakaintouhou.client.render.tesr;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.tesr.model.ShojiModel;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityShoji;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class ShojiRender extends TileEntitySpecialRenderer<TileEntityShoji> {
    private final ShojiModel model = new ShojiModel();

    @Override
    public void render(TileEntityShoji te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        final ResourceLocation resource = new ResourceLocation(BakaInTouhou.MOD_ID,
                "textures/entity/block/shoji_type_" + te.getType() + ".png");
        final EnumFacing facing = te.getFacing();
        this.bindTexture(resource);

        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y, z + 0.5);
        GlStateManager.scale(0.0625, 0.0625, 0.0625);
        GlStateManager.rotate(90, 0, 1, 0);
        switch (facing) {
            case NORTH:
            default:
                GlStateManager.rotate(180, 0, 1, 0);
                break;
            case SOUTH:
                break;
            case EAST:
                GlStateManager.rotate(90, 0, 1, 0);
                break;
            case WEST:
                GlStateManager.rotate(270, 0, 1, 0);
                break;
        }
        model.render(1.0f);
        GlStateManager.popMatrix();
    }
}
