package com.github.tartaricacid.bakaintouhou.common.entity.character;

import com.github.tartaricacid.bakaintouhou.common.entity.danmaku.EntityButterflyDanmaku;
import com.github.tartaricacid.bakaintouhou.common.util.DanmakuShoot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.World;

public class EntityReimu extends EntityTouhouCharacter {
    public EntityReimu(World worldIn) {
        super(worldIn);
        setSize(0.6f, 1.5f);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityButterflyDanmaku danmaku = new EntityButterflyDanmaku(world, this, 0, 0, 0xff_00_00);
        DanmakuShoot.fanShapedShot(danmaku, this.world, this, target, 0.3f, 0f,
                0.05f, Math.PI, 8);
        world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, this.getSoundCategory(),
                1.0f, 0.8f);
    }
}
