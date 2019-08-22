package com.swordToOffer.q3_10;

/**
 * @program: OnlineJudgeCoding
 * @description: 将一个字符串中的空格替换成 "%20"。
 * @author: Mr.Zhou
 * @create: 2019-08-22 22:56
 **/

/**
 * solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#5-%E6%9B%BF%E6%8D%A2%E7%A9%BA%E6%A0%BC
 * 字符串题目应尽可能避免产生新字符串的形式
 */

public class q_5替换空格 {

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return "";

        int p1 = str.length() - 1;
        String temp = "  ";
        for (int i = 0; i <= p1; i++) // * 这里不能用 str,length() *
            if (str.charAt(i) == ' ')
                str.append(temp);


        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }

        return str.toString();
    }

}


