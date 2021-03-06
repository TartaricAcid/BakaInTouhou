package com.github.tartaricacid.bakaintouhou.common.item;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.armor.ReimuHeaddressModel;
import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemReimuHeaddress extends ItemArmor {
    private static ResourceLocation resourceLocation = new ResourceLocation(BakaInTouhou.MOD_ID,
            "textures/entity/character/reimu.png");

    public ItemReimuHeaddress() {
        super(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(BakaInTouhou.MOD_ID + ".reimu_headdress");
        setRegistryName("reimu_headdress");
        setMaxStackSize(1);
        setCreativeTab(ItemObjectHolder.bakaInTouhouTabs);
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ReimuHeaddressModel getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        return new ReimuHeaddressModel();
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return resourceLocation.toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
        IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
        IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);

        Minecraft.getMinecraft().ingameGUI.drawString(Minecraft.getMinecraft().fontRenderer
                , String.format("Power: %.2f", power.get()), 5, 5, 0xffffff);
        Minecraft.getMinecraft().ingameGUI.drawString(Minecraft.getMinecraft().fontRenderer
                , String.format("Score: %.2f", score.get()), 5, 15, 0xffffff);
    }
}
