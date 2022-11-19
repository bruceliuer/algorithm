package com.difu.hello.nodelist;

public class ListNodePrint {
    public static void main(String[] args) {
        ListNode node = ListNode.buildNode(new Integer[]{1,2,3,4,5,6});
        // 顺序打印
        System.out.println(node);
        // 倒序打印
        traverse(node);
    }

    /**
     * 倒序打印链表
     * @param head
     */
    static void traverse(ListNode head) {
        if (head == null) {
            return;
        }

        traverse(head.next);
        System.out.println(head.value);
    }
}
