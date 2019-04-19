package com.eureka;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arrayList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            arrayList.add(tmp);
            tmp = tmp.next;
        }
        ListNode x = arrayList.get(arrayList.size() - n);
        if (x.next == null) {
            if (arrayList.size() - n - 1 < 0) {
                return null;
            }
            ListNode p = arrayList.get(arrayList.size() - n - 1);
            p.next = null;
        } else {
            x.val = x.next.val;
            x.next = x.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        long start = System.currentTimeMillis();
        ListNode n = removeNthFromEnd(node, 2);
        while (n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


}
