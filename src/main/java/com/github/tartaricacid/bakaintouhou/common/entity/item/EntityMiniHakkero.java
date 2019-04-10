package com.github.tartaricacid.bakaintouhou.common.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMiniHakkero extends EntityThrowable {
    public EntityMiniHakkero(World world) {
        super(world);
    }

    public EntityMiniHakkero(World world, EntityLivingBase throwerIn) {
        super(world, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
    }

    @Override
    public void onUpdate() {
        if (this.ticksExisted > 60) {
            this.setDead();
        }
    }
}
