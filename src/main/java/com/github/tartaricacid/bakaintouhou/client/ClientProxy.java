package com.github.tartaricacid.bakaintouhou.client;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.render.character.*;
import com.github.tartaricacid.bakaintouhou.client.render.danmaku.*;
import com.github.tartaricacid.bakaintouhou.client.render.item.EntityMarisaBroomRender;
import com.github.tartaricacid.bakaintouhou.client.render.item.EntityMiniHakkeroRender;
import com.github.tartaricacid.bakaintouhou.client.render.tesr.GarageKitRender;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityGarageKit;
import com.github.tartaricacid.bakaintouhou.common.entity.character.*;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.*;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMarisaBroom;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMiniHakkero;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockObjectHolder.blockSaisenBako),
                0, new ModelResourceLocation(BlockObjectHolder.blockSaisenBako.getRegistryName(), "inventory"));

        ModelLoader.setCustomModelResourceLocation(ItemObjectHolder.itemDanmaku,
                0, new ModelResourceLocation(ItemObjectHolder.itemDanmaku.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemObjectHolder.itemHakureiGohei,
                0, new ModelResourceLocation(ItemObjectHolder.itemHakureiGohei.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemObjectHolder.itemReimuHeaddress,
                0, new ModelResourceLocation(ItemObjectHolder.itemReimuHeaddress.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemObjectHolder.itemMarisaBroom,
                0, new ModelResourceLocation(ItemObjectHolder.itemMarisaBroom.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemObjectHolder.itemMiniHakkero,
                0, new ModelResourceLocation(ItemObjectHolder.itemMiniHakkero.getRegistryName(), "inventory"));


        // ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(BlockObjectHolder.blockGarageKit), 0, TileEntityGarageKit.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGarageKit.class, new GarageKitRender());
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockObjectHolder.blockGarageKit),
                0, new ModelResourceLocation(BlockObjectHolder.blockGarageKit.getRegistryName(), "inventory"));

        ModelResourceLocation touhou_icons_0 = new ModelResourceLocation(ItemObjectHolder.itemTouhouIcons.getRegistryName() + "_0", "inventory");
        ModelResourceLocation touhou_icons_1 = new ModelResourceLocation(ItemObjectHolder.itemTouhouIcons.getRegistryName() + "_1", "inventory");
        ModelResourceLocation touhou_icons_2 = new ModelResourceLocation(ItemObjectHolder.itemTouhouIcons.getRegistryName() + "_2", "inventory");
        ModelResourceLocation touhou_icons_3 = new ModelResourceLocation(ItemObjectHolder.itemTouhouIcons.getRegistryName() + "_3", "inventory");
        ModelBakery.registerItemVariants(ItemObjectHolder.itemTouhouIcons, touhou_icons_0, touhou_icons_1, touhou_icons_2, touhou_icons_3);
        ModelLoader.setCustomMeshDefinition(ItemObjectHolder.itemTouhouIcons, stack -> {
            switch (ItemObjectHolder.itemTouhouIcons.getIconsType(stack)) {
                case 0:
                default:
                    return touhou_icons_0;
                case 1:
                    return touhou_icons_1;
                case 2:
                    return touhou_icons_2;
                case 3:
                    return touhou_icons_3;
            }
        });
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
        OBJLoader.INSTANCE.addDomain(BakaInTouhou.MOD_ID);
        entityRenderRegistry();
    }

    private void entityRenderRegistry() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCirno.class, EntityCirnoRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityReimu.class, EntityReimuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMarisa.class, EntityMarisaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRumia.class, EntityRumiaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDaiyousei.class, EntityDaiyouseiRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMeiling.class, EntityMeilingRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityKoakuma.class, EntityKoakumaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityPatchouli.class, EntityPatchouliRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySakuya.class, EntitySakuyaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRemilia.class, EntityRemiliaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFrandle.class, EntityFrandleRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityKisume.class, EntityKisumeRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLetty.class, EntityLettyRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWakasagihime.class, EntityWakasagihimeRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityChen.class, EntityChenRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityAlice.class, EntityAliceRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLily.class, EntityLilyRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLunasa.class, EntityLunasaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMerlin.class, EntityMerlinRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLyrica.class, EntityLyricaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRan.class, EntityRanRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityYoumu.class, EntityYoumuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityYuyuko.class, EntityYuyukoRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityYukari.class, EntityYukariRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySuika.class, EntitySuikaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySunny.class, EntitySunnyRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLunar.class, EntityLunarRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStar.class, EntityStarRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMomizi.class, EntityMomiziRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySunflowerFairy.class, EntitySunflowerFairyRender.FACTORY);


        RenderingRegistry.registerEntityRenderingHandler(EntityNormalDanmaku.class, EntityNormalDanmakuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityKnifeDanmaku.class, EntityKnifeDanmakuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTrainDanmaku.class, EntityTrainDanmakuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityButterflyDanmaku.class, EntityButterflyDanmakuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLaserDanmaku.class, EntityLaserDanmakuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityHakureDanmaku.class, EntityHakureDanmakuRender.FACTORY);

        RenderingRegistry.registerEntityRenderingHandler(EntityMarisaBroom.class, EntityMarisaBroomRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniHakkero.class, EntityMiniHakkeroRender.FACTORY);
    }
}
