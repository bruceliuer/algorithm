package com.difu.hello.nodelist;

/**
 * 反转链表
 */
public class NodeListReverse {

    public static void main(String[] args) {
        ListNode list1 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});

        System.out.println(reverse(list1));

        ListNode list2 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(reverseN(list2, 3));

        ListNode list3 = ListNode.buildNode(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(reverseBetween(list3, 3, 5));
    }

    /**
     * 反转链表
     * 1->2->3->4->5->6
     * head=1-> reverse(null<=2<-3<-4<-5<-6)=last
     * head=1<=2<-3<-4<-5<-6)=last     代表 head.next.next=head
     * null<-1<=2<-3<-4<-5<-6)=last   代表 head.next = null
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        // 终止递归
        if (head == null || head.next == null ) {
            return head;
        }

        ListNode last = reverse(head.next);
        // 第二个节点的next指向第一个
        head.next.next = head;
        // 末尾指向空
        head.next = null;
        // last就是新的头
        return last;
    }


    /**
     * 反转前3个节点
     * 1->2->3->4->5->6
     * 第一个指向隔断的那个
     * <-1->2->3
     * 4->5->6
     * @param head
     * @param n
     * @return
     */
    // 记录中间那个节点
    static ListNode middle = null;
    public static ListNode reverseN(ListNode head, int n){
        if (n==1){
            middle = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        // 最后一个指向 中间那个
        head.next = middle;

        // 头节点
        return last;
    }

    /**
     * 反转 第m到n个节点 m=3 n=5
     *
     * 1->2->3->4->5->6
     *
     * 1->2 revers(3<-4<-5) ->6
     * @param head
     * @param m
     * @param n
     * @return
     */
    static ListNode reverseBetween(ListNode head, int m, int n) {
        // 如果 m == 1，就相当于反转链表前n个元素
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}
