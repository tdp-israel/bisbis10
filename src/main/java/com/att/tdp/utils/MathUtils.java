package com.att.tdp.utils;

import java.util.List;

public class MathUtils {
    public static float average(List<Float> numbers) {
        float average = 0;
        float sum = MathUtils.sum(numbers);
        if(sum != 0) {
            average = sum / numbers.size();
        }
        return average;
    }

    public static float sum(List<Float> numbers) {
        float sum = 0;
        for (Float num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static float roundTo2Decimals(Float value) {
        return Math.round(value * 100f) / 100f;
    }
}
