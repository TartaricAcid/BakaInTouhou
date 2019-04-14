package com.github.tartaricacid.bakaintouhou.common.capability;

import java.util.concurrent.Callable;

public class Power implements IPower {
    public static Factory FACTORY = new Factory();
    private float power = 0.0f;

    @Override
    public void add(float points) {
        if (points + this.power <= 5.0f) {
            this.power += points;
        } else {
            this.power = 5.0f;
        }
    }

    @Override
    public void min(float points) {
        if (points <= this.power) {
            this.power -= points;
        } else {
            this.power = 0.0f;
        }
    }

    @Override
    public void set(float points) {
        this.power = (points > 5.0f) ? 5.0f : points;
    }

    @Override
    public float get() {
        return this.power;
    }

    private static class Factory implements Callable<IPower> {
        @Override
        public IPower call() {
            return new Power();
        }
    }
}
