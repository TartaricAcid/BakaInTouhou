package com.github.tartaricacid.bakaintouhou.common.block;


import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityShoji;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockShoji extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.4375D, 0.0D, 0D, 0.5625D, 2D, 1D);
    public static final AxisAlignedBB BLOCK_AABB_ROTATE = new AxisAlignedBB(0D, 0.0D, 0.4375D, 1D, 2D, 0.5625D);

    public BlockShoji() {
        super(Material.WOOD);
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "shoji");
        setHardness(0.5f);
        setRegistryName("shoji");
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }

    private ItemStack getDefaultItemStack() {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        getTagCompoundSafe(stack).setInteger("type", 0);
        return stack;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        TileEntityShoji te = (TileEntityShoji) world.getTileEntity(pos);
        if (te != null) {
            getTagCompoundSafe(stack).setInteger("type", te.getType());
        } else {
            getTagCompoundSafe(stack).setInteger("type", 0);
        }
        return stack;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(FACING) == EnumFacing.SOUTH || state.getValue(FACING) == EnumFacing.NORTH) {
            return BLOCK_AABB_ROTATE;
        } else {
            return BLOCK_AABB;
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(getItemStackWithType(0));
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        ItemStack stack = getDefaultItemStack();
        TileEntityShoji te = (TileEntityShoji) worldIn.getTileEntity(pos);
        if (te != null) {
            getTagCompoundSafe(stack).setInteger("type", te.getType());
        } else {
            getTagCompoundSafe(stack).setInteger("type", 0);
        }
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack));
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        // 需要留空
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityShoji();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
        if (!worldIn.isRemote) {
            TileEntityShoji te = (TileEntityShoji) worldIn.getTileEntity(pos);
            if (te != null) {
                te.setType(getTagCompoundSafe(stack).getInteger("type"));
                te.setFacing(EnumFacing.getDirectionFromEntityLiving(pos, placer));
                te.setOpen(false);
            }
        }
    }

    private ItemStack getItemStackWithType(int type) {
        ItemStack stack = getDefaultItemStack();
        getTagCompoundSafe(stack).setInteger("type", type);
        return stack;
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("bakaintouhou.shoji.tooltips.type.", getTagCompoundSafe(stack).getInteger("type")));
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

    @Override
    public boolean isFullCube(IBlockState state) {
        // 否则玩家会卡死在方块里面窒息
        return false;
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }
}
