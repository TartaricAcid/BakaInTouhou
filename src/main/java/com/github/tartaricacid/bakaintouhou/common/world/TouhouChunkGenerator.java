package com.github.tartaricacid.bakaintouhou.common.world;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class TouhouChunkGenerator extends ChunkGeneratorOverworld {
    public TouhouChunkGenerator(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions) {
        super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
    }
}
