package com.what2drive.service_common.utils.collections;

import java.io.Serializable;
import java.util.Objects;

public class IntPair implements Serializable {
    private int min;
    private int max;

    public IntPair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public IntPair(IntPair intPair) {
        this(intPair.getMin(), intPair.getMax());
    }

    public IntPair(String str) {
        this(fromString(str));
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntPair intPair = (IntPair) o;
        return min == intPair.min && max == intPair.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return min + "," + max;
    }

    public static IntPair fromString(String str) {
        String[] words = str.split(",");
        int min = Integer.parseInt(words[0]);
        int max = Integer.parseInt(words[1]);
        return new IntPair(min, max);
    }
}