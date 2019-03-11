package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.FLOAT);
    private int danmakuType = 0;
    private int danmakuColor = 0;
    private int damage = 1;
    private float gravity = 0.01f;

    public EntityDanmaku(World worldIn) {
        super(worldIn);
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuType, int danmakuColor) {
        super(worldIn, throwerIn);
        this.danmakuType = danmakuType;
        this.danmakuColor = danmakuColor;
        this.getDataManager().register(TYPE, danmakuType);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity,
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

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity,
                         int danmakuType, int danmakuColor, float width, float height) {
        this(worldIn, throwerIn, damage, gravity, danmakuType, danmakuColor);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
    }


    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY && getThrower() != null) {
            if (result.entityHit.getUniqueID().equals(this.getThrower().getUniqueID())) {
                return;
            }
            result.entityHit.attackEntityFrom(new EntityDamageSource("arrow", getThrower()),
                    this.getDataManager().get(DAMAGE));
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
