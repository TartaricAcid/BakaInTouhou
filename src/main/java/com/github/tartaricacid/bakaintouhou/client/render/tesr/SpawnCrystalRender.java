package com.github.tartaricacid.bakaintouhou.client.render.tesr;

import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntitySpawnCrystal;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityMarisa;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class SpawnCrystalRender extends TileEntitySpecialRenderer<TileEntitySpawnCrystal> {
    @Override
    public void render(TileEntitySpawnCrystal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);

        final Entity entity = EntityList.createEntityByIDFromName(new ResourceLocation(te.getCharacter()), getWorld());

        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y + 0.0625, z);
        GlStateManager.scale(0.4, 0.4, 0.4);
        GlStateManager.translate(1.2, 1.4 + 0.2 * Math.cos(0.05 * (this.getWorld().getWorldTime() + partialTicks))
                , 1.2);
        GlStateManager.rotate(this.getWorld().getWorldTime() * 2, 0, 1, 0);

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        Minecraft.getMinecraft().getRenderManager().renderEntity(entity == null ? new EntityMarisa(getWorld()) : entity,
                0, 0, 0, 0, 0, false);
        GlStateManager.popMatrix();
    }
}
