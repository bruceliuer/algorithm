package com.difu.hello.tree;

import lombok.Data;

@Data
public class TreeNode {

    public Integer value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode build(String str) {
        String[] arr = str.split(",");
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            String val = arr[i - 1];
            if ("null".equals(val) || val == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.valueOf(val));
            }
        }
        TreeNode node = null;
        for (int i = 1; i <= nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            if (2 * i >= nodes.length) {
                node.left = null;
            } else {
                node.left = nodes[2 * i];
            }

            if (2 * i + 1 >= nodes.length) {
                node.right = null;
            } else {
                node.right = nodes[2 * i + 1];
            }

        }
        return nodes[1];
    }

    @Override
    public String toString() {
        if (value != null) {
            return String.valueOf(value);
        } else {
            return "null";
        }
    }
}
