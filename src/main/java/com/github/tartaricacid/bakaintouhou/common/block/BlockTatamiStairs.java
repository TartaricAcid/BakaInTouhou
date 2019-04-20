package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.block.BlockStairs;

public class BlockTatamiStairs extends BlockStairs {
    public BlockTatamiStairs() {
        super(new BlockTatami().getDefaultState());
        setUnlocalizedName(BakaInTouhou.MOD_ID + "." + "tatami_stairs");
        setRegistryName("tatami_stairs");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }
}
