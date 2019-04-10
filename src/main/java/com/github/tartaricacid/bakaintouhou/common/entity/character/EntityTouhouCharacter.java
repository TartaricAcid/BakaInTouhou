package com.github.tartaricacid.bakaintouhou.common.entity.character;

import com.github.tartaricacid.bakaintouhou.common.entity.ai.EntityAIFlyingAndShoot;
import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityNormalDanmaku;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuShoot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTouhouCharacter extends EntityMob implements IRangedAttackMob {
    public EntityTouhouCharacter(World worldIn) {
        super(worldIn);
        setNoGravity(true);
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAIFlyingAndShoot(this, 12, 2d));
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIWander(this, 1.0d, 60));
        tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
        tasks.addTask(3, new EntityAILookIdle(this));
        tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));

        targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15d);
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
        EntityNormalDanmaku danmaku = new EntityNormalDanmaku(world, this, 2, 0, rand.nextInt(2),
                rand.nextInt(7));
        DanmakuShoot.aimedShot(danmaku, world, this, this.getAttackTarget(), 0.5f, 5f, 0.5f);
        world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, this.getSoundCategory(),
                1.0f, 0.8f);
    }
}
