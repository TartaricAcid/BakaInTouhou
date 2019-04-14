package com.github.tartaricacid.bakaintouhou.common.event;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID)
public class GetPointEvent {
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
