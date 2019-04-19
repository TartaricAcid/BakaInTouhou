package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLantern extends Block {
    public static final AxisAlignedBB AABB_A = new AxisAlignedBB(0.25d, 0d, 0.25d, 0.75d, 1d, 0.75d);
    public static final AxisAlignedBB AABB_B = new AxisAlignedBB(0.25d, 0d, 0.25d, 0.75d, 0.875d, 0.75d);
    public static final PropertyEnum<BlockLantern.EnumType> TYPE = PropertyEnum.create("type", BlockLantern.EnumType.class);

    public BlockLantern() {
        super(Material.GLASS);
        this.setRegistryName("lantern");
        this.setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "lantern");
        this.setHardness(1.0f);
        this.setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        this.setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumType.A));
        this.setLightLevel(1);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, EnumType.A.getMeta()));
        items.add(new ItemStack(this, 1, EnumType.B.getMeta()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        switch (meta) {
            case 0:
            default:
                return getDefaultState().withProperty(TYPE, EnumType.A);
            case 1:
                return getDefaultState().withProperty(TYPE, EnumType.B);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).getMeta();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(TYPE)) {
            case A:
            default:
                return AABB_A;
            case B:
                return AABB_B;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    public enum EnumType implements IStringSerializable {
        A("a", 0),
        B("b", 1);

        private final String name;
        private final int meta;

        EnumType(String name, int meta) {
            this.name = name;
            this.meta = meta;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getMeta() {
            return meta;
        }
    }
}
