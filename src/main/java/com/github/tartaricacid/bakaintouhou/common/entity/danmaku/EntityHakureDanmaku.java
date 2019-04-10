package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityHakureDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntityHakureDanmaku.class, DataSerializers.VARINT);
    private static final DataParameter<Float> GRAVITY = EntityDataManager.createKey(EntityHakureDanmaku.class, DataSerializers.FLOAT);
    private int damage = 1;
    private float gravity = 0.01f;

    public EntityHakureDanmaku(World worldIn) {
        super(worldIn);
        setSize(0.2f, 0.1f);
        this.getDataManager().register(DAMAGE, damage);
        this.getDataManager().register(GRAVITY, gravity);
    }

    /**
     * @param worldIn   实体所处世界
     * @param throwerIn 发射实体者
     * @param damage    弹幕造成的伤害
     * @param gravity   弹幕的重力
     */
    public EntityHakureDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity) {
        super(worldIn, throwerIn);
        setSize(2f, 2f);
        this.damage = damage;
        this.gravity = gravity;
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
}
