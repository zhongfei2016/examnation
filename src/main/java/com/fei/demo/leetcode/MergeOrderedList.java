package com.fei.demo.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeOrderedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pNode = l2;
        ListNode qNode = l2;
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        while (l1 != null && l2 != null) {
            while (l1.val >= pNode.val) {
                // qNode指向当前l2元素，qNode指向下一个
                qNode = pNode;
                if (pNode.next != null) {
                    pNode = pNode.next;
                } else {
                    // pNode等于null说明l2结束了，在后面直接追加l1即可
                    qNode.next = l1;
                    return l2;
                }
            }

            ListNode temp = new ListNode(l1.val);
            if (qNode != pNode) {
                // 不等时说明l1元素在l2第一个元素之后，正常追加到qNode和pNode之间，然后qNode重新指向新加的temp元素
                qNode.next = temp;
                qNode = temp;
                temp.next = pNode;
            } else {
                // pNode和qNode相等说明l1的元素比l2所有元素小，所以加在l2头部，pNode和qNode重新指向l2头部
                l2 = temp;
                l2.next = pNode;
                qNode = l2;
                pNode = l2;
            }
            l1 = l1.next;
        }
        return l2;
    }
}
