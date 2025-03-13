package com.acme.algorithms.searching;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a custom algorithm to get the max value in array.
 * <p>
 * Also, you can get the max value of array through method max of stream
 * which you can get through java.util.Arrays class.
 *
 */
public class MaxValueInArray {

    static int getMaxValue(int[] numbers) {

        int maxValue = 0;

        if(Objects.nonNull(numbers)) {

            maxValue = numbers[0];

            for(int i = 1; i < numbers.length; i++) {

                if(numbers[i] > maxValue) {
                    maxValue = numbers[i];
                }

            }

        }

        return maxValue;
    }

    static int getMaxValueV2(int[] numbers) {

        return Arrays.stream(numbers).max().getAsInt();

    }

    public static void main(String... args) {

        int[] numbers = {23, 56, 34, 12, 9, 56, 60, 100};

        System.out.println("Max value with custom implementation: " + getMaxValue(numbers));
        System.out.println();
        System.out.println("Max value with Arrays/Stream implementation: " + getMaxValueV2(numbers));

    }
}
