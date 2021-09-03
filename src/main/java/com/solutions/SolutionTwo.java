package com.solutions;

public class SolutionTwo {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int tmp = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmp;
            if (sum >= 10) {
                sum = sum - 10;
                tmp = 1;
            } else {
                tmp = 0;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + tmp;
            if (sum >= 10) {
                sum = sum - 10;
                tmp = 1;
            } else {
                tmp = 0;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + tmp;
            if (sum >= 10) {
                sum = sum - 10;
                tmp = 1;
            } else {
                tmp = 0;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }
        if (tmp == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return head.next;
    }

}
