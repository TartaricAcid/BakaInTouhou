package com.github.tartaricacid.bakaintouhou.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PowerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IPower.class)
    public static final Capability<IPower> POWER_CAP = null;
    private IPower instance = POWER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == POWER_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == POWER_CAP ? POWER_CAP.cast(this.instance) : null;
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        POWER_CAP.getStorage().readNBT(POWER_CAP, this.instance, null, nbt);
    }

    @Override
    public NBTBase serializeNBT() {
        return POWER_CAP.getStorage().writeNBT(POWER_CAP, this.instance, null);
    }
}
