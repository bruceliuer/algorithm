package com.difu.hello.minwindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow {

    public static void main(String[] args) {
        String s = "EBBANCF";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    static Map<Character, Integer> ori = new HashMap<Character, Integer>();
    static Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;

            if (r < sLen ) {
                char rtmp = s.charAt(r);
                if (ori.containsKey(rtmp)) {
                    cnt.put(rtmp, cnt.getOrDefault(rtmp, 0) + 1);
                }
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                char ltmp = s.charAt(l);
                if (ori.containsKey(ltmp)) {
                    cnt.put(ltmp, cnt.getOrDefault(ltmp, 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}
