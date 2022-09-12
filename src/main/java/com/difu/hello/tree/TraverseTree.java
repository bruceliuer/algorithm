package com.difu.hello.tree;

import java.util.ArrayList;
import java.util.List;

public class TraverseTree {
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build("1,2,3,4,5,6,7,8");
        System.out.println(treeNode);

        System.out.println(res);
    }

    static void preOrderTraverse(TreeNode treeNode){
        traverse(treeNode);
    }

    static void traverse(TreeNode root){
        res.add(root.value);

        traverse(root.left);

        traverse(root.right);
    }
}
