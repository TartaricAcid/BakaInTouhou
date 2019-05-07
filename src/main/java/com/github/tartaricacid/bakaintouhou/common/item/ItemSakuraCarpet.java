package com.github.tartaricacid.bakaintouhou.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemSakuraCarpet extends ItemBlock {
    public ItemSakuraCarpet(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
