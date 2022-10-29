package com.github.bryancheung;

import org.junit.jupiter.api.Test;

public class L7_ReverseNumber {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));


    }

    class Solution {
        public int reverse(int x) {
            if (x >= Integer.MAX_VALUE || x<= Integer.MIN_VALUE) {
                return 0;
            }
            int sign = 1;
            if (x<0) {
                sign = -1;
                x = Math.abs(x);
            }

            String input = String.valueOf(x);
            char[] input2 = input.toCharArray();
            char[] chars = new char[input.length()];
            for(int i = input.length(); i > 0; i--) {
                chars[input.length()-i] = input2[i-1];
            }
            Long result = Long.valueOf(new String(chars));
            if (result > Integer.MAX_VALUE) {
                return 0;
            } else {
               return result.intValue() * sign;
            }
        }

    }





}
