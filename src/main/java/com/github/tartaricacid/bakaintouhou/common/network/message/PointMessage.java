package com.github.tartaricacid.bakaintouhou.common.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PointMessage implements IMessage {
    private float score;
    private float power;

    public PointMessage() {
    }

    public PointMessage(float score, float power) {
        this.score = score;
        this.power = power;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.score = buf.readFloat();
        this.power = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(score);
        buf.writeFloat(power);
    }

    public float getPower() {
        return power;
    }

    public float getScore() {
        return score;
    }
}
