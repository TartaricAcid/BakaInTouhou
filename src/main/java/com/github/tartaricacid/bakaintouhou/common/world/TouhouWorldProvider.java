package com.github.tartaricacid.bakaintouhou.common.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;

public class TouhouWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.OVERWORLD;
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return "touhou";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), world.getWorldInfo().getGeneratorOptions());
    }
}
