package com.github.tartaricacid.bakaintouhou.common;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.block.BlockSaisenBako;
import com.github.tartaricacid.bakaintouhou.common.entity.character.*;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemTouhouIcons;
import com.github.tartaricacid.bakaintouhou.common.world.TouhouGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    private static int id = 0;

    @SubscribeEvent
    public static void blockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockSaisenBako());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new TouhouGen(), 0);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        entityRegister();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemDanmaku());
        event.getRegistry().register(new ItemTouhouIcons());

        event.getRegistry().register(new ItemBlock(BlockObjectHolder.blockSaisenBako).setRegistryName(
                BlockObjectHolder.blockSaisenBako.getRegistryName()));
    }

    private void entityRegister() {
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/cirno.png"),
                EntityCirno.class, "entity_cirno", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x4a6195, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/reimu.png"),
                EntityReimu.class, "entity_reimu", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xbc0408, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/marisa.png"),
                EntityMarisa.class, "entity_marisa", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x2e1714, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/rumia.png"),
                EntityRumia.class, "entity_rumia", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x181818, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/daiyousei.png"),
                EntityDaiyousei.class, "entity_daiyousei", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x87c564, 0x83b6eb);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/meiling.png"),
                EntityMeiling.class, "entity_meiling", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd9262c, 0x344c06);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/koakuma.png"),
                EntityKoakuma.class, "entity_koakuma", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd45b4f, 0x513438);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/patchouli.png"),
                EntityPatchouli.class, "entity_patchouli", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x975680, 0xf1e1eb);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/sakuya.png"),
                EntitySakuya.class, "entity_sakuya", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x00c68, 0xced0d0);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/remilia.png"),
                EntityRemilia.class, "entity_remilia", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf2cbcc, 0x94a7d2);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/frandle.png"),
                EntityFrandle.class, "entity_frandle", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xfbda93, 0xff5d5b);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/kisume.png"),
                EntityKisume.class, "entity_kisume", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x53c346, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/letty.png"),
                EntityLetty.class, "entity_letty", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x7d72b6, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/wakasagihime.png"),
                EntityWakasagihime.class, "entity_wakasagihime", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x05406e, 0x1e7d40);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/chen.png"),
                EntityChen.class, "entity_chen", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xe03a2c, 0x2a907e);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/alice.png"),
                EntityAlice.class, "entity_alice", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xe0cd80, 0x5171be);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lily.png"),
                EntityLily.class, "entity_lily", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf39229, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lunasa.png"),
                EntityLunasa.class, "entity_lunasa", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x000000, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/merlin.png"),
                EntityMerlin.class, "entity_merlin", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xcdcbf3, 0xf3e8ec);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lyrica.png"),
                EntityLyrica.class, "entity_lyrica", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd8beaf, 0xff0807);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/ran.png"),
                EntityRan.class, "entity_ran", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf4e563, 0x8e83ff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/youmu.png"),
                EntityYoumu.class, "entity_youmu", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x185865, 0xececec);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/yuyuko.png"),
                EntityYuyuko.class, "entity_yuyuko", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xc28aa6, 0xa0b1c2);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/yukari.png"),
                EntityYukari.class, "entity_yukari", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xd8b970, 0x9f78af);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/suika.png"),
                EntitySuika.class, "entity_suika", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xff941d, 0x642195);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/sunny.png"),
                EntitySunny.class, "entity_sunny", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xf1b67a, 0xcd5c41);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/lunar.png"),
                EntityLunar.class, "entity_lunar", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0xfffffb, 0x330d04);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/star.png"),
                EntityStar.class, "entity_star", id++, BakaInTouhou.INSTANCE, 32,
                3, true, 0x55658b, 0x5e3927);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/damaku.png"),
                EntityDanmaku.class, "entity_danmaku", id++, BakaInTouhou.INSTANCE, 32,
                3, true);
    }
}
