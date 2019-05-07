package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.world.gen.WorldGenBigTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BlockSakuraSapling extends BlockBush implements IGrowable {
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    private final String color;

    public BlockSakuraSapling(String color) {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".sakura_sapling_" + color);
        setRegistryName("sakura_sapling_" + color);
        this.color = color;
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setHardness(0.1F);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);
            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
                grow(worldIn, rand, pos, state);
            }
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
            return;
        }

        IBlockState wood = BlockObjectHolder.blockSakuraLog.getDefaultState();
        IBlockState leaf;
        WorldGenAbstractTree worldgenerator;

        switch (this.color) {
            case "red":
                leaf = BlockObjectHolder.blockSakuraLeafRed.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
                break;
            case "yellow":
                leaf = BlockObjectHolder.blockSakuraLeafYellow.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
                break;
            default:
                leaf = BlockObjectHolder.blockSakuraLeafPink.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
        }

        if (rand.nextInt(5) == 0) {
            worldgenerator = new WorldGenBigTree(true, leaf, wood);
        } else {
            worldgenerator = new WorldGenTrees(true, 4 + rand.nextInt(2), wood, leaf, false);
        }
        worldIn.setBlockToAir(pos);
        worldgenerator.generate(worldIn, rand, pos);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (state.getValue(STAGE).intValue() == 0) {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        } else {
            generateTree(worldIn, pos, state, rand);
        }
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return worldIn.rand.nextFloat() < 0.45d;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | state.getValue(STAGE).intValue() << 3;
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{STAGE});
    }
}
