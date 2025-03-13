package com.acme.algorithms.searching;

import java.util.*;

/**
 * This class use the binarySearch method defined in java.util.Arrays class
 * which is part of collections framework.
 *
 * @author josel.rojas
 */
public class SearchBinary {

    static int binarySearch(int[] numbers, int key) {

        // The array must be sorted before use binarySearch
        Arrays.sort(numbers);

        return Arrays.binarySearch(numbers, key);
    }

    static int binarySearch(List<String> names, String nameToSearch) {

        // The collection must be sorted before use or you must specify a comparator
        names = names.stream().sorted().toList();

        System.out.println("Sorted names: " + names);

        // Use comparator if the collection is not sorted, or you want to use custom classes.
        /*Comparator<Person> c = new Comparator<Person>() {
            public int compare(Person u1, Person u2)
            {
                return u1.getId().compareTo(u2.getId());
            }
        };*/

        return Collections.binarySearch(names, nameToSearch, null);

    }

    public static void main(String... args) {
        int[] numbers = new int[] {7,3,6,8,2};

        int index = binarySearch(numbers, 2);
        System.out.println("Index found: " + index);
        System.out.println("Number found: " + numbers[index]);


        List<String> names = List.of("Gera", "Bere", "Karen", "Ana" , "Jose Luis");

        int indexItemFound = binarySearch(names, "Bere");
        System.out.println("Index found: " + indexItemFound);
        System.out.println("Name found: " + names.get(indexItemFound));

    }
}
