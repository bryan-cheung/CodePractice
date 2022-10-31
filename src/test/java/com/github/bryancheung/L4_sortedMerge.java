package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class L4_sortedMerge {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2, 7}));


        Solution3 solution3 = new Solution3();
        System.out.println(solution3.findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4}));

        Solution2 solution2 = new Solution2();

//        System.out.println(solution2.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
//        System.out.println(solution2.findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4}));
//        System.out.println(solution2.findMedianSortedArrays(new int[] {1,3}, new int[] {2, 7}));
//                System.out.println(solution2.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));
//                System.out.println(solution2.findMedianSortedArrays(new int[] {}, new int[] {1}));
//                System.out.println(solution2.findMedianSortedArrays(new int[] {}, new int[] {2,3}));
//                System.out.println(solution2.findMedianSortedArrays(new int[] {3}, new int[] {-2,-1}));
                System.out.println(solution2.findMedianSortedArrays(new int[] {100001}, new int[] {100000}));

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

    class Solution3 {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) {
                return findMedianSortedArrays(B,A); // 保证 m <= n
            }
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = (m + n + 1) / 2 - i;
                if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                    iMin = i + 1;
                }
                else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                    iMax = i - 1;
                }
                else { // 达到要求，并且将边界条件列出来单独考虑
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
                }
            }
            return 0.0;
        }
    }

    class Solution2 {
        //sorted merge and take middle
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {


            int[] aList;
            int[] bList;
            if (nums1.length <= nums2.length) {
                aList = nums1;
                bList = nums2;
            } else {
                aList = nums2;
                bList = nums1;
            }


            int aSize = aList.length;
            int bSize = bList.length;

            if (aSize == 0) {
                if (bSize % 2 == 1) {
                    return bList[bSize / 2];
                } else {
                    return ((double) bList[bSize / 2] + (double) bList[bSize / 2 - 1]) / 2;
                }
            }

            int start = 0;
            int end = aSize;

            int a = (end - start) / 2;
            int b = 0;
            int aLeft;
            int bLeft;
            int aRight;
            int bRight;

            while (start <= end) {
                a = (end + start) / 2;
                b = (aSize + bSize + 1) / 2   - a;

                aLeft = a > 0 ? aList[a - 1] : aList[a];
                bLeft = b > 0 ? bList[b - 1] : bList[b];

                aRight = a == aSize ? aList[a - 1] : aList[a];
                bRight = b == bSize ? bList[b - 1] : bList[b];




                if (aLeft > bRight && (b < bSize && a > 0)) {
                    end = a - 1;
                } else if (bLeft > aRight && (a < aSize && b > 0)) {
                    start = a + 1;
                } else {
                    double left = Math.max(aLeft, bLeft);
                    if (a == 0) {
                        left = bLeft;
                    }

                    if (b == 0) {
                        left = aLeft;
                    }

                    double right = Math.min(aRight, bRight);
                    if (a == aSize) {
                        right = bRight;
                    }

                    if (b == bSize) {
                        right = aRight;
                    }

                    if ((aSize + bSize) % 2 != 0) {
                        return left;
                    } else {
                        return ((left + right) / 2);
                    }
                }

            }

            return 0;
        }
    }

}
