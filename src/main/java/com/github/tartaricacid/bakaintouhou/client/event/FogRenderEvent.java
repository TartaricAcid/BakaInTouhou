package com.github.tartaricacid.bakaintouhou.client.event;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.world.biome.BiomeObjectHolder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID, value = Side.CLIENT)
public class FogRenderEvent {
    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if (player.getEntityWorld().getBiome(player.getPosition()) == BiomeObjectHolder.bambooBiome) {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
                GlStateManager.setFogEnd(event.getFarPlaneDistance());
                GlStateManager.setFogStart(3f);
                GlStateManager.setFogDensity(0.07f);
            }
        }
    }

    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.FogColors event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if (player.getEntityWorld().getBiome(player.getPosition()) == BiomeObjectHolder.bambooBiome) {
                event.setRed(0.1f);
                event.setBlue(0.1f);
                event.setGreen(0.1f);
            }
        }
    }
}
