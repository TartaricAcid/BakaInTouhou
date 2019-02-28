package com.github.tartaricacid.bakaintouhou.common.entity.danmaku;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDanmaku extends EntityThrowable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityDanmaku.class, DataSerializers.VARINT);
    private int damage = 1;
    private float gravity = 0.01f;
    private int danmakuType = 0;

    public EntityDanmaku(World worldIn) {
        super(worldIn);
        this.getDataManager().register(TYPE, danmakuType);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int damage, float gravity, int danmakuType) {
        super(worldIn, throwerIn);
        this.damage = damage;
        this.gravity = gravity;
        this.danmakuType = danmakuType;
        this.getDataManager().register(TYPE, danmakuType);
    }

    public EntityDanmaku(World worldIn, EntityLivingBase throwerIn, int danmakuType) {
        super(worldIn, throwerIn);
        this.danmakuType = danmakuType;
        this.getDataManager().register(TYPE, danmakuType);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            result.entityHit.attackEntityFrom(DamageSource.MAGIC, damage);
        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.setDead();
        }
    }

    @Override
    protected float getGravityVelocity() {
        return gravity;
    }

    @SideOnly(Side.CLIENT)
    public int getDanmakuType() {
        return this.getDataManager().get(TYPE);
    }


    // 为调试添加的方法
    @Override
    public String toString() {
        return super.toString() + " danmaku_type: " + danmakuType;
    }
}
