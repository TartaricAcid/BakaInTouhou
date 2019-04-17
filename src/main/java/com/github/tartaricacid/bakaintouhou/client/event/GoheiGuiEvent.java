package com.github.tartaricacid.bakaintouhou.client.event;

import com.github.tartaricacid.bakaintouhou.BakaInTouhou;
import com.github.tartaricacid.bakaintouhou.client.network.message.GoheiChangeMessage;
import com.github.tartaricacid.bakaintouhou.common.CommonProxy;
import com.github.tartaricacid.bakaintouhou.common.item.ItemHakureiGohei;
import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = BakaInTouhou.MOD_ID, value = Side.CLIENT)
public class GoheiGuiEvent {
    private static final ResourceLocation texture = new ResourceLocation(BakaInTouhou.MOD_ID, "textures/entity/danmaku/normal_danmaku.png");
    private static int timer = 0;
    private static int color = 0;
    private static boolean show = false;

    /**
     * 当 Alt 键摁下时，更改布尔值，判定 GUI 是否显示
     */
    @SubscribeEvent
    public static void onAltKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        if (!show && mc.inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_LMENU)
                && player.getHeldItemMainhand().getItem() == ItemObjectHolder.itemHakureiGohei) {
            show = true;
        } else if (show && !Keyboard.isKeyDown(Keyboard.KEY_LMENU)) {
            show = false;
        }
    }

    @SubscribeEvent
    public static void onMouseDwheelInput(MouseEvent event) {
        if (event.isCanceled()) {
            return;
        }

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        if (show && mc.inGameHasFocus && event.getDwheel() != 0
                && player.getHeldItemMainhand().getItem() == ItemObjectHolder.itemHakureiGohei) {
            //show = false;
            CommonProxy.INSTANCE.sendToServer(new GoheiChangeMessage());
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (show && event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP player = mc.player;

            if (player.getHeldItemMainhand().getItem() != ItemObjectHolder.itemHakureiGohei) {
                return;
            }

            ItemStack stack = player.getHeldItemMainhand();
            ItemHakureiGohei item = ItemObjectHolder.itemHakureiGohei;

            // 获取相关数据
            int type = item.getGoheiMode(stack);
            // 开始迭代变化色彩
            if (timer == 60) {
                color = (color >= DanmakuInit.danmakuColorMax) ? 0 : (color + 1);
                timer = 0;
            }
            timer += 1;

            int w = DanmakuInit.danmakuTextureWidth; // 材质宽度
            int l = DanmakuInit.danmakuTextureLength; // 材质长度

            // 依据类型颜色开始定位材质位置（材质块都是 32 * 32 大小）
            double pStartU = 32 * color;
            double pStartV = 32 * type;

            float sx = event.getResolution().getScaledWidth();
            float sy = event.getResolution().getScaledHeight();

            String text = I18n.format("item.bakaintouhou.hakurei_gohei.mode",
                    I18n.format("bakaintouhou.danmaku.type_name." + item.getGoheiMode(stack)));

            mc.fontRenderer.drawString(text, (sx - mc.fontRenderer.getStringWidth(text)) / 2, sy * 0.30f, 0xffffff, true);

            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
                    GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.alphaFunc(GL11.GL_GREATER, 0f);

            GlStateManager.translate(sx / 2, sy * 0.50, 0);
            GlStateManager.rotate(180F, 0.0F, 1.0F, 0.0F);

            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufbuilder = tessellator.getBuffer();

            bufbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            mc.getTextureManager().bindTexture(texture);

            bufbuilder.pos(-25, 25, 0).tex((pStartU + 0) / w, (pStartV + 32) / l).endVertex();
            bufbuilder.pos(-25, -25, 0).tex((pStartU + 0) / w, (pStartV + 0) / l).endVertex();
            bufbuilder.pos(25, -25, 0).tex((pStartU + 32) / w, (pStartV + 0) / l).endVertex();
            bufbuilder.pos(25, 25, 0).tex((pStartU + 32) / w, (pStartV + 32) / l).endVertex();
            tessellator.draw();

            GlStateManager.disableBlend();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
        }
    }
}
