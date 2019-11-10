package com.fei.demo.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。目的求他们的和并放到一个链表中
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 */
public class ListNumSum {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 进位值临时保存
            int adder = 0;
            ListNode lSum = new ListNode(0);
            ListNode lTemp = lSum;
            do {
                // 空位以0补充
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + adder;
                adder = 0;
                if (sum >= 10) {
                    adder = sum / 10;
                    sum = sum % 10;
                }
                l1 = l1 == null ? l1 : l1.next;
                l2 = l2 == null ? l2 : l2.next;
                ListNode newNode = new ListNode(sum);
                // 将当前和作为新节点追加到临时节点，即追加到lSum链中
                lTemp.next = newNode;
                // 临时节点往后移指向新节点开始新一轮计算
                lTemp = newNode;
            } while (l1 != null || l2 != null || adder != 0);

            return lSum.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        solution.addTwoNumbers(l1, l2);
    }
}
