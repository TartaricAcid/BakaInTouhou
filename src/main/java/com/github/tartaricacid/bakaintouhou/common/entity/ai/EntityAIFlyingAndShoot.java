package com.github.tartaricacid.bakaintouhou.common.entity.ai;

import com.github.tartaricacid.bakaintouhou.common.entity.character.EntityTouhouCharacter;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIFlyingAndShoot extends EntityAIBase {
    private EntityTouhouCharacter entityIn;
    private int flyDistance;
    private double flyHight;

    public EntityAIFlyingAndShoot(EntityTouhouCharacter entityIn, int flyDistance, double flyHight) {
        this.entityIn = entityIn;
        this.flyDistance = flyDistance;
        this.flyHight = flyHight;
    }

    @Override
    public boolean shouldExecute() {
        return entityIn.getAttackTarget() instanceof EntityPlayer;
    }

    @Override
    public void updateTask() {
        EntityPlayer entityTarget = (EntityPlayer) entityIn.getAttackTarget();

        if (entityTarget == null) {
            return;
        }

        if (entityTarget.posY > entityIn.posY - flyHight) {
            entityIn.motionY = 0.1;
        } else {
            entityIn.motionY = 0;
            entityIn.attackEntityWithRangedAttack(entityIn.getAttackTarget(), flyDistance);
        }

        if (entityIn.getDistance(entityTarget) > flyDistance) {
            entityIn.motionY = -0.1;
        }
    }
}
