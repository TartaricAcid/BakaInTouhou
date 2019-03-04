package com.github.tartaricacid.bakaintouhou.client;

import com.github.tartaricacid.bakaintouhou.client.entity.character.*;
import com.github.tartaricacid.bakaintouhou.client.entity.danmaku.EntityDanmakuRenderTest;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.entity.character.*;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemDanmaku;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    // 为投掷物渲染注册的实例
    private static ItemDanmaku itemDanmaku = new ItemDanmaku();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
        entityRenderRegistry();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockObjectHolder.blockSaisenBako),
                0, new ModelResourceLocation(BlockObjectHolder.blockSaisenBako.getRegistryName(), "inventory"));

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

        // 为弹幕渲染进行注册
        ModelResourceLocation danmaku_0 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_0", "inventory");
        ModelResourceLocation danmaku_1 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_1", "inventory");
        ModelResourceLocation danmaku_2 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_2", "inventory");
        ModelResourceLocation danmaku_3 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_3", "inventory");
        ModelResourceLocation danmaku_4 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_4", "inventory");
        ModelResourceLocation danmaku_5 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_5", "inventory");
        ModelResourceLocation danmaku_6 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_6", "inventory");
        ModelResourceLocation danmaku_7 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_7", "inventory");
        ModelResourceLocation danmaku_8 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_8", "inventory");
        ModelResourceLocation danmaku_9 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_9", "inventory");
        ModelResourceLocation danmaku_10 = new ModelResourceLocation(itemDanmaku.getRegistryName() + "_10", "inventory");

        // 分别为物品形态和投掷物形态注册
        ModelBakery.registerItemVariants(itemDanmaku, danmaku_0, danmaku_1, danmaku_2, danmaku_3,
                danmaku_4, danmaku_5, danmaku_6, danmaku_7, danmaku_8, danmaku_9, danmaku_10);
        ModelBakery.registerItemVariants(ItemObjectHolder.itemDanmaku, danmaku_0, danmaku_1, danmaku_2, danmaku_3,
                danmaku_4, danmaku_5, danmaku_6, danmaku_7, danmaku_8, danmaku_9, danmaku_10);

        // 依据不同的 type 数据，渲染不同的材质
        ItemMeshDefinition itemMeshDefinition = stack -> {
            if (itemDanmaku.hasDanmakuType(stack)) {
                switch (itemDanmaku.getDanmakuType(stack)) {
                    case 0:
                        return danmaku_0;
                    case 1:
                        return danmaku_1;
                    case 2:
                        return danmaku_2;
                    case 3:
                        return danmaku_3;
                    case 4:
                        return danmaku_4;
                    case 5:
                        return danmaku_5;
                    case 6:
                        return danmaku_6;
                    case 7:
                        return danmaku_7;
                    case 8:
                        return danmaku_8;
                    case 9:
                        return danmaku_9;
                    case 10:
                        return danmaku_10;
                }
            }
            return danmaku_0;
        };

        // 注册渲染
        ModelLoader.setCustomMeshDefinition(itemDanmaku, itemMeshDefinition);
        ModelLoader.setCustomMeshDefinition(ItemObjectHolder.itemDanmaku, itemMeshDefinition);
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
        RenderingRegistry.registerEntityRenderingHandler(EntityDanmaku.class, new IRenderFactory<EntityDanmaku>() {
            @Override
            public Render<? super EntityDanmaku> createRenderFor(RenderManager manager) {
                return new EntityDanmakuRenderTest(manager);
            }
        });
    }
}
