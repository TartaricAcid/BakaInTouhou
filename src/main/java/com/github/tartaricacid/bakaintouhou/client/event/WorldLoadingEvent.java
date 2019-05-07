package com.github.tartaricacid.bakaintouhou.client.event;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.gui.GuiTouhouLoading;
import com.github.tartaricacid.bakaintouhou.common.config.MainConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID, value = Side.CLIENT)
public class WorldLoadingEvent {
    private final Minecraft client = FMLClientHandler.instance().getClient();
    private int lastDimension = 0;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent evt) {
        if (evt.phase.equals(TickEvent.Phase.END) && evt.player == client.player)
            lastDimension = evt.player.dimension;
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiDownloadTerrain && client.player != null
                && (client.player.dimension == MainConfig.changeId.dimensionId || lastDimension == MainConfig.changeId.dimensionId)) {
            event.setGui(new GuiTouhouLoading());
        }
    }
}
