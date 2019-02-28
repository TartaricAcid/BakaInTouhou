package com.github.tartaricacid.bakaintouhou.client.entity.danmaku;

import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityDanmaku;
import com.github.tartaricacid.bakaintouhou.common.item.danmaku.ItemDanmaku;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityDanmakuRender extends RenderSnowball<EntityDanmaku> {
    protected final ItemDanmaku item;

    public EntityDanmakuRender(RenderManager renderManagerIn, ItemDanmaku itemIn, RenderItem itemRendererIn) {
        super(renderManagerIn, itemIn, itemRendererIn);
        this.item = itemIn;
    }

    @Override
    public ItemStack getStackToRender(EntityDanmaku entityIn) {
        ItemStack stack = new ItemStack(this.item);
        int type = entityIn.getDanmakuType();
        this.item.setDanmakuType(stack, type);
        return stack;
    }

    public static class Factory implements IRenderFactory<EntityDanmaku> {
        private ItemDanmaku item;

        public Factory(ItemDanmaku itemIn) {
            this.item = itemIn;
        }

        @Override
        public Render<? super EntityDanmaku> createRenderFor(RenderManager manager) {
            return new EntityDanmakuRender(manager, item, Minecraft.getMinecraft().getRenderItem());
        }
    }
}
