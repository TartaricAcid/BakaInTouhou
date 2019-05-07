package com.github.tartaricacid.bakaintouhou.common.config;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraftforge.common.config.Config;

@Config(modid = BakaInTouhou.MOD_ID, name = "BakaInTouhou")
public class MainConfig {
    @Config.Name("ChangeID")
    @Config.LangKey("config.bakaintouhou.change_id.name")
    @Config.RequiresMcRestart
    public static ChangeId changeId = new ChangeId();

    public static class ChangeId {
        @Config.Name("DimensionID")
        @Config.LangKey("config.bakaintouhou.dimension_id.name")
        @Config.RequiresMcRestart
        public int dimensionId = 9;

        @Config.Name("SakuraParticleID")
        @Config.LangKey("config.bakaintouhou.sakura_particle_id.name")
        @Config.RequiresMcRestart
        public int sakuraParticleId = 99;
    }
}
