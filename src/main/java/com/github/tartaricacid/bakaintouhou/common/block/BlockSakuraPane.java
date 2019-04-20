package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSakuraPane extends BlockPane {
    public BlockSakuraPane(String color) {
        super(Material.LEAVES, true);
        this.setRegistryName("sakura_pane_" + color);
        this.setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "sakura_pane_" + color);
        this.setHardness(0.2F);
        this.setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        this.setSoundType(SoundType.PLANT);
    }
}
