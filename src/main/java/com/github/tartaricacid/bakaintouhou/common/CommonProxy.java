package com.github.tartaricacid.bakaintouhou.common;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityCirno;
import com.github.tartaricacid.bakaintouhou.common.entity.EntityReimu;
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
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/cirno.png"),
                EntityCirno.class, "entity_cirno", 1, BakaInTouhou.INSTANCE, 32,
                3, true, 0x4a6195, 0xffffff);
        EntityRegistry.registerModEntity(new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/reimu.png"),
                EntityReimu.class, "entity_reimu", 2, BakaInTouhou.INSTANCE, 32,
                3, true, 0xbc0408, 0xffffff);
    }
}
