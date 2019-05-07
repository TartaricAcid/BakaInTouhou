package com.github.tartaricacid.bakaintouhou.common.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TouhouTeleporter extends Teleporter {
    private double x;
    private double y;
    private double z;

    public TouhouTeleporter(WorldServer worldIn, double x, double y, double z) {
        super(worldIn);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void placeInPortal(Entity entity, float rotationYaw) {
        entity.setPosition(this.x, this.y, this.z);
        entity.motionX = 0.0f;
        entity.motionY = 0.0f;
        entity.motionZ = 0.0f;
    }
}
