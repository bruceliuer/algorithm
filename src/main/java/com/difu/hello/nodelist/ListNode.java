package com.difu.hello.nodelist;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(){}

    public ListNode(int value){
        this.value = value;
    }

    public static ListNode buildNode(Integer[] array) {
        ListNode list = new ListNode(array[0]);
        ListNode p = list;
        for (Integer i = 1; i < array.length; i ++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return list;
    }

    @Override
    public String toString() {
        return  value + "->" + next;
    }
}
