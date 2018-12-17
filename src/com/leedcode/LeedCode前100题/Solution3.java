import java.util.ArrayList;
import java.util.List;

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