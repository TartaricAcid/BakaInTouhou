package com.github.tartaricacid.bakaintouhou.common.entity.character;

import com.github.tartaricacid.bakaintouhou.common.util.DanmakuShoot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityAlice extends EntityTouhouCharacter {
    public EntityAlice(World worldIn) {
        super(worldIn);
        setSize(0.6f, 1.5f);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        DanmakuShoot.fanShapedShot(this.world, this, target, 0.5f, 2f,
                2, 0.2f, Math.PI / 2, 6);
    }
}
