package com.github.tartaricacid.bakaintouhou.common.block;


import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityGarageKit;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockGarageKit extends Block implements ITileEntityProvider {
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1D, 0.75D);

    public BlockGarageKit() {
        super(Material.CLAY);
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "garage_kit");
        setHardness(0.5f);
        setRegistryName("garage_kit");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }

    private ItemStack getDefaultItemStack() {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        getTagCompoundSafe(stack).setString("character", "bakaintouhou:entity.character.reimu");
        return stack;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        TileEntityGarageKit te = (TileEntityGarageKit) world.getTileEntity(pos);
        if (te != null) {
            getTagCompoundSafe(stack).setString("character", te.getCharacter());
        } else {
            getTagCompoundSafe(stack).setString("character", "bakaintouhou:entity.character.reimu");
        }
        return stack;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BLOCK_AABB;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (ResourceLocation res : EntityList.getEntityNameList()) {
            if (res.getResourceDomain().equals(BakaInTouhou.MOD_ID) && res.getResourcePath().indexOf("entity.character") == 0) {
                items.add(getItemStackWithCharacter(res.toString()));
            }
        }
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        ItemStack stack = getDefaultItemStack();
        TileEntityGarageKit te = (TileEntityGarageKit) worldIn.getTileEntity(pos);
        if (te != null) {
            getTagCompoundSafe(stack).setString("character", te.getCharacter());
        } else {
            getTagCompoundSafe(stack).setString("character", "bakaintouhou:entity.character.reimu");
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
        return new TileEntityGarageKit();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (!worldIn.isRemote) {
            TileEntityGarageKit te = (TileEntityGarageKit) worldIn.getTileEntity(pos);
            if (te != null) {
                te.setCharacter(getTagCompoundSafe(stack).getString("character"));
                te.setFacing(EnumFacing.getDirectionFromEntityLiving(pos, placer));
            }
        }
    }

    private ItemStack getItemStackWithCharacter(String name) {
        ItemStack stack = getDefaultItemStack();
        getTagCompoundSafe(stack).setString("character", name);
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
        tooltip.add(I18n.format("bakaintouhou.garage_kit.tooltips.character",
                I18n.format("entity." + EntityList.getTranslationName(new ResourceLocation(
                        getTagCompoundSafe(stack).getString("character"))) + ".name")));
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
}
