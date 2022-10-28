package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.ArrayBlockingQueue;

public class L6_StringToZ {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("S", 1));


    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            char[] chars = s.toCharArray();
            StringBuilder[] res = new StringBuilder[numRows];
            for (int t=0; t < numRows; t++) {
                res[t] = new StringBuilder();
            }


            //take numRows
            //take numRows - 2
            int batch = numRows + (numRows - 2);
            for (int i =0; i < chars.length; i = i + batch) {
                for (int j =i; j < i + batch && j < chars.length; j++) {
                    int index = j % batch;
                    if (index < numRows) {
                        res[index] = res[index].append(chars[j]);
                    } else {
                        res[batch - index]  =res[batch - index].append(chars[j]);
                    }
                }

            }
            StringBuilder sb = new StringBuilder();
            for (StringBuilder re : res) {
                sb.append(re);
            }
            return sb.toString();
        }

    }



    @Test
    public void testDiv(){

        System.out.println(0 % 8);
        System.out.println(1 % 8);
        System.out.println(2 % 8);
        System.out.println(3 % 8);
        System.out.println(4 % 8);
        System.out.println(5 % 8);
        System.out.println(6 % 8);
        System.out.println(7 % 8);
        System.out.println(8 % 8);
    }


}
