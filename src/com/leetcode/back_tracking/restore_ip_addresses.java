import java.util.ArrayList;
import java.util.List;

/**
 * q_93
 */

// backTracking
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.isEmpty() || s.length() > 12) return list;

        helper(s, list, 0, "", 0);
        return list;
    }

    private void helper(String s, List<String> list, int pos, String res, int sec) {
        if (sec == 4 && pos == s.length()) {
            list.add(res);
            return;
        }

        // 遍历当前 sec 分到IP地址位数为 1， 2， 3 的所有可能
        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) break;
            // 获取当前 section 的IP大小
            String section = s.substring(pos, pos + i);
            // is valid section
            if (section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) >= 256) break;
            helper(s, list, pos + i, sec == 0 ? section : res + "." + section, sec + 1);
        }
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) return res;

        backTrack(s, res, 0, "", 0);
        return res;
    }

    private void backTrack(String target, List<String> res, int index, String prev, int sec) {
        if (sec == 4 && index == target.length()) {
            res.add(prev);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > target.length()) break;

            String curString = target.substring(index, index + i);
            if (curString.length() > 0 && curString.startsWith("0") || Integer.valueOf(curString) > 255) break;
            backTrack(target, res, index + i, sec == 0 ? curString : curString + "." + prev, sec++);
        }
    }
}