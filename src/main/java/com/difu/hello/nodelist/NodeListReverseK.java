package com.difu.hello.nodelist;

public class NodeListReverseK {

    public static void main(String[] args) {
        ListNode list1 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});

        System.out.println(reverse(list1));

        ListNode list2 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});
        ListNode result = reverseKGroup(list2, 2);
        System.out.println(result);

        ListNode list3 = ListNode.buildNode(new Integer[]{1, 2, 3});
        System.out.println(reverseRec(list3));
    }


    /**
     *
     * https://labuladong.gitee.io/algo/images/kgroup/8.gif
     *
     * pre next
     * null->1->2->3->4->5->6
     *     cur
     *
     * pre       next
     * null<-1-> 2->  3->4->5->6
     *      cur
     *
     *      pre     next
     * null<-1-> 2-> 3-> 4->5->6
     *          cur
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre, next, cur;
        pre = null; next = cur = head;

        while (cur != null){
            // next用来保留剩余节点
            next = cur.next;
            //反转
            cur.next = pre;
            //指针后移动
            pre = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * 递归遍历
     * @param head
     * @return
     */
    static ListNode reverseRec(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     *
     * 反转 a 到 null 之间的结点
     */
    static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            // next用来保留剩余节点
            nxt = cur.next;
            // 反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * K个一组反转
     * @param head
     * @param k
     * @return
     */
    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b= head;
        for (int i=0; i<k; i++){
            b = b.next;
        }
        // 反转a,b一组
        ListNode newHead = reverse(a, b);

        //递归， 反转剩余的b后面的
        a.next = reverseKGroup(b, k);
        return newHead;
    }


}
