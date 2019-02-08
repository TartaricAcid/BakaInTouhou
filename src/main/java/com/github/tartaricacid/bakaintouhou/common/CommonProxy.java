package com.github.tartaricacid.bakaintouhou.common;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityBaka;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        entityRegister();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }

    private void entityRegister() {
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/baka.png"),
                EntityBaka.class, "touhou_baka", 1, BakaInTouhou.INSTANCE, 64,
                3, true, 0x4a6195, 0xffffff);
    }
}
