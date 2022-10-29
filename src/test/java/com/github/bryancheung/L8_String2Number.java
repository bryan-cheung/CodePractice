package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class L8_String2Number {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
//        System.out.println(solution.myAtoi("4193 with words"));
//        System.out.println(solution.myAtoi("words and 987"));
//        System.out.println(solution.myAtoi("   -42"));
//        System.out.println(solution.myAtoi("+!12"));
        System.out.println(solution.myAtoi("9223372036854775808"));
        System.out.println(solution.myAtoi("20000000000000000000"));
        System.out.println(solution.myAtoi("20000000000000000000"));
        System.out.println(solution.myAtoi("-000000000000000000000000000000000000000000000000001"));

    }

    class Solution {
        public int myAtoi(String s) {
            int sign = 1;
            char[] chars = s.toCharArray();
            LinkedList<Character> characters = new LinkedList<>();
//            char[] res = new char[s.length()];
            boolean numberStart = false;
            boolean startpoint = false;
            boolean ignore = false;
            for(int i=0 ; i<chars.length; i++) {
                char currentChar = chars[i];
                if (currentChar == '-' && !numberStart) {
                    sign = -1;
                    numberStart = true;
                } else if (currentChar == '+' && !numberStart){
                    numberStart = true;
                } else if (currentChar - '0' > -1 && currentChar - '0' < 10 && !ignore) {
                    numberStart = true;
                    if (currentChar == '0' && !startpoint) {

                    } else {
                        startpoint = true;
                        characters.add(currentChar);
                    }
                } else if (!numberStart && currentChar != ' ') {
                    return 0;
                } else if (currentChar == ' '){
                    if (numberStart) {
                        ignore = true;
                    }
                } else {
                    ignore = true;
                }
            }

            char[] res1 = new char[characters.size()];
            for (int i=0; i<characters.size(); i++) {
                res1[i] = characters.get(i);
            }


            if (res1.length >= 15) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            try {
            Long temp = Long.valueOf(new String(res1)) * Long.valueOf(sign);

            if (temp >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (temp <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return temp.intValue();
            }
            } catch (Exception ex) {
                return 0;
            }
        }

    }





}
