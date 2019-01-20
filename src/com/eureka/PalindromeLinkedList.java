package com.eureka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindromeMyself(ListNode head) {
        boolean flag = true;
        if (head != null) {
            List<ListNode> nodeList = new ArrayList<>();
            nodeList.add(head);
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
                nodeList.add(node);
            }
            for (int i = 0; i < nodeList.size() / 2; i++) {
                flag = flag && nodeList.get(i).val == nodeList.get(nodeList.size() - 1 - i).val;
            }
        }
        return flag;
    }

    public static boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
//        listNode.next.next.next.next = new ListNode(1);
        long start = System.currentTimeMillis();
        System.out.println(isPalindromeMyself(listNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(isPalindrome(listNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
