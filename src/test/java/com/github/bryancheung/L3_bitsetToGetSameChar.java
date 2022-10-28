package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class L3_bitsetToGetSameChar {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }

    class Solution {
        //use bitset to confirm duplicate
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            long max = 1;

            char[] chars = s.toCharArray();
            for(int i=0; i< chars.length; i++) {
                BitSet bitSet = new BitSet(90);
                bitSet.set(chars[i] - ' ');

                for (int j=i + 1; j < chars.length; j++) {
                    if (bitSet.get(chars[j] - ' ')) {
                        max = Math.max(bitSet.stream().count(), max);
                        break;
                    } else {
                        bitSet.set(chars[j] - ' ');
                    }
                }
                max = Math.max(bitSet.stream().count(), max);
            }

            return Long.valueOf(max).intValue();
        }
    }

    @Test
    public void testBit() {
        System.out.println('z' - ' ');
    }
}
