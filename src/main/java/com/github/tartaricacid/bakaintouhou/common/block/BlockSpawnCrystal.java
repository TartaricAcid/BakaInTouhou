package com.github.tartaricacid.bakaintouhou.common.block;


import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntitySpawnCrystal;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockSpawnCrystal extends Block implements ITileEntityProvider {
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.15D, 0.0D, 0.15D, 0.85D, 2D, 0.85D);

    public BlockSpawnCrystal() {
        super(Material.GLASS);
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "spawn_crystal");
        setBlockUnbreakable();
        this.setResistance(6000001.0F);
        setRegistryName("spawn_crystal");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setLightLevel(1);
        setSoundType(SoundType.GLASS);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            Minecraft mc = Minecraft.getMinecraft();
            mc.ingameGUI.displayTitle("そーなのかー", null, 5, 40, 5);
            return true;
        } else {
            // TODO
        }
        return false;
    }

    private ItemStack getDefaultItemStack() {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        getTagCompoundSafe(stack).setString("character", "bakaintouhou:entity.character.reimu");
        return stack;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        ItemStack stack = Item.getItemFromBlock(this).getDefaultInstance();
        TileEntitySpawnCrystal te = (TileEntitySpawnCrystal) world.getTileEntity(pos);
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

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntitySpawnCrystal();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (!worldIn.isRemote) {
            TileEntitySpawnCrystal te = (TileEntitySpawnCrystal) worldIn.getTileEntity(pos);
            if (te != null) {
                te.setCharacter(getTagCompoundSafe(stack).getString("character"));
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
        tooltip.add(I18n.format("bakaintouhou.spawn_crystal.tooltips.character",
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

    @Override
    public boolean isFullCube(IBlockState state) {
        // 否则玩家会卡死在方块里面窒息
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = (double) ((float) pos.getX() + rand.nextFloat());
        double d1 = (double) ((float) pos.getY() + 2 * rand.nextFloat());
        double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
        worldIn.spawnParticle(EnumParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
