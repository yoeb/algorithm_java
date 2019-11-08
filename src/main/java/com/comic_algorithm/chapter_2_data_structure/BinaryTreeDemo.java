package com.comic_algorithm.chapter_2_data_structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树 在计算机科学中，二叉树（英语：Binary tree）是每个节点最多只有两个分支（即不存在分支度大于2的节点）
 * 的树结构。通常分支被称作“左子树”或“右子树”。二叉树的分支具有左右次序，不能随意颠倒。
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        // 构造二叉树
        //              3
        //           /     \
        //          2        8
        //        /  \     /   \
        //      9    10 null     4
        //     / \    | \
        // null null null null
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(inputList);

        // 深度优先遍历 递归
//        System.out.println("前序遍历");
//        preOrderTraveral(treeNode);
//        System.out.println("中序遍历");
//        inOrderTraveral(treeNode);
//        System.out.println("后序遍历");
//        postOrderTraveral(treeNode);
        // 深度优先遍历 非递归
        System.out.println("非递归前序遍历");
        preOrderTraveralWithStack(treeNode);
        System.out.println("非递归中序遍历");
        inOrderTraveralWithStack(treeNode);
        System.out.println("非递归后序遍历");
        postOrderTraveralWithStack(treeNode);

        // 广度优先遍历
//        System.out.println("层序遍历");
//        levelOrderTraversal(treeNode);

    }


    /**
     * 构建二叉树
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树非递归前序遍历
     * @param root 二叉树根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树非递归中序遍历
     * @param node 二叉树根节点
     */
    public static void inOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.empty()) {
            // 迭代访问节点的左孩子，并入栈
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.empty()) {
                node = stack.pop();
                System.out.println(node.data);
                node = node.rightChild;
            }
        }

    }

    /**
     * 二叉树非递归后序遍历
     * @param node 二叉树根节点
     */
    public static void postOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        // TODO 用栈实现后序遍历

    }

    /**
     * 二叉树层序遍历
     * @param root 二叉树节点
     */
    public static void  levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

}
