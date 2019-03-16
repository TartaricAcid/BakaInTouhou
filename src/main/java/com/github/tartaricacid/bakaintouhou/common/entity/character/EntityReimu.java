package com.github.tartaricacid.bakaintouhou.common.entity.character;

import com.github.tartaricacid.bakaintouhou.common.util.DanmakuShoot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityReimu extends EntityTouhouCharacter {
    public EntityReimu(World worldIn) {
        super(worldIn);
        setSize(0.6f, 1.5f);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        DanmakuShoot.fanShapedLaserShot(this.world, this, target, 0.3f, 0f, 0xffffffff,
                0.05f, Math.PI, 3);
    }
}
