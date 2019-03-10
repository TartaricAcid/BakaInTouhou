package com.github.tartaricacid.bakaintouhou.common.item;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMarisaBroom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMarisaBroom extends Item {
    public ItemMarisaBroom() {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".marisa_broom");
        setRegistryName("marisa_broom");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && player.isSneaking() && facing == EnumFacing.UP) {
            EntityMarisaBroom broom = new EntityMarisaBroom(worldIn);
            broom.setPosition(pos.getX(), pos.up().getY(), pos.getZ());
            player.getHeldItem(hand).shrink(1);
            worldIn.spawnEntity(broom);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
