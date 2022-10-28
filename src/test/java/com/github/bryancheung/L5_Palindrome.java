package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class L5_Palindrome {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome("babad"));
//        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("bbb"));



    }

    class Solution {
        //sorted merge and take middle

        public long sameSet(char[] input) {
            BitSet bitSet = new BitSet(74);
            for (char c : input) {
                bitSet.set(c - '0');
            }
            long count = bitSet.stream().count();
            if (count == input.length) {
                return count;
            } else {
                return 0;
            }

        }

        // from reverse
        // if j - i < 3, s[i] = s[j], if j -i >= 3, s[j] = s[i] and m[i][j] = true
        public String longestPalindrome(String s) {

            boolean[][] matrix = new boolean[s.length()][s.length()];
            char[] chars = s.toCharArray();
            int start = 0;
            int end = 0;
            int max = 0;
            if (s.length() < 2) {
                return s;
            }
            if (s.length() == 2) {
                if (s.substring(0,1).equals(s.substring(1, 2)) ) {
                    return s;
                } else {
                    return s.substring(0,1);
                }
            }
            for (int i = chars.length - 1; i > -1; i --) {
                matrix[i][i] = true;
                for (int j = i + 1; j < chars.length; j ++) {
                    if (j - i < 3) {
                        if (chars[i] == chars[j]) {
                            matrix[i][j] = true;
                            if ((j - i) > max) {
                                max = j - i;
                                start = i ;
                                end = j;
                            }
                        }
                    } else {
                        if (chars[i] == chars[j] && matrix[i + 1][j - 1]) {
                            matrix[i][j] = true;
                            if ((j - i) > max) {
                                max = j - i;
                                start = i ;
                                end = j;
                            }
                        }
                    }
                }
            }
            return s.substring(start, end + 1);

        }
    }


    @Test
    public void testBit() {
        System.out.println("babad".substring(1 ,1 ));
    }



}
