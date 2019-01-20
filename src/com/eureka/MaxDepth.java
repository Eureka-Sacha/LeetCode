package com.eureka;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by @奎
 *
 * @date: @2019/1/20.
 * @mail:
 * @description: 104.二叉树的最大深度
 * 给定一个二叉树,找出其最大深度.
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数.
 * <p>
 * 说明:叶子节点是指没有子节点的节点.
 * <p>
 * 示例:
 * 给定二叉树 [3,9,29,null,null,15,7],
 * <p>
 * 3
 * /  \
 * 9   20
 * / \
 * 15  7
 * 返回他的最大深度3.
 */
public class MaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepthMyself(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftLen = maxDepthMyself(root.left);
            int rightLen = maxDepthMyself(root.right);
            return Math.max(leftLen, rightLen) + 1;
        }
    }

    public static int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentLen = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentLen);
                stack.add(new Pair<>(root.left, currentLen + 1));
                stack.add(new Pair<>(root.right, currentLen + 1));
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(11);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(33);
        System.out.println(maxDepth(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(maxDepthMyself(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
