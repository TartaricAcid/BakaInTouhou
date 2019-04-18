package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTatamiSlab extends BlockSlab {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);

    public BlockTatamiSlab() {
        super(Material.CLOTH);
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "tatami_slab");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setSoundType(SoundType.CLOTH);
        setHardness(1.0f);
        IBlockState iblockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT)
                .withProperty(FACING, EnumFacing.NORTH);
        if (!this.isDouble()) {
            iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(iblockstate);
        this.useNeighborBrightness = !this.isDouble();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState blockstate = this.blockState.getBaseState();
        if (!this.isDouble()) {
            blockstate = blockstate.withProperty(HALF, ((meta & 7) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM)
                    .withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(VARIANT, Variant.DEFAULT);
        }
        return blockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = 0;
        if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) {
            meta |= 7;
        }
        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if (!this.isDouble()) {
            return new BlockStateContainer(this, new IProperty[]{VARIANT, HALF, FACING});
        }
        return new BlockStateContainer(this, new IProperty[]{VARIANT, FACING});
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return Variant.DEFAULT;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockObjectHolder.blockTatamiSlabHalf);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(BlockObjectHolder.blockTatamiSlabHalf);
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    public static enum Variant implements IStringSerializable {
        DEFAULT;

        @Override
        public String getName() {
            return "default";
        }
    }

    public static class Double extends BlockTatamiSlab {
        public Double() {
            super();
            setRegistryName("tatami_slab_double");
        }

        @Override
        public boolean isDouble() {
            return true;
        }
    }

    public static class Half extends BlockTatamiSlab {
        public Half() {
            super();
            setRegistryName("tatami_slab_half");
        }

        @Override
        public boolean isDouble() {
            return false;
        }
    }
}
