package com.github.tartaricacid.bakaintouhou.common.world;

import com.github.tartaricacid.bakaintouhou.common.world.biome.BiomeObjectHolder;
import net.minecraft.world.biome.BiomeProviderSingle;

public class TouhouBiomeProvider extends BiomeProviderSingle {
    public TouhouBiomeProvider() {
        super(BiomeObjectHolder.bambooBiome);
    }
}
