package com.github.tartaricacid.bakaintouhou.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class PowerStroage implements Capability.IStorage<IPower> {
    @Override
    public void readNBT(Capability<IPower> capability, IPower instance, EnumFacing side, NBTBase nbt) {
        instance.set(((NBTPrimitive) nbt).getFloat());
    }

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IPower> capability, IPower instance, EnumFacing side) {
        return new NBTTagFloat(instance.get());
    }
}
