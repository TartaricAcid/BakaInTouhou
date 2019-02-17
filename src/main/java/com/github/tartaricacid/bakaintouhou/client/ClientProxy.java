package com.github.tartaricacid.bakaintouhou.client;

import com.github.tartaricacid.bakaintouhou.client.entity.*;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.block.BlockObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.entity.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
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
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockObjectHolder.blockSaisenBako),
                0, new ModelResourceLocation(BlockObjectHolder.blockSaisenBako.getRegistryName(), "inventory"));
    }
}
