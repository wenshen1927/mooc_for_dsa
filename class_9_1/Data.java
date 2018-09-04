package com.dsa.mooc.class_9_1;

import java.util.Random;

public class Data {
    public static int[] generateRandomDate(int length, int maxNum) {
        int[] data = new int[length];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(maxNum);
        }
        return data;
    }
}
