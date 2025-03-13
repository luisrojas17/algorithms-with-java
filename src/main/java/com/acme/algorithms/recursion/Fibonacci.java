package com.acme.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    /**
     * F(N) = F(N -2) + F(N-1)
     *
     * @param number
     * @return
     */
    public int calculate(int number) {

        if (number == 0 || number == 1) {
            return number;
        }

        return calculate(number - 2) + calculate(number - 1);

    }

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();

        int number = 0;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        number = 1;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        number = 3;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        number = 4;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        number = 5;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        number = 7;
        System.out.println("Fibonacci of " + number + ": " + f.calculate(number));

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            numbers.add(f.calculate(i));

        }

        numbers.forEach(x -> System.out.println("" + x));
    }

}
