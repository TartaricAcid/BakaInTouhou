package com.github.tartaricacid.bakaintouhou.common;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.block.BlockGarageKit;
import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.block.BlockSaisenBako;
import com.github.tartaricacid.bakaintouhou.common.block.tileentity.TileEntityGarageKit;
import com.github.tartaricacid.bakaintouhou.common.capability.*;
import com.github.tartaricacid.bakaintouhou.common.command.MainCommand;
import com.github.tartaricacid.bakaintouhou.common.entity.character.*;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.*;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMarisaBroom;
import com.github.tartaricacid.bakaintouhou.common.entity.item.EntityMiniHakkero;
import com.github.tartaricacid.bakaintouhou.common.item.*;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemDanmaku;
import com.github.tartaricacid.bakaintouhou.common.network.PointPackHandler;
import com.github.tartaricacid.bakaintouhou.common.world.TouhouGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    private static int id = 0;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockSaisenBako());
        event.getRegistry().register(new BlockGarageKit());

        GameRegistry.registerTileEntity(TileEntityGarageKit.class, new ResourceLocation(BakaInTouhou.MOD_ID, "garage_kit"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemDanmaku());
        event.getRegistry().register(new ItemTouhouIcons());
        event.getRegistry().register(new ItemHakureiGohei());
        event.getRegistry().register(new ItemReimuHeaddress());
        event.getRegistry().register(new ItemMarisaBroom());
        event.getRegistry().register(new ItemMiniHakkero());

        event.getRegistry().register(new ItemBlock(BlockObjectHolder.blockSaisenBako).setRegistryName(
                BlockObjectHolder.blockSaisenBako.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BlockObjectHolder.blockGarageKit).setRegistryName(
                BlockObjectHolder.blockGarageKit.getRegistryName()));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new TouhouGen(), 0);

        CapabilityManager.INSTANCE.register(IPower.class, new PowerStroage(), Power.FACTORY);
        CapabilityManager.INSTANCE.register(IScore.class, new ScoreStroage(), Score.FACTORY);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        registerEntities();

        PointPackHandler.registerMessages(BakaInTouhou.MOD_ID);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new MainCommand());
    }


    private void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.cirno"),
                EntityCirno.class, "entity_cirno", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x4a6195, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.reimu"),
                EntityReimu.class, "entity_reimu", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xbc0408, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.marisa"),
                EntityMarisa.class, "entity_marisa", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x2e1714, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.rumia"),
                EntityRumia.class, "entity_rumia", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x181818, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.daiyousei"),
                EntityDaiyousei.class, "entity_daiyousei", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x87c564, 0x83b6eb);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.meiling"),
                EntityMeiling.class, "entity_meiling", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd9262c, 0x344c06);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.koakuma"),
                EntityKoakuma.class, "entity_koakuma", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd45b4f, 0x513438);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.patchouli"),
                EntityPatchouli.class, "entity_patchouli", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x975680, 0xf1e1eb);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.sakuya"),
                EntitySakuya.class, "entity_sakuya", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x00c68, 0xced0d0);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.remilia"),
                EntityRemilia.class, "entity_remilia", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf2cbcc, 0x94a7d2);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.frandle"),
                EntityFrandle.class, "entity_frandle", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xfbda93, 0xff5d5b);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.kisume"),
                EntityKisume.class, "entity_kisume", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x53c346, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.letty"),
                EntityLetty.class, "entity_letty", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x7d72b6, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.wakasagihime"),
                EntityWakasagihime.class, "entity_wakasagihime", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x05406e, 0x1e7d40);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.chen"),
                EntityChen.class, "entity_chen", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xe03a2c, 0x2a907e);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.alice"),
                EntityAlice.class, "entity_alice", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xe0cd80, 0x5171be);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.lily"),
                EntityLily.class, "entity_lily", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf39229, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.lunasa"),
                EntityLunasa.class, "entity_lunasa", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x000000, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.merlin"),
                EntityMerlin.class, "entity_merlin", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xcdcbf3, 0xf3e8ec);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.lyrica"),
                EntityLyrica.class, "entity_lyrica", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd8beaf, 0xff0807);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.ran"),
                EntityRan.class, "entity_ran", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf4e563, 0x8e83ff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.youmu"),
                EntityYoumu.class, "entity_youmu", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x185865, 0xececec);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.yuyuko"),
                EntityYuyuko.class, "entity_yuyuko", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xc28aa6, 0xa0b1c2);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.yukari"),
                EntityYukari.class, "entity_yukari", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd8b970, 0x9f78af);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.suika"),
                EntitySuika.class, "entity_suika", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xff941d, 0x642195);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.sunny"),
                EntitySunny.class, "entity_sunny", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf1b67a, 0xcd5c41);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.lunar"),
                EntityLunar.class, "entity_lunar", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xfffffb, 0x330d04);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.star"),
                EntityStar.class, "entity_star", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x55658b, 0x5e3927);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.momizi"),
                EntityMomizi.class, "entity_momizi", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xffffff, 0xb7afba);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.character.sunflower_fairy"),
                EntitySunflowerFairy.class, "entity_sunflower_fairy", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xffffff, 0xf27922);


        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.normal_damaku"),
                EntityNormalDanmaku.class, "entity_normal_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.knife_damaku"),
                EntityKnifeDanmaku.class, "entity_knife_damaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.train_danmaku"),
                EntityTrainDanmaku.class, "entity_train_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.butterfly_danmaku"),
                EntityButterflyDanmaku.class, "entity_butterfly_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.laser_danmaku"),
                EntityLaserDanmaku.class, "entity_laser_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.danmaku.hakure_danmaku"),
                EntityHakureDanmaku.class, "entity_hakure_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);


        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.item.marisa_broom"),
                EntityMarisaBroom.class, "entity_marisa_broom", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "entity.item.mini_hakkero"),
                EntityMiniHakkero.class, "entity_mini_hakkero", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
    }
}
