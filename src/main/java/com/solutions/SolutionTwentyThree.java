package com.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ChenYu
 * @date 2021/9/12 22:34
 */
public class SolutionTwentyThree {
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


    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode();
        ListNode pre = head;
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            pre.next = minNode;
            pre = pre.next;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return head.next;
    }
}
