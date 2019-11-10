package com.fei.demo.leetcode;

/**
 * 删除链表倒数第N个节点
 * 1->3->4->2 删除倒数第2个变为：1->3->2
 */
public class RemoveListNode {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        /**
         * 分两个引用指向head，第一个pNode先走n个位置，然后pNode和qNode一起走到链尾，此时qNode指向待删除节点的前一个节点
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int curCnt = 0;
            ListNode pNode = head;
            ListNode qNode = head;
            while (pNode.next != null) {
                curCnt++;
                if (curCnt <= n) {
                    pNode = pNode.next;
                } else {
                    pNode = pNode.next;
                    qNode = qNode.next;
                }
            }
            // 链表只有一个元素和要删除的为头节点(共n个节点，删除倒数第n个节点)的情况
            if (head.next == null || n == curCnt+1) {
                head = head.next;
            } else {
                qNode.next = qNode.next.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(1);
//        l1.next.next.next.next = new ListNode(5);
        solution.removeNthFromEnd(l1, 1);
    }
}
