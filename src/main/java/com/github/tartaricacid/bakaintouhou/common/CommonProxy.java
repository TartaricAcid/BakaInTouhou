package com.github.tartaricacid.bakaintouhou.common;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
    private static int id = 0;

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
    }
}
