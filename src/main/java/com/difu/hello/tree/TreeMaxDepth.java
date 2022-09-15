package com.difu.hello.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 树的最大深度
 */
public class TreeMaxDepth {

    /***
     *         1
     *      2      3
     *   4    5   6  7
     * 8  x
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build("1,2,3,4,5,6,7,8");

        //树的最大深度
        int depth = traverse(treeNode);
        System.out.println(depth);

        // 每个节点在第几层
        traverseLevel(treeNode, 1);
        System.out.println(maxLevel);
        System.out.println(levelMap);
    }

    /**
     * 计算数的最大深度
     * @param node
     * @return
     */
    static int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = traverse(node.left);
        int rightDepth = traverse(node.right);

        int depth = Math.max(leftDepth, rightDepth) +1;
        return depth;
    }

    /**
     * 算每个节点在第几层
     */
    static Map<Integer, Integer> levelMap = new HashMap<>();
    static int maxLevel = 0;
    static void traverseLevel(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // 把每个节点的层次都保存起来
        levelMap.put(node.value, level);

        traverseLevel(node.left, level +1);
        traverseLevel(node.right, level +1);
        // 计算最大层次
        maxLevel = Math.max(maxLevel, level);
    }

}
