package com.github.tartaricacid.bakaintouhou.common.network;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.network.PointMessageHandler;
import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID)
public class PointPackHandler {
    public static SimpleNetworkWrapper INSTANCE = null;
    private static int packetId = 0;

    public PointPackHandler() {
    }

    /**
     * 此静态方法仅仅为了方便构建不重复的发包 ID
     */
    private static int nextID() {
        return packetId++;
    }

    public static void registerMessages(String channelName) {
        // 通过 NetworkRegistry.INSTANCE.newSimpleChannel 方法创建出 SimpleNetworkWrapper 实例
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);

        // 发包注册
        INSTANCE.registerMessage(PointMessageHandler.class, PointMessage.class, nextID(), Side.CLIENT);
    }

    /**
     * 同步客户端服务端数据
     */
    @SubscribeEvent
    public static void playerTickEvent(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;

        IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
        IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);

        if (event.side == Side.SERVER) {
            PointPackHandler.INSTANCE.sendTo(new PointMessage(score.get(), power.get()), (EntityPlayerMP) player);
        }
    }
}
