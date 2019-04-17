package com.github.tartaricacid.bakaintouhou.common.event;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import com.github.tartaricacid.bakaintouhou.common.network.message.PointMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID)
public class PointEvent {
    private static final ResourceLocation POWER_CAP = new ResourceLocation(BakaInTouhou.MOD_ID, "power");
    private static final ResourceLocation SCORE_CAP = new ResourceLocation(BakaInTouhou.MOD_ID, "score");

    /**
     * 附加 Capability 属性
     */
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) {
            return;
        }
        event.addCapability(POWER_CAP, new PowerProvider());
        event.addCapability(SCORE_CAP, new ScoreProvider());
    }

    /**
     * 玩家跨越维度或者死亡时的属性变化
     */
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();

        IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
        IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);
        IPower oldPower = event.getOriginal().getCapability(PowerProvider.POWER_CAP, null);
        IScore oldScore = event.getOriginal().getCapability(ScoreProvider.SCORE_CAP, null);

        // 依据死亡或者切换维度进行不同的处理
        // 死亡 Power 减一
        if (event.isWasDeath()) {
            power.set((oldPower.get() > 1.0f) ? (oldPower.get() - 1.0f) : 0.0f);
            score.set(oldScore.get());
        } else {
            power.set(oldPower.get());
            score.set(oldScore.get());
        }
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
            CommonProxy.INSTANCE.sendTo(new PointMessage(score.get(), power.get()), (EntityPlayerMP) player);
        }
    }

    /**
     * 击杀生物时获取相关点数
     */
    @SubscribeEvent
    public static void killTouhouCharacter(LivingDeathEvent event) {
        if (!event.getEntityLiving().getEntityWorld().isRemote &&
                event.getEntityLiving() instanceof EntityTouhouCharacter &&
                event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityTouhouCharacter touhou = (EntityTouhouCharacter) event.getEntityLiving();
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();

            IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
            IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);

            power.add(touhou.getPowerPoint());
            score.add(touhou.getScorePoint());
        }
    }
}
