package com.github.tartaricacid.bakaintouhou;

import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = BakaInTouhou.MOD_ID,
        name = BakaInTouhou.MOD_NAME,
        version = BakaInTouhou.VERSION,
        acceptedMinecraftVersions = "[1.12]"
)
public class BakaInTouhou {
    public static final String MOD_ID = "bakaintouhou";
    public static final String MOD_NAME = "BakaInTouhou";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MOD_ID)
    public static BakaInTouhou INSTANCE;

    @SidedProxy(serverSide = "com.github.tartaricacid.bakaintouhou.common.CommonProxy",
            clientSide = "com.github.tartaricacid.bakaintouhou.client.ClientProxy")
    public static CommonProxy commonProxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        commonProxy.preinit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        commonProxy.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        commonProxy.postinit(event);
    }
}
