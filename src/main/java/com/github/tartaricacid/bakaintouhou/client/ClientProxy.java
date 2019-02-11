package com.github.tartaricacid.bakaintouhou.client;

import com.github.tartaricacid.bakaintouhou.client.entity.*;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.entity.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityCirno.class, EntityCirnoRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityReimu.class, EntityReimuRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMarisa.class, EntityMarisaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRumia.class, EntityRumiaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDaiyousei.class, EntityDaiyouseiRender.FACTORY);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);
    }
}
