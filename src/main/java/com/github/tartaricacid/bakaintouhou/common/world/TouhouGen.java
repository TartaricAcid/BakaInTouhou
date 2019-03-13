package com.github.tartaricacid.bakaintouhou.common.world;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraft.init.Biomes;
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
        if (random.nextFloat() < 0.50f) {
            int x = chunkX * 16;
            int z = chunkZ * 16;
            int y = chunkProvider.getLoadedChunk(chunkX, chunkZ).getLowestHeight();
            BlockPos blockPos = new BlockPos(x, y, z).up();

            if (chunkX % 2 == 0 && chunkZ % 2 == 0 // 判定区块为偶数
                    && y > 0 && world.getBiome(blockPos) == Biomes.FOREST_HILLS) {
                PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE);
                Template templateShrine = world.getSaveHandler().getStructureTemplateManager().getTemplate(
                        world.getMinecraftServer(), new ResourceLocation(BakaInTouhou.MOD_ID, "shrine"));

                templateShrine.addBlocksToWorld(world, blockPos, settings);

                /*
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = y; k > 0; k--) {
                            BlockPos pos = new BlockPos(i, k, j);
                            if (world.isAirBlock(pos)) {
                                world.setBlockState(pos, Blocks.DIRT.getDefaultState());
                            } else {
                                break;
                            }
                        }
                    }
                }*/
            }
        }
    }
}
