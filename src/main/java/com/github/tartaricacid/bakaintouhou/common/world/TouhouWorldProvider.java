package com.github.tartaricacid.bakaintouhou.common.world;

import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;

public class TouhouWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return CommonProxy.touhou;
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return super.getSaveFolder();
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new TouhouChunkGenerator(world, super.getSeed(), false, "");
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return new TouhouBiomeProvider();
    }
}
