package com.github.tartaricacid.bakaintouhou.common.entity.item;

import com.github.tartaricacid.bakaintouhou.common.item.ItemObjectHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityMarisaBroom extends EntityLiving {
    public EntityMarisaBroom(World world) {
        super(world);
        setNoGravity(true);
        setSize(0.5f, 0.5f);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!world.isRemote && source.getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) source.getTrueSource();
            if (player.isSneaking()) {
                EntityItem item = new EntityItem(world, this.posX, this.posY, this.posZ, ItemObjectHolder.itemMarisaBroom.getDefaultInstance());
                item.setPickupDelay(10);
                this.setDead();
                world.spawnEntity(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public double getMountedYOffset() {
        return 0.05d;
    }

    @Override
    public boolean shouldRiderFaceForward(EntityPlayer player) {
        return true;
    }

    public boolean canBeSteered() {
        return true;
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return true;
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!player.isSneaking() && !this.world.isRemote) {
            player.startRiding(this);
        }
        return true;
    }


    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    // 不会踩坏庄稼
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
}
