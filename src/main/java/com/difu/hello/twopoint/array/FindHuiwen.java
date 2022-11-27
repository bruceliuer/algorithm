package com.difu.hello.twopoint.array;

/**
 * 回文  abccba
 */
public class FindHuiwen {
    public static void main(String[] args) {
        System.out.println(isHuiwen("bab"));


        System.out.println(longestPalindrome("dcbc"));

    }

    /**
     * 判断是否回文 abccba
     * @param s
     * @return
     */
    public static boolean isHuiwen(String s) {
        int left = 0; int right = s.length()-1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    // 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧
    // 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。
    // 所以我们可以先实现这样一个函数：
    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串, 双指针，向两边展开
    public static String findHuiwen(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    /**
     * 最长回文串的问题，解法的大致思路就是：
     * for 0 <= i < len(s):
     *     找到以 s[i] 为中心的回文串
     *     找到以 s[i] 和 s[i+1] 为中心的回文串
     *     更新答案
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = findHuiwen(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = findHuiwen(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
}
