package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class BlockSakuraLeaf extends BlockLeaves {
    private final String color;

    public BlockSakuraLeaf(String color) {
        this.setRegistryName("sakura_leaf_" + color);
        this.setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "sakura_leaf_" + color);
        this.color = color;
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(CHECK_DECAY, Boolean.valueOf(true))
                .withProperty(DECAYABLE, Boolean.valueOf(true)));
        this.setGraphicsLevel(true);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        switch (color) {
            case "red":
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingRed);
            case "yellow":
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingYellow);
            default:
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingPink);
        }
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        switch (color) {
            case "red":
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingRed).getDefaultInstance();
            case "yellow":
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingYellow).getDefaultInstance();
            default:
                return Item.getItemFromBlock(BlockObjectHolder.blockSakuraSaplingPink).getDefaultInstance();
        }
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 1) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 2) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (!state.getValue(DECAYABLE)) {
            i |= 1;
        }
        if (state.getValue(CHECK_DECAY)) {
            i |= 2;
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE});
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
    }
}
