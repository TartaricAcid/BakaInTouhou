package com.github.tartaricacid.bakaintouhou.common.item;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemTouhouIcons;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemObjectHolder {
    public static final CreativeTabs bakaInTouhouTabs = new CreativeTabs("bakaintouhou.items") {
        @Override
        public ItemStack getTabIconItem() {
            return Items.APPLE.getDefaultInstance();
        }

        @Override
        public CreativeTabs setBackgroundImageName(String texture) {
            return super.setBackgroundImageName(texture);
        }
    };

    @GameRegistry.ObjectHolder(BakaInTouhou.MOD_ID + ":" + "danmaku")
    public static ItemDanmaku itemDanmaku;
    @GameRegistry.ObjectHolder(BakaInTouhou.MOD_ID + ":" + "touhou_icons")
    public static ItemTouhouIcons itemTouhouIcons;
}
