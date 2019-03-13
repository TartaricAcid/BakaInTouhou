package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityKnifeDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> COLOR = EntityDataManager.createKey(EntityKnifeDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityKnifeDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityKnifeDanmaku.class, DataSerializers.FLOAT);
    private int danmakuColor = 0xffffff;
    private int damage = 1;
    private float gravity = 0.01f;

    public EntityKnifeDanmaku(World worldIn) {
        super(worldIn);
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityKnifeDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuColor) {
        super(worldIn, throwerIn);
        this.danmakuColor = danmakuColor;
        this.getDataManager().register(COLOR, danmakuColor);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    public EntityKnifeDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, int danmakuColor) {
        super(worldIn, throwerIn);
        this.danmakuColor = danmakuColor;
        this.damage = damage;
        this.gravity = gravity;
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

    public int getDanmakuColor() {
        return this.getDataManager().get(COLOR);
    }
}
