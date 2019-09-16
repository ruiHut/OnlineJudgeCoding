package com.swordToOffer.q30_39;

import java.util.ArrayList;
import java.util.Arrays;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#38-%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97
// desc: 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
// q: 是否重复字符
public class q_38字符串的排序 {

    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;

        char[] chars = str.toCharArray();
        // sort first
        Arrays.sort(chars);
        backTracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backTracking(char[] chars, boolean[] hasUsed, StringBuilder sb) {
        if (sb.length() == chars.length) {
            ret.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) // keep only one node use
                continue;
            hasUsed[i] = true;
            sb.append(chars[i]);
            backTracking(chars, hasUsed, sb);
            sb.deleteCharAt(sb.length() - 1);
            hasUsed[i] = false;

        }
    }
}
