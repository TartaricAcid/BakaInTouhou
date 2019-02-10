package com.github.tartaricacid.bakaintouhou.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTouhouCharacter extends EntityMob implements IRangedAttackMob {
    private int flyDistance = 12;
    private double flyHight = 3d;

    public EntityTouhouCharacter(World worldIn) {
        super(worldIn);
        setNoGravity(true);
    }

    public EntityTouhouCharacter(World worldIn, int flyDistance, int flyHight) {
        super(worldIn);
        this.flyDistance = flyDistance;
        this.flyHight = flyHight;
        setNoGravity(true);
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
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15d);
    }

    @Override
    protected void updateAITasks() {
        if (this.getAttackTarget() != null) {
            EntityLivingBase entitylivingbase = this.getAttackTarget();

            if (entitylivingbase.posY > this.posY - flyHight) {
                this.motionY = 0.1;
            } else {
                this.motionY = 0;
            }

            if (this.getDistance(entitylivingbase) < flyDistance) {
                attackEntityWithRangedAttack(entitylivingbase, 12f);
            } else {
                this.motionY = -0.1;
            }
        }
        super.updateAITasks();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getTrueSource() instanceof EntityTouhouCharacter || source.damageType.equals(DamageSource.FALL.damageType)) {
            return false;
        } else {
            return super.attackEntityFrom(source, amount);
        }
    }


    @Override
    public void setSwingingArms(boolean swingingArms) {
        // TODO
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        // TODO
    }
}
