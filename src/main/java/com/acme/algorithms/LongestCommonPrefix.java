package com.acme.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Longest Common Prefix
 * <br/>
 * Example 1:
 * <br/>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <br/>
 * Example 2:
 * <br/>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static String test(List<String> inputList) {
        if (null == inputList || inputList.isEmpty()) {
            return "";
        }

        // This is the key to get the longest common substring
        List<String> charactersOrdered= inputList.stream().sorted().toList();
        System.out.println("Strings ordered:" + charactersOrdered);

        // If we order the strings we will get the longest common substring comparing the first and last string
        // Since if there are common characters in the first string also it will be in the last string.
        String first = inputList.getFirst();
        String last = inputList.getLast();

        // So, we have to iterate through the characters of the first string and second string
        // But we have to consider the common length of both strings.
        // So, we have to iterate over both strings.
        int lengthFirst = first.length();
        int lengthLast = last.length();

        // We get the min length in order to iterate both strings and can get the longest common substring
        int minLength = Math.min(lengthFirst, lengthLast);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minLength; i++) {

            if(first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        List<String> inputs = Arrays.asList("flower", "flow", "flight");
        String result = LongestCommonPrefix.test(inputs);

        System.out.println("Result: "+ result);

        inputs = Arrays.asList("Mexico", "Mexico city");
        result = LongestCommonPrefix.test(inputs);

        System.out.println("Result: " + result);

        inputs = Arrays.asList("Mexico", "Dog", "EU");
        result = LongestCommonPrefix.test(inputs);

        System.out.println("Result: " + result);

    }
}
