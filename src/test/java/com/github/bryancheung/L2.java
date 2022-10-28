package com.github.bryancheung;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

public class L2 {

    @Test
    public void testAlgo() {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode res = solution.addTwoNumbers(listNode, listNode2);
        while (res != null) {
            System.out.println("current " + res.val);
            res = res.next;
        }
    }

    class Solution {
        //use bitset to confirm duplicate
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode current = res;
            ListNode pre = res;
            int reserve = 0;
            while (l1 != null && l2 != null) {
                int newVal =  l1.val + l2.val + reserve;
                if (newVal > 9 ) {
                    reserve = 1;
                    current.val = newVal - 10;
                } else {
                    reserve = 0;
                    current.val = newVal;
                }
                l1 = l1.next;
                l2 = l2.next;
                current.next = new ListNode();
                pre = current;
                current = current.next;
            }
            if (l1 != null) {
                while (l1 != null) {
                    int newVal =  l1.val + reserve;
                    if (newVal > 9 ) {
                        reserve = 1;
                        current.val = newVal - 10;
                    } else {
                        reserve = 0;
                        current.val = newVal;
                    }
                    l1 = l1.next;

                    current.next = new ListNode();
                    pre = current;

                    current = current.next;
                }
            } else if (l2 != null) {
                while (l2 != null) {
                    int newVal =  l2.val + reserve;
                    if (newVal > 9 ) {
                        reserve = 1;
                        current.val = newVal - 10;
                    } else {
                        reserve = 0;
                        current.val = newVal;
                    }
                    l2 = l2.next;

                    current.next = new ListNode();
                    pre = current;

                    current = current.next;
                }
            }
            if (reserve > 0) {
                current.val = 1;
            } else {
                pre.next = null;
            }
            return res;
        }
    }
      public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    @Test
    public void testBit() {
        System.out.println('z' - ' ');
    }
}
