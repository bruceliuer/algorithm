package com.difu.hello.twopoint.array;

/**
 * 反转字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        String content = "abcdefghijklmnopqrstuvwxyz";
        char[] s = content.toCharArray();
        reverse(s);
        System.out.println(s);

    }

    public static void reverse(char[] s) {
        int left = 0; int right = s.length -1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left ++; right --;
        }
    }
}
