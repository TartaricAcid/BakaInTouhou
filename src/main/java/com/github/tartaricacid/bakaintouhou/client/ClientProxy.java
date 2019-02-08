package com.github.tartaricacid.bakaintouhou.client;

import com.github.tartaricacid.bakaintouhou.client.entity.EntityBakaRender;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityBaka;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityBaka.class, EntityBakaRender.FACTORY);
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
