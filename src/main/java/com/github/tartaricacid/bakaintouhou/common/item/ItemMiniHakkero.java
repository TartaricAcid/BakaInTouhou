package com.github.tartaricacid.bakaintouhou.common.item;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMiniHakkero;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemMiniHakkero extends Item {
    public ItemMiniHakkero() {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".mini_hakkero");
        setRegistryName("mini_hakkero");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (!worldIn.isRemote && entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            EntityMiniHakkero entityMiniHakkero = new EntityMiniHakkero(worldIn, player);

            Vec3d star = new Vec3d(player.posX, player.posY + player.eyeHeight, player.posZ);
            Vec3d end = star.add(player.getLookVec().normalize().scale(64));

            if (worldIn.rayTraceBlocks(star, end) != null) {
                BlockPos pos = worldIn.rayTraceBlocks(star, end).getBlockPos();
                entityMiniHakkero.setPosition(pos.getX(), pos.getY(), pos.getZ());
                // worldIn.spawnEntity(entityMiniHakkero);
                // TODO：增加右键持续发射功能
            }
        }
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 500;
    }
}
