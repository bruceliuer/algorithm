package com.difu.hello.nodelist;

import java.util.PriorityQueue;

public class NodeListMerge {

    public static void main(String[] args) {
        ListNode list1 = ListNode.buildNode(new Integer[]{1, 4, 5});
        ListNode list2 = ListNode.buildNode(new Integer[]{1, 3, 4});

        System.out.println(list1);
        System.out.println(list2);
        // 合并两个链表
        System.out.println(mergeTwoLists(list1, list2));


        // 合并多个链表
        ListNode listL1 = ListNode.buildNode(new Integer[]{1, 4, 5});
        ListNode listL2 = ListNode.buildNode(new Integer[]{1, 3, 4});
        ListNode listL3 = ListNode.buildNode(new Integer[]{2,6});

        ListNode result= mergeKLists(new ListNode[]{listL1, listL2, listL3});
        System.out.println(result);
    }



    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode p = result;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 没有循环完成的，一次加入链表
        if (l1!=null) {
            p.next = l1;
        }
        if (l2!=null) {
            p.next = l2;
        }

        return result.next;
    }

    /**
     * 多个列表合并
     * 3个合并 [1, 4, 5], [1, 3, 4], [2, 6]
     * 合并结果： [1, 1, 2, 3, 4, 4, 5 , 6]
     * [
     *  1->4->5
     *  1->3->4
     *  2->6
     * ]
     * 借助优先级队列
     * @param lists
     * @return
     */
    static ListNode mergeKLists(ListNode[] lists){
        // 结果
        ListNode result = new ListNode(-1);

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>( (a,b)->(a.value-b.value));

        for (ListNode head : lists) {
            queue.add(head);
        }

        ListNode p = result;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = new ListNode(node.value);
            p = p.next;

            if (node.next!=null) {
                queue.add(node.next);
            }
        }

        return result.next;
    }
}
