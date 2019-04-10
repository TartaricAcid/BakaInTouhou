package com.github.tartaricacid.bakaintouhou.common.item.danmaku;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityHakureDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuInit;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemDanmaku extends Item {
    private static Random random = new Random();

    public ItemDanmaku() {
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".danmaku");
        setRegistryName("danmaku");
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            if (playerIn.isSneaking()) {
                setDanmakuType(stack, (getDanmakuType(stack) + 1 > DanmakuInit.danmakuTypeMax) ? 0 : getDanmakuType(stack) + 1);
            } else {
                //EntityNormalDanmaku entityNormalDanmaku = new EntityNormalDanmaku(worldIn, playerIn, getDanmakuDamage(stack), getDanmakuGravity(stack), getDanmakuType(stack), getDanmakuColor(stack));
                //EntityLaserDanmaku entityNormalDanmaku = new EntityLaserDanmaku(worldIn, playerIn, 5, 0f, 0xff_00_ff, 3f);
                //EntityButterflyDanmaku entityNormalDanmaku = new EntityButterflyDanmaku(worldIn, playerIn, 5, 0f, 0xff_00_00);
                //EntityKnifeDanmaku entityNormalDanmaku = new EntityKnifeDanmaku(worldIn, playerIn, 5, 0f, 1);
                //EntityTrainDanmaku entityNormalDanmaku = new EntityTrainDanmaku(worldIn, playerIn, 5, 0f, 5f);
                EntityHakureDanmaku entityNormalDanmaku = new EntityHakureDanmaku(worldIn, playerIn, 1, 0);
                Vec3d v = playerIn.getLookVec();
                entityNormalDanmaku.shoot(v.x, v.y, v.z, 0.1f, 0f);
                worldIn.spawnEntity(entityNormalDanmaku);
                worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, playerIn.getSoundCategory(),
                        1.0f, 0.8f);
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        getTagCompoundSafe(itemStack).setInteger("danmaku_type", 0);
        getTagCompoundSafe(itemStack).setInteger("danmaku_color", 0);
        getTagCompoundSafe(itemStack).setInteger("danmaku_damage", 1);
        getTagCompoundSafe(itemStack).setFloat("danmaku_gravity", 0.001f);
        return itemStack;
    }

    // 为标签页所添加的物品
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(getDefaultInstance());
        }
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    public boolean hasDanmakuColor(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("danmaku_color");
    }

    public int getDanmakuColor(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("danmaku_color");
    }

    public ItemStack setDanmakuColor(ItemStack stack, int color) {
        getTagCompoundSafe(stack).setInteger("danmaku_color", color);
        return stack;
    }

    public boolean hasDanmakuDamage(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("danmaku_damage");
    }

    public int getDanmakuDamage(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("danmaku_damage");
    }

    public ItemStack setDanmakuDamage(ItemStack stack, int damage) {
        getTagCompoundSafe(stack).setInteger("danmaku_damage", damage);
        return stack;
    }

    public boolean hasDanmakuGravity(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("danmaku_gravity");
    }

    public float getDanmakuGravity(ItemStack stack) {
        return getTagCompoundSafe(stack).getFloat("danmaku_gravity");
    }

    public ItemStack setDanmakuGravity(ItemStack stack, float gravity) {
        getTagCompoundSafe(stack).setFloat("danmaku_gravity", gravity);
        return stack;
    }

    public boolean hasDanmakuType(ItemStack stack) {
        return getTagCompoundSafe(stack).hasKey("danmaku_type");
    }

    public int getDanmakuType(ItemStack stack) {
        return getTagCompoundSafe(stack).getInteger("danmaku_type");
    }

    public ItemStack setDanmakuType(ItemStack stack, int type) {
        getTagCompoundSafe(stack).setInteger("danmaku_type", type);
        return stack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format(BakaInTouhou.MOD_ID + ".danmaku.tooltips.type",
                I18n.format(BakaInTouhou.MOD_ID + ".danmaku.type_name." + getDanmakuType(stack))));
        tooltip.add(I18n.format(BakaInTouhou.MOD_ID + ".danmaku.tooltips.color",
                I18n.format(BakaInTouhou.MOD_ID + ".danmaku.color_name." + getDanmakuColor(stack))));
        tooltip.add(I18n.format(BakaInTouhou.MOD_ID + ".danmaku.tooltips.damage", getDanmakuDamage(stack)));
        tooltip.add(I18n.format(BakaInTouhou.MOD_ID + ".danmaku.tooltips.gravity", getDanmakuGravity(stack)));
    }
}
