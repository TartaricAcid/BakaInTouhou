package com.github.tartaricacid.bakaintouhou.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenBamboo extends WorldGenAbstractTree {
    private final IBlockState wood;
    private final int height;

    public WorldGenBamboo(boolean notify, IBlockState wood, int height) {
        super(notify);
        this.wood = wood;
        this.height = height;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (worldIn.getBlockState(position.down()).getBlock() != Blocks.GRASS
                && worldIn.getBlockState(position.down()).getBlock() != Blocks.DIRT) {
            return false;
        }

        if (position.getY() >= 1 && position.getY() + height + 1 <= worldIn.getHeight()) {
            for (int i = position.getY(); i <= position.getY() + height + 1; ++i) {
                BlockPos pos = new BlockPos(position.getX(), i, position.getZ());
                if (worldIn.getBlockState(pos).getBlock().isAir(worldIn.getBlockState(pos), worldIn, pos)) {
                    this.setBlockAndNotifyAdequately(worldIn, pos, wood);
                } else {
                    break;
                }
            }
            return true;
        }
        return false;
    }
}
