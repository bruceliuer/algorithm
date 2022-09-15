package com.difu.hello.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的遍历
 */
public class TraverseTree {

    /***
     *         1
     *      2      3
     *   4    5   6  7
     * 8  x
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build("1,2,3,4,5,6,7,8");
        System.out.println(treeNode);
        // 前序遍历
        List<Integer> res = preOrderTraverse(treeNode);
        System.out.println(res);

        // 借助外部变量的前序遍历
        traverse(treeNode);
        System.out.println(result);

        // 看节点在第几层
        traverse(treeNode, 1);

        // 统计有多少个叶子
        int total = countLeaf(treeNode);
        System.out.println("共有节点：" + total);
    }

    /**
     * 前序 （根左右）
     * @param treeNode
     */
    static List<Integer> preOrderTraverse(TreeNode treeNode){
        List<Integer> res = new LinkedList<>();
        if (treeNode == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(treeNode.value);

        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preOrderTraverse(treeNode.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preOrderTraverse(treeNode.right));
        return res;
    }

    /**
     * 借助外部变量的前序遍历
     */
    static List<Integer> result = new ArrayList<>();
    static void traverse(TreeNode root){
        if (root == null) {
            return;
        }
        result.add(root.value);

        traverse(root.left);

        traverse(root.right);
    }

    /**
     * 查看某个节点在第几层
     * @param node
     * @param level
     * @return
     */
    static Integer traverse(TreeNode node, int level) {
        if (node == null) {
            return null;
        }

        System.out.println(node.value + " 在第" + level + " 层");

        traverse(node.left, level +1);

        traverse(node.right, level +1);
        return level;
    }


    /***
     * 统计有多少个叶子节点
     *         1
     *      2      3
     *   4    5   6  7
     * 8  x
     * @param root
     */
    static int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countLeaf(root.left);
        int rightCount = countLeaf(root.right);
        // 后序位置
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点",
                root, leftCount, rightCount);
        System.out.println();
        return leftCount + rightCount + 1;
    }
}
