package com.github.tartaricacid.bakaintouhou.common.block;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockObjectHolder {
    @GameRegistry.ObjectHolder(BakaInTouhou.MOD_ID + ":" + "saisen_bako")
    public static BlockSaisenBako blockSaisenBako;
}
