package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;

public class LC1239 {
    @Test
    public void testAlgo() {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j")));
        System.out.println(solution.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
        System.out.println(solution.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(solution.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }


    class Solution {
        //hashset solution which has deduplication logic built-in
        public int charSize(String input){
            Set mySet = new HashSet();
            final char[] chars = input.toCharArray();
            for (char aChar : chars) {
                mySet.add(aChar);
            }
            if (mySet.size() == input.length()) {
                return mySet.size();
            } else {
                return 0;
            }
        }

        public int maxLength(String currentString, List<String> arr) {
            final int currentSize = charSize(currentString);
            if (arr.size() == 1) {
                return charSize(currentString + arr.get(0));
            } else {
                int max = 0;
                String inputString;
                for (String s : arr) {
                    inputString =  currentString + s;
                    max = Math.max(max, Math.max(currentSize, maxLength(inputString, arr.subList(1, arr.size()) )));
                }
                return max;
            }
        }

        public int maxLength(List<String> arr) {
            return maxLength("", arr);
        }
    }


    class Solution2 {
        //bitset solution which set the position of a-z to be 1
        public int charSize(String input){
            BitSet bitSet = new BitSet(26);
            for (char c : input.toCharArray()) {
                bitSet.set(c - 'a');
            }
            long count = bitSet.stream().count();
            if (input.length() == count) {
                return Long.valueOf(count).intValue();
            } else {
                return 0;
            }
        }

        //Use backward queue to replace recursive for performance
        public int maxLength(List<String> arr) {

            int max = 0;
            List<String> queue = new LinkedList<>();

            for (String input : arr) {
                int currentSize = charSize(input);
                if (currentSize > 0) {
                    List<String> tempQueue = new LinkedList<>();
                    tempQueue.add(input);
                    max = Math.max(max, currentSize);
                    for (String queueInput : queue) {
                        int aggSize = charSize(input + queueInput);

                        max = Math.max(max, Math.max(currentSize, aggSize));
                        if (aggSize > 0) {
                            tempQueue.add(input + queueInput);
                        }
                    }
                    queue.addAll(tempQueue);
                }
            }
            return max;
        }
    }
}
