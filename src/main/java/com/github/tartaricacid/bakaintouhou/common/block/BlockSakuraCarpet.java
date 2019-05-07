package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;

public class BlockSakuraCarpet extends BlockCarpet {
    public BlockSakuraCarpet() {
        super();
        this.setRegistryName("sakura_carpet");
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".sakura_carpet");
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.PINK));
        this.setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, EnumDyeColor.PINK.getMetadata()));
        items.add(new ItemStack(this, 1, EnumDyeColor.RED.getMetadata()));
        items.add(new ItemStack(this, 1, EnumDyeColor.YELLOW.getMetadata()));
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
