package com.github.tartaricacid.bakaintouhou.common.network.handler;

import com.github.tartaricacid.bakaintouhou.client.network.message.GoheiChangeMessage;
import com.github.tartaricacid.bakaintouhou.common.item.ItemHakureiGohei;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuInit;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class GoheiChangeMessageHandler implements IMessageHandler<GoheiChangeMessage, IMessage> {
    @Override
    public IMessage onMessage(GoheiChangeMessage message, MessageContext ctx) {
        if (ctx.side == Side.SERVER) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> {
                EntityPlayerMP player = ctx.getServerHandler().player;
                ItemStack stack = player.getHeldItemMainhand();
                ItemHakureiGohei item = ItemObjectHolder.itemHakureiGohei;
                if (stack.getItem() == item) {
                    item.setGoheiMode(stack, (item.getGoheiMode(stack) + 1 > DanmakuInit.danmakuTypeMax) ? 0 : item.getGoheiMode(stack) + 1);
                }
            });
        }
        return null;
    }
}
