package com.acme.algorithms.searching;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class implements a custom algorithm to get the min value in array.
 * <p>
 * Also, you can get the min value of array through method min of stream
 *  * which you can get through java.util.Arrays class.
 *
 */
public class MinValueInArray {

    static int getMinValue(int[] numbers) {

        int minValue = 0;

        if(Objects.nonNull(numbers)) {

            minValue = numbers[0];

            for(int i = 1; i < numbers.length; i++) {

                if(numbers[i] < minValue) {
                    minValue = numbers[i];
                }
            }

        }

        return minValue;
    }

    static int getMinValueV2(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }

    public static void main(String... args) {

        int[] numbers = {23, 56, 34, 12, 9, 56, 60, 100};

        System.out.println("Min value with custom implementation: " + getMinValue(numbers));
        System.out.println();
        System.out.println("Min value with Arrays/Stream implementation: " + getMinValueV2(numbers));

    }
}
