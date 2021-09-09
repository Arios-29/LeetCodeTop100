package com.solutions;

public class SolutionNinteen {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head);
        ListNode cur = head;
        ListNode end = head;
        for (int i = 1; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            pre = pre.next;
            cur = cur.next;
            end = end.next;
        }
        if (cur == head) {
            return head.next;
        } else {
            pre.next = cur.next;
            return head;
        }
    }
}
