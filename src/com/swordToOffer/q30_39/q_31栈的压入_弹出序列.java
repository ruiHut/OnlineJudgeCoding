package com.swordToOffer.q30_39;

import java.util.Stack;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#31-%E6%A0%88%E7%9A%84%E5%8E%8B%E5%85%A5%E5%BC%B9%E5%87%BA%E5%BA%8F%E5%88%97
// desc: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
public class q_31栈的压入_弹出序列 {

    // 使用一个栈来模拟压入弹出操作
    Stack<Integer> s = new Stack<>();
    public boolean IsPopOrder(int[] pushList, int[]  popList) {
        int n = pushList.length;
        s.clear();

        for (int i = 0, j = 0; i < n; i++) {
            s.push(pushList[i]);
            while (!s.isEmpty() && j < popList.length && s.peek() == popList[j]) {
                s.pop();
                j++;
            }
        }

        return s.isEmpty();
    }

}


