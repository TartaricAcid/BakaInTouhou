package com.github.tartaricacid.bakaintouhou.client.render.tesr;

import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityGarageKit;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMarisa;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class GarageKitRender extends TileEntitySpecialRenderer<TileEntityGarageKit> {
    @Override
    public void render(TileEntityGarageKit te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);

        final Entity entity = EntityList.createEntityByIDFromName(new ResourceLocation(te.getCharacter()), getWorld());
        final EnumFacing facing = te.getFacing();

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y + 0.0625, z);
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.translate(1, 0, 1);

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

        Minecraft.getMinecraft().getRenderManager().renderEntity(entity == null ? new EntityMarisa(getWorld()) : entity,
                0, 0, 0, 0, 0, false);
        GlStateManager.popMatrix();
    }
}
