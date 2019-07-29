import java.util.ArrayList;
import java.util.List;

/**
 * q 22 solution
 * 1. 递归 + 剪枝
 */
class Solution {
    List<String> res = new ArrayList<>();
    char[] ch = new char[]{')', '('};
    public List<String> generateParenthesis(int n) {
        // ending time
        if (n == 0) return res;
        for (int i = 0; i < n; i++) {
            if (n == 0) {
                for (int j = 0; j < res.size(); j++) {
                    
                }
            } else {

            }
        }


        generateParenthesis(n - 1);
        return res;
    }
}