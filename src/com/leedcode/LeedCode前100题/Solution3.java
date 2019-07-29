import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. longest substring without repeating Charachers 
 * 1. Brute Force (n3)
 * 2. Sliding Window 
 * 3. Sliding Window Optimized (useing hashmap)
 * 4. Java (Assuming ASCII 128)
 */

 class _3_没有重复字符的最长子串 {
    public static void main(String[] args) {
        String s = new String("hello world!");
        Solution3 solution = new Solution3();
    }
}

    public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));// key 为 字符串的数字 value 为子字符串长度
                if (list.size() >= result)
                    result = list.size();
            } else {
                // 重新从 包含的 key之后开始计算
                list = list.subList(list.indexOf(i) + 2, list.size() );
                while (list.contains(s.charAt(i))){
                    list = list.subList(list.indexOf(i) + 2, list.size() );
                }
                list.add(s.charAt(i));
            }
        }
        return result;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        Map<Character, Integer> subStr = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (subStr.containsKey(ch)) {
                i = subStr.get(ch);
                subStr.clear();
            } else {
                subStr.put(ch, i);
                max =  max < subStr.size() ? ++max : max;
            }
        }
        return max;
    }
}

// slidinng window
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                // remove this ch
                set.remove(ch);
                i++;
            } else {
                // put this ch
                set.add(ch);
                j++;
                max = Math.max(j - i, max);
            }
        }
        return max;
    }
}

// Sliding Window Optimized
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

// Java (Assuming ASCLL 128)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}