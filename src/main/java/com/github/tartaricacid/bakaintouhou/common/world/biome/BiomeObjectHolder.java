package com.github.tartaricacid.bakaintouhou.common.world.biome;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BiomeObjectHolder {
    @GameRegistry.ObjectHolder(BakaInTouhou.MOD_ID + ":" + "bamboo_biome")
    public static BambooBiome bambooBiome;

    public static void initBiomeManagerAndDictionary() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(bambooBiome, 10));
        BiomeManager.addSpawnBiome(bambooBiome);
        BiomeDictionary.addTypes(bambooBiome,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.WET,
                BiomeDictionary.Type.MAGICAL);
    }
}
