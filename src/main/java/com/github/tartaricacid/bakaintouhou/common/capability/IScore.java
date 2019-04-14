package com.github.tartaricacid.bakaintouhou.common.capability;

public interface IScore {
    void min(float points);

    void add(float points);

    void set(float points);

    float get();
}
