package com.github.tartaricacid.bakaintouhou.client.network;

import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import com.github.tartaricacid.bakaintouhou.common.network.PointMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PointMessageHandler implements IMessageHandler<PointMessage, IMessage> {
    @Override
    public IMessage onMessage(PointMessage message, MessageContext ctx) {
        if (ctx.side == Side.CLIENT) {
            // 将 Netty IO 线程任务添加到客户端主线程任务处，进行处理
            Minecraft.getMinecraft().addScheduledTask(() -> handle(message));
        }
        return null;
    }

    private void handle(PointMessage message) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
        IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);

        power.set(message.getPower());
        score.set(message.getScore());
    }
}
