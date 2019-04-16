package com.github.tartaricacid.bakaintouhou.common.entity.character;

import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityLaserDanmaku;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuShoot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityFlyingYinyangs extends EntityTouhouCharacter {
    public EntityFlyingYinyangs(World worldIn) {
        super(worldIn);
        setSize(0.6f, 1.2f);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityLaserDanmaku danmaku = new EntityLaserDanmaku(world, this, 2, 0, 0xffffff, 3);
        DanmakuShoot.aimedShot(danmaku, world, this, this.getAttackTarget(), 0.5f, 5f, 0.05f);
    }
}
