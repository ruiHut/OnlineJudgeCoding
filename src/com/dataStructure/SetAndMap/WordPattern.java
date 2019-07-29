import java.util.HashMap;
import java.util.Map;

/**
 * 290 word patrtern
 */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        Map<K,V> index = new HashMap<>();
        for (int i = 0; i < words.length; i++) 
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) return false;

        return true;
    }
}