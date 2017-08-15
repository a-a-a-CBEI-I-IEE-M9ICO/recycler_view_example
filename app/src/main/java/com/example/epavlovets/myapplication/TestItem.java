package com.example.epavlovets.myapplication;

import java.util.Random;

/**
 * Created by epavlovets on 15.08.2017.
 */

class TestItem {
    int mIndex;
    String mName;
    private static final Random sRandom;

    static {
        sRandom = new Random();
    }

    public TestItem(int index) {
        mIndex = index;
        mName = index+"ABCD"+sRandom.nextGaussian();
    }

    public static TestItem generateRandomItem(int index) {
        return new TestItem(index);
    }
}
