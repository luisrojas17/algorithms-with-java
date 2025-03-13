package com.acme.algorithms.kfrequentelements;

import java.util.*;

/**
 * This class implements the solution for the problem "Top K Frequent Elements".
 * <br/>
 * Directions:
 * Given an array numbers[] and a positive integer k, the task is to find
 * the k most frequently occurring elements from a given array.
 *
 */
public class TopKFrequentElements {

    public List<Map.Entry<Integer, Integer>> getKFrequentElements(int[] numbers, int k) {

        // Convert the primitive array to Integer array
        Integer[] array = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        // To get unique values.
        Set<Integer> s = new HashSet<>(Arrays.asList(array));

        // To save occurrences by value.
        Map<Integer, Integer> map = new HashMap<>();

        Iterator<Integer> ite = s.iterator();

        while(ite.hasNext()) {

            Integer i = ite.next();
            map.put(i, 0);
        }

        System.out.println("Map with values: " + map);

        // To count the occurrences
        for(int i = 0; i < array.length; i++) {

            if(map.containsKey(array[i])) {
                int r = map.get(array[i]);

                map.put(array[i], r + 1);
            }

        }

        System.out.println("Map with occurrences: " + map);

        // Sort map entries according its values
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("Sorted map: " + entries);

        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        // We get the items according to k
        for (int i = 0; i < k; i++) {
            result.add(entries.get(i));
        }

        return result;

    }

    public static void main(String[] args) {
        //Input: nums = [1,1,1,2,2,3], k = 2
        //Output: [1,2]

        //int[] array = {1, 1, 1, 2, 2, 3, 4};
        //int[] array = {1, 3, 3, 4};
        int[] array = {8, 4, 3, 4, 8, 4};
        int k = 2;

        TopKFrequentElements kFrequentElements = new TopKFrequentElements();

        System.out.println("The solution is: ");

        List<Map.Entry<Integer, Integer>> result = kFrequentElements.getKFrequentElements(array, k);
        result.forEach(entry ->
                System.out.println("Value: " + entry.getKey() + " has: " + entry.getValue() + " occurrences."));




    }

}
