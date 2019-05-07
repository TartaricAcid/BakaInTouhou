package com.github.tartaricacid.bakaintouhou.common.world.biome;

import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.entity.character.*;
import com.github.tartaricacid.bakaintouhou.common.world.gen.WorldGenBamboo;
import com.github.tartaricacid.bakaintouhou.common.world.gen.WorldGenBigTree;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class BambooBiome extends Biome {
    public BambooBiome(Biome.BiomeProperties properties) {
        super(properties);

        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.clear();

        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityFairyRed.class, 5, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityFairyYellow.class, 5, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityFairyBlue.class, 5, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityFairyGreen.class, 5, 2, 6));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityFlyingYinyangs.class, 50, 2, 4));

        this.decorator.treesPerChunk = 30;
        this.decorator.grassPerChunk = 10;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if (rand.nextFloat() < 0.01) {
            IBlockState leaf;
            IBlockState wood = BlockObjectHolder.blockSakuraLog.getDefaultState();

            switch (rand.nextInt(3)) {
                case 0:
                    leaf = BlockObjectHolder.blockSakuraLeafRed.getDefaultState();
                    break;
                case 1:
                    leaf = BlockObjectHolder.blockSakuraLeafYellow.getDefaultState();
                    break;
                default:
                    leaf = BlockObjectHolder.blockSakuraLeafPink.getDefaultState();
                    break;
            }

            if (rand.nextInt(5) == 0) {
                return new WorldGenBigTree(false, leaf, wood);
            } else {
                return new WorldGenTrees(false, 4 + rand.nextInt(2), wood, leaf, false);
            }
        } else {
            return new WorldGenBamboo(false, BlockObjectHolder.blockBamboo.getDefaultState(), 8 + rand.nextInt(6));
        }
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        if (rand.nextFloat() < 0.5f)
            return new WorldGenBush(BlockObjectHolder.blockBambooShoot);
        else {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
        }
    }
}
