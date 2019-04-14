package com.github.tartaricacid.bakaintouhou.common.capability;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID)
public class CapabilityHandler {
    public static final ResourceLocation POWER_CAP = new ResourceLocation(BakaInTouhou.MOD_ID, "power");
    public static final ResourceLocation SCORE_CAP = new ResourceLocation(BakaInTouhou.MOD_ID, "score");

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) {
            return;
        }
        event.addCapability(POWER_CAP, new PowerProvider());
        event.addCapability(SCORE_CAP, new ScoreProvider());
    }

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
}
