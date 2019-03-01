package com.github.tartaricacid.bakaintouhou.common.item.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ItemTouhouIcons extends Item {
    public ItemTouhouIcons() {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".touhou_icons");
        setRegistryName("touhou_icons");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        getTagCompoundSafe(itemStack).setInteger("icons_type", 0);
        return itemStack;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(this.getDefaultInstance());
            items.add(setIconsType(this.getDefaultInstance(), 1));
            items.add(setIconsType(this.getDefaultInstance(), 2));
            items.add(setIconsType(this.getDefaultInstance(), 3));
        }
    }

    public int getIconsType(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("icons_type");
    }

    private ItemStack setIconsType(ItemStack stack, int type) {
        getTagCompoundSafe(stack).setInteger("icons_type", type);
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
}
