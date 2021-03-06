package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrainDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityTrainDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityTrainDanmaku.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> STRENGTH = EntityDataManager.createKey(EntityTrainDanmaku.class, DataSerializers.FLOAT);
    private int damage = 1;
    private float gravity = 0.01f;
    private float strength = 4f;

    public EntityTrainDanmaku(World worldIn) {
        super(worldIn);
        setSize(2f, 2f);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
        this.getDataManager().register(STRENGTH, strength);
    }

    /**
     * @param worldIn   实体所处世界
     * @param throwerIn 发射实体者
     * @param damage    弹幕造成的伤害
     * @param gravity   弹幕的重力
     */
    public EntityTrainDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, float strength) {
        super(worldIn, throwerIn);
        setSize(2f, 2f);
        this.damage = damage;
        this.gravity = gravity;
        this.strength = strength;
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
        this.getDataManager().register(STRENGTH, strength);
    }


    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY && getThrower() != null
                && !result.entityHit.getUniqueID().equals(this.getThrower().getUniqueID())) {
            result.entityHit.attackEntityFrom(new EntityDamageSource("arrow", getThrower()),
                    this.getDataManager().get(DAMAGE));
            world.createExplosion(this, this.posX, this.posY, this.posZ, getStrength(), false);
            this.setDead();
        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            world.createExplosion(this, this.posX, this.posY, this.posZ, getStrength(), false);
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


    public float getStrength() {
        return this.getDataManager().get(STRENGTH);
    }
}
