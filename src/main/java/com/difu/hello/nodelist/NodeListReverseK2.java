package com.difu.hello.nodelist;

public class NodeListReverseK2 {
    public static void main(String[] args) {
        ListNode list1 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});

        System.out.println(reverseKGroup(list1, 2));

    }

    static ListNode reverse(ListNode head){
        ListNode pre, cur, next;
        pre = null; cur = next = head;
        while (cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static ListNode reverseBeteen(ListNode a, ListNode b){
        ListNode pre, cur, next;
        pre = null; cur = next = a;
        while (cur!=b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static ListNode reverseKGroup(ListNode head, int k){
        ListNode a, b;
        a = b= head;
        for (int i=0; i<k; i++){
            // 如果b为空， 递归结束
            if (b == null) {
                return null;
            }
            b = b.next;
        }
        ListNode newHead = reverseBeteen(a, b);

        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
