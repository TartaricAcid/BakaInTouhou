package com.github.tartaricacid.bakaintouhou.common.util;

import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public final class DanmakuShoot {
    private static Random random = new Random();

    /**
     * 自机狙弹幕
     *
     * @param danmaku    需要发射的弹幕，必须为 EntityThrowable 或其子类
     * @param worldIn    发射者所处世界
     * @param entity     发射者
     * @param target     发射朝向的目标
     * @param velocity   弹幕速度
     * @param inaccuracy 弹幕不准确度，数值越大弹幕越散
     * @param chance     弹幕发射的几率，介于 0-1 之间，数值越大发射越频繁
     */
    public static void aimedShot(EntityThrowable danmaku, World worldIn, EntityTouhouCharacter entity, EntityLivingBase target, Float velocity, Float inaccuracy, float chance) {
        if (random.nextFloat() < chance) {
            if (!worldIn.isRemote) {
                danmaku.shoot(target.posX - entity.posX, target.posY - entity.posY + entity.getEyeHeight(), target.posZ - entity.posZ, velocity, inaccuracy);
                worldIn.spawnEntity(danmaku);
            }
            worldIn.playSound(null, danmaku.posX, danmaku.posY, danmaku.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, danmaku.getSoundCategory(),
                    1.0f, 0.8f);
        }
    }

    /**
     * 扇形弹弹幕
     *
     * @param danmaku    需要发射的弹幕，必须为 EntityThrowable 或其子类
     * @param worldIn    发射者所处世界
     * @param entity     发射者
     * @param target     发射朝向的目标
     * @param velocity   弹幕速度
     * @param inaccuracy 弹幕不准确度，数值越大弹幕越散
     * @param chance     弹幕发射的几率，介于 0-1 之间，数值越大发射越频繁
     * @param yawTotal   偏航总角度，弧度表示（以发射者和发射目标为中心左右对称）
     * @param fanNum     扇形弹链数（fanNum >=2）
     */
    public static void fanShapedShot(EntityThrowable danmaku, World worldIn, EntityTouhouCharacter entity, EntityLivingBase target, Float velocity, Float inaccuracy,
                                     float chance, double yawTotal, int fanNum) {
        if (yawTotal < 0 || yawTotal > 2 * Math.PI || fanNum < 2) {
            return;
        }

        if (random.nextFloat() < chance) {
            if (!worldIn.isRemote) {
                Vec3d v = new Vec3d(target.posX - entity.posX, target.posY - entity.posY + entity.getEyeHeight(), target.posZ - entity.posZ);
                double yaw = -(yawTotal / 2);
                double addYaw = yawTotal / (fanNum - 1);
                for (int i = 1; i <= fanNum; i++) {
                    Vec3d v1 = v.rotateYaw((float) yaw);
                    yaw = yaw + addYaw;

                    danmaku.shoot(v1.x, v1.y, v1.z, velocity, inaccuracy);
                    worldIn.spawnEntity(danmaku);
                }
            }
            worldIn.playSound(null, danmaku.posX, danmaku.posY, danmaku.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, danmaku.getSoundCategory(),
                    1.0f, 0.8f);
        }
    }

    /**
     * 自玩家头顶一定高度发射的弹幕
     *
     * @param danmaku    需要发射的弹幕，必须为 EntityThrowable 或其子类
     * @param worldIn    发射者所处世界
     * @param entity     发射者
     * @param target     发射朝向的目标
     * @param inaccuracy 弹幕不准确度，数值越大弹幕越散
     * @param chance     弹幕发射的几率，介于 0-1 之间，数值越大发射越频繁
     * @param height     距离玩家头顶的高度
     */
    public static void headDropShot(EntityThrowable danmaku, World worldIn, EntityTouhouCharacter entity, EntityLivingBase target, Float inaccuracy,
                                    float chance, double height) {
        if (random.nextFloat() < chance) {
            if (!worldIn.isRemote) {
                danmaku.setPosition(target.posX, target.posY + target.getEyeHeight() + height, target.posZ);
                danmaku.shoot(target.posX, target.posY, target.posZ, 0f, inaccuracy);
                worldIn.spawnEntity(danmaku);
            }
            worldIn.playSound(null, danmaku.posX, danmaku.posY, danmaku.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, danmaku.getSoundCategory(),
                    1.0f, 0.8f);
        }
    }
}
