package com.github.tartaricacid.bakaintouhou.common.util;

public final class DanmakuInit {
    // 弹幕类型最大为 8（从 0 开始）
    public static int danmakuTypeMax = 8;
    // 弹幕颜色最大为 6（从 0 开始）
    public static int danmakuColorMax = 6;
    // 依据类型，硬编码弹幕大小，数组长度需要和类型相匹配
    public static double[] danmakuSize = {
            0.8, // 点弹 0
            0.8, // 小玉 1
            0.8, // 中玉 2
            1.2, // 大玉 3
            0.4, // 椭弹 4
            0.4, // 心弹 5
            0.3, // 星弹 6
            0.3, // 札弹 7
            0.3  // 环玉 8
    };
    // 弹幕材质宽度
    public static int danmakuTextureWidth = 224;
    // 弹幕材质长度
    public static int danmakuTextureLength = 320;
}
