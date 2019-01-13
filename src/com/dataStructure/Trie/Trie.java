package dataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeedCode3
 * @description: trie 基础
 * @author: Mr.Zhou
 * @create: 2019-01-11 16:53
 **/

/**
 * 在英文环境下 默认Character对象
 */
public class Trie {

    private class Node {

        public boolean isWord; // 标识符确认是否为单词
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this.isWord = false;
            next = new HashMap<>();
        }

    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中存储的单词数量
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     *
     * @param word
     */
    public void add(String word) {
        char[] c = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < c.length; i++) {
            char tag = c[i];
            if (cur.next.get(tag) == null)
                cur.next.put(tag, new Node());
            cur = cur.next.get(c);
        }
        // 防止重复
        if (!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否存在
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
