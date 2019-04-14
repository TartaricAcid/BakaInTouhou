package com.github.tartaricacid.bakaintouhou.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ScoreProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IScore.class)
    public static final Capability<IScore> SCORE_CAP = null;
    private IScore instance = SCORE_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == SCORE_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == SCORE_CAP ? SCORE_CAP.cast(this.instance) : null;
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SCORE_CAP.getStorage().readNBT(SCORE_CAP, this.instance, null, nbt);
    }

    @Override
    public NBTBase serializeNBT() {
        return SCORE_CAP.getStorage().writeNBT(SCORE_CAP, this.instance, null);
    }
}
