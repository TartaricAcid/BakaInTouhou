package com.github.tartaricacid.bakaintouhou.common.item;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityDanmaku;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuInit;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemHakureiGohei extends Item {
    private static Random random = new Random();

    public ItemHakureiGohei() {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".hakurei_gohei");
        setRegistryName("hakurei_gohei");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
        setMaxStackSize(1);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (!worldIn.isRemote && entityLiving instanceof EntityPlayer && !entityLiving.isSneaking()) {
            EntityPlayer player = (EntityPlayer) entityLiving;

            int a = ((500 - timeLeft) > 100 ? 100 : (500 - timeLeft)) / 20; // 依据右键时长来决定后面的伤害和速度（0-5s）

            int damage = a + 4;
            float velocity = 0.3f * (a + 1);
            int color = random.nextInt(DanmakuInit.danmakuColorMax + 1);
            int type = getGoheiMode(stack);

            EntityDanmaku danmaku = new EntityDanmaku(worldIn, player, damage, 0, type, color);
            Vec3d v = player.getLookVec();
            danmaku.shoot(v.x, v.y, v.z, velocity, 5f);
            worldIn.spawnEntity(danmaku);
            worldIn.playSound(null, player.posX, player.posY, player.posZ,
                    SoundEvents.ENTITY_SNOWBALL_THROW, player.getSoundCategory(), 1.0f, 0.8f);
            player.getCooldownTracker().setCooldown(this, 10);
        }
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        getTagCompoundSafe(itemStack).setInteger("gohei_mode", 0);
        return itemStack;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(getDefaultInstance());
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 500;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            if (playerIn.isSneaking()) {
                ItemStack stack = playerIn.getHeldItemMainhand();
                setGoheiMode(stack, (getGoheiMode(stack) + 1 > DanmakuInit.danmakuTypeMax) ? 0 : getGoheiMode(stack) + 1);
            } else {
                playerIn.setActiveHand(handIn);
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    private int getGoheiMode(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("gohei_mode");
    }

    private void setGoheiMode(ItemStack stack, int mode) {
        getTagCompoundSafe(stack).setInteger("gohei_mode", mode);
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("item.bakaintouhou.hakurei_gohei.mode",
                I18n.format("bakaintouhou.danmaku.type_name." + getGoheiMode(stack))));
    }
}
