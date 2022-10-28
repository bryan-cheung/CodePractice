package com.github.bryancheung;

import org.junit.jupiter.api.Test;

public class L9_PalindromeInt {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome("babad"));
//        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));



    }

    class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length /2 ; i++) {
                if (chars[i] != chars[chars.length - 1  - i]) {
                    return false;
                }
            }
            return true;
        }

    }





}
