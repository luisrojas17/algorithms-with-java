package com.acme.algorithms.recursion;

public class Factorial {

    /**
     * This method calculate the factorial of a number.
     * 0 = 1
     * 1 = 1
     * 2 = 2*1 (2)
     * 3 = 3*2*1 (6)
     * 4 = 4*3*2*1 (24)
     * 5 = 5*4*3*2*1 (120)
     *
     * @param number an integer that represents the number to calculate the factorial.
     *
     * @return an integer that represents the factorial calculated.
     */
    public int calculate(int number) {

        int result = 1;

        if (number == 0) {
            return result;
        }

        result = number * calculate(number - 1);

        return result;
    }

    public static void main(String[] args) {

        Factorial f = new Factorial();

        int number = 0;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));

        number = 1;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));

        number = 2;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));

        number = 3;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));

        number = 4;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));

        number = 5;
        System.out.println("Factorial of " + number + ": " + f.calculate(number));
    }

}
