package com.swordToOffer.q30_39;

import java.util.Stack;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#30-%E5%8C%85%E5%90%AB-min-%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88
// desc: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
public class q_30包含Min函数的栈 {

    class Solution {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            s.push(node);
            minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
        }

        public void pop() {
            if (s.isEmpty()) {
                throw new NullPointerException("is empty");
            } else {
                s.pop();
                minStack.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}

