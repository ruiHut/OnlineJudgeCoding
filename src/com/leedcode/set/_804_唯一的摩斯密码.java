package com.leedcode.set;

import java.util.TreeSet;

/**
 * @program: HUTRepository
 * @description: 804
 * @author: Mr.Zhou
 * @create: 2018-12-02 10:31
 **/

public class _804_唯一的摩斯密码 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String s : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
              builder.append(codes[s.charAt(i) - 'a']);
            }

            set.add(builder.toString());
        }
        return set.size();
    }
}
