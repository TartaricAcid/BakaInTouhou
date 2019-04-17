package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityNormalDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityNormalDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(EntityNormalDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityNormalDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityNormalDanmaku.class, DataSerializers.FLOAT);
    private int danmakuType = 0;
    private int danmakuColor = 0;
    private int damage = 1;
    private float gravity = 0.01f;

    public EntityNormalDanmaku(World worldIn) {
        super(worldIn);
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    /**
     * @param worldIn      实体所处世界
     * @param throwerIn    发射实体者
     * @param danmakuType  弹幕类型，类型限制为 0-8
     * @param danmakuColor 弹幕颜色，颜色限制为 0-6
     */
    public EntityNormalDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuType, int danmakuColor) {
        super(worldIn, throwerIn);
        this.danmakuType = danmakuType;
        this.danmakuColor = danmakuColor;
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    /**
     * @param worldIn      实体所处世界
     * @param throwerIn    发射实体者
     * @param damage       弹幕造成的伤害
     * @param gravity      弹幕的重力
     * @param danmakuType  弹幕类型，类型限制为 0-8
     * @param danmakuColor 弹幕颜色，颜色限制为 0-6
     */
    public EntityNormalDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity,
                               int danmakuType, int danmakuColor) {
        super(worldIn, throwerIn);
        this.danmakuType = danmakuType;
        this.danmakuColor = danmakuColor;
        this.damage = damage;
        this.gravity = gravity;
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }


    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY && getThrower() != null
                && !result.entityHit.getUniqueID().equals(this.getThrower().getUniqueID())) {
            result.entityHit.attackEntityFrom(new EntityDamageSource("arrow", getThrower()),
                    this.getDataManager().get(DAMAGE));
            this.setDead();
        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.setDead();
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted > 200) {
            this.setDead();
        }
    }

    @Override
    protected float getGravityVelocity() {
        return this.getDataManager().get(GRAVITY);
    }

    public int getDanmakuType() {
        return this.getDataManager().get(TYPE);
    }

    public int getDanmakuColor() {
        return this.getDataManager().get(COLOR);
    }


    // 为调试添加的方法
    @Override
    public String toString() {
        return super.toString() + " danmaku_type: " + danmakuType;
    }
}
