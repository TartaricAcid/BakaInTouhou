package com.github.tartaricacid.bakaintouhou.common.world;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TouhouGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (random.nextFloat() < 0.99f) {
            int x = chunkX * 16 + 6 + random.nextInt(2);
            int z = chunkZ * 16 + 6 + random.nextInt(2);
            int y = getGround(x, z, world);
            BlockPos blockPos = new BlockPos(x, y + 1, z);

            if (y > 0 && world.getBiome(blockPos) == Biomes.FOREST_HILLS) {
                PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE);
                Template templateTorii = world.getSaveHandler().getStructureTemplateManager().getTemplate(
                        world.getMinecraftServer(), new ResourceLocation(BakaInTouhou.MOD_ID, "torii"));
                Template templateShrine = world.getSaveHandler().getStructureTemplateManager().getTemplate(
                        world.getMinecraftServer(), new ResourceLocation(BakaInTouhou.MOD_ID, "shrine"));

                templateTorii.addBlocksToWorld(world, blockPos, settings);
                templateShrine.addBlocksToWorld(world, blockPos.add(-4, 0, 8), settings);
            }
        }
    }

    private int getGround(int x, int z, World world) {
        for (int y = world.getActualHeight(); y > 0; y--) {
            if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 2, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 3, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 4, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 5, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 6, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 7, y, z)).getBlock() == Blocks.GRASS &&
                    world.getBlockState(new BlockPos(x + 8, y, z)).getBlock() == Blocks.GRASS) {
                return y;
            }
        }
        return 0;
    }
}
