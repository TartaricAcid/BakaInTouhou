package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLaserDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(EntityLaserDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityLaserDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityLaserDanmaku.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> LENGTH = EntityDataManager.createKey(EntityLaserDanmaku.class, DataSerializers.FLOAT);
    private int danmakuColor = 0xff_ff_ff;
    private int damage = 1;
    private float gravity = 0.01f;
    private float length = 3.0f;

    public EntityLaserDanmaku(World worldIn) {
        super(worldIn);
        setSize(0.1f, 0.1f);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
        this.getDataManager().register(LENGTH, length);
    }

    /**
     * @param worldIn      实体所处世界
     * @param throwerIn    发射实体者
     * @param danmakuColor 弹幕颜色，格式为 RGB
     */
    public EntityLaserDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuColor, float length) {
        super(worldIn, throwerIn);
        setSize(0.1f, 0.1f);
        this.danmakuColor = danmakuColor;
        this.length = length;
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
        this.getDataManager().register(LENGTH, length);
    }

    /**
     * @param worldIn      实体所处世界
     * @param throwerIn    发射实体者
     * @param damage       弹幕造成的伤害
     * @param gravity      弹幕的重力
     * @param danmakuColor 弹幕颜色，格式为 RGB
     */
    public EntityLaserDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, int danmakuColor, float length) {
        super(worldIn, throwerIn);
        setSize(0.1f, 0.1f);
        this.danmakuColor = danmakuColor;
        this.damage = damage;
        this.gravity = gravity;
        this.length = length;
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
        this.getDataManager().register(LENGTH, length);
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

    public float getLength() {
        return this.getDataManager().get(LENGTH);
    }

    public int getDanmakuColor() {
        return this.getDataManager().get(COLOR);
    }
}
