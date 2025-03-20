package com.acme.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindConsecutiveSequences {

    public int[][] find(String[] strArray) {

        int[][] result = null;

        if (null != strArray) {

            List<Integer> numbers = Arrays.stream(strArray).filter(s -> {
                try {
                    Integer.parseInt(s);
                    return true;
                } catch (Exception e) {
                    System.err.println("Error: " + e);
                    return false;
                }
            }).map(Integer::parseInt).toList();

            List<Integer> numbersFiltered = new ArrayList<>();
            // ["1", "2", "3", "5", "9", "6", "7", "8", "4", "-5", "-7", "-3", "-2", "-1"]
            //                  i         j

            int j = 0; // To compare against next item
            for (int i = 0; i <= numbers.size() - 1; i++) {

                j++;
                int beforeValue = i -1 < 0 ? 0 : numbers.get(i-1);
                int currentValue = numbers.get(i);

                // If it is the last item only it is made the comparison
                // between current item and before item
                if (i == numbers.size() - 1) {
                    if ((currentValue - beforeValue) == 1) {
                        numbersFiltered.add(numbers.get(i));
                    }

                    break;
                }

                // While it is not the last item
                int nextValue = numbers.get(j);

                if ((nextValue - currentValue) == 1 || (currentValue - beforeValue) == 1) {
                    numbersFiltered.add(numbers.get(i));
                }

            }

            //numbersFiltered.forEach(System.out::println);
            int size = numbersFiltered.size()/3;
            result = new int[size][size];

            // To create a matrix where m represents rows and n represents columns
            //       n0, n1, n2
            // m0 -> [1, 2, 3]
            // m1 -> [6, 7, 8]
            // m2 -> [-3, -2, -1]
            j = 0; // To access to each item in the list.
            for (int m = 0; m < result.length; m++) {
                for (int n = 0; n < result.length; n++) {
                    result[m][n] = numbersFiltered.get(j);
                    j++;
                }
            }
            
        }

        return result;

    }

    public static void main(String...args) {

        FindConsecutiveSequences fcs = new FindConsecutiveSequences();

        // Case 1
        // Input: ["1", "2", "3", "5", "9", "a", "6", "7", "8", "4", "@", "-5", "-7", "-3", "-2", "-1"]
        String[] strArray =
                {"1", "2", "3", "5", "9", "a", "6", "7", "8", "4", "@", "-5", "-7", "-3", "-2", "-1"};

        //Output: ->
        // [1, 2, 3]
        //[6, 7, 8]
        //[-3, -2, -1]
        int[][] result = fcs.find(strArray);

        for (int i = 0; i < result.length; i++) {

            System.out.println("M" + i + " ->");
            for (int j = 0; j < result.length; j++) {

                System.out.println("\t" + result[i][j]);
            }
        }

    }
}
