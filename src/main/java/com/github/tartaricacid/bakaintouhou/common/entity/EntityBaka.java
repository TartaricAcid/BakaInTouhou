package com.github.tartaricacid.bakaintouhou.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBaka extends EntityMob implements IRangedAttackMob {
    private static final DataParameter<Boolean> WING_SHAKE = EntityDataManager.createKey(EntityBaka.class, DataSerializers.BOOLEAN);

    public EntityBaka(World worldIn) {
        super(worldIn);
        setSize(0.5f, 1.2f);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(WING_SHAKE, true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0d);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15d);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9.0d);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, 1.0d, 60));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        if (this.getAttackTarget() != null) {
            attackEntityWithRangedAttack(this.getAttackTarget(), 8f);
        }
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getTrueSource() instanceof EntityBaka || source.damageType.equals(DamageSource.FALL.damageType) || source.isExplosion()) {
            return false;
        } else {
            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        double px = target.posX;
        double py = target.posY;
        double pz = target.posZ;

        double x = this.posX;
        double y = this.posY;
        double z = this.posZ;

        EntityDanmaku entityDanmaku = new EntityDanmaku(this.world, this, px - x, py - y, pz - z);
        entityDanmaku.posX = x;
        entityDanmaku.posY = y;
        entityDanmaku.posZ = z;

        this.world.spawnEntity(entityDanmaku);
    }
}
