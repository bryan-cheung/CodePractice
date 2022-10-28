package com.github.bryancheung;

import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.BitSet;

public class L4 {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2, 7}));
    }

    class Solution {
        //sorted merge and take middle
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            ArrayList<Integer> res = new ArrayList<>(nums1.length + nums2.length);
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1 [i] < nums2[j]) {
                    res.add(nums1[i]);
                    i++;
                } else {
                    res.add(nums2[j]);
                    j++;
                }
            }
                for (; i < nums1.length; i++) {
                    res.add(nums1[i]);
                }
                for (; j < nums2.length; j++) {
                    res.add(nums2[j]);
                }
            if ( (Integer.valueOf(res.size()).doubleValue() / 2) % 1 > 0) {
                return res.get(res.size()/2);
            } else {
                return Integer.valueOf(res.get(res.size()/2 - 1) + res.get(res.size()/2)).doubleValue()/2;
            }
//            return res.stream().mapToDouble(item -> item).average().getAsDouble();
        }
    }


}
