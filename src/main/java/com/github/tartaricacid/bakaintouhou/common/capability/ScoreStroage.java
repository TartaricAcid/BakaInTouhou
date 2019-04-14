package com.github.tartaricacid.bakaintouhou.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ScoreStroage implements Capability.IStorage<IScore> {
    @Override
    public void readNBT(Capability<IScore> capability, IScore instance, EnumFacing side, NBTBase nbt) {
        instance.set(((NBTPrimitive) nbt).getFloat());
    }

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IScore> capability, IScore instance, EnumFacing side) {
        return new NBTTagFloat(instance.get());
    }
}
