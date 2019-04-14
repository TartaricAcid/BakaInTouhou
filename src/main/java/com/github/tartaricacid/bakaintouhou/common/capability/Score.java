package com.github.tartaricacid.bakaintouhou.common.capability;

import java.util.concurrent.Callable;

public class Score implements IScore {
    public static Factory FACTORY = new Factory();
    private float score = 0.0f;

    @Override
    public void add(float points) {
        this.score += points;
    }

    @Override
    public void min(float points) {
        if (points <= this.score) {
            this.score -= points;
        } else {
            this.score = 0.0f;
        }
    }

    @Override
    public void set(float points) {
        this.score = points;
    }

    @Override
    public float get() {
        return this.score;
    }

    private static class Factory implements Callable<IScore> {
        @Override
        public IScore call() {
            return new Score();
        }
    }
}
