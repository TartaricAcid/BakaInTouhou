package com.github.tartaricacid.bakaintouhou.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemLantern extends ItemBlock {
    public ItemLantern(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
