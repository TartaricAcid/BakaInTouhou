package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.FLOAT);
    private int damage = 1;
    private float gravity = 0.01f;
    private int danmakuType = 0;

    public EntityDanmaku(World worldIn) {
        super(worldIn);
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuType) {
        super(worldIn, throwerIn);
        this.danmakuType = danmakuType;
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, int danmakuType) {
        super(worldIn, throwerIn);
        this.damage = damage;
        this.gravity = gravity;
        this.danmakuType = danmakuType;
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, int danmakuType, float width, float height) {
        this(worldIn, throwerIn, damage, gravity, danmakuType);
        this.setSize(width, height);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            result.entityHit.attackEntityFrom(DamageSource.MAGIC, this.getDataManager().get(DAMAGE));
        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
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


    // 为调试添加的方法
    @Override
    public String toString() {
        return super.toString() + " danmaku_type: " + danmakuType;
    }
}
