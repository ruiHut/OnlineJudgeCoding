import java.util.ArrayList;
import java.util.List;

/**
 * q_131 solution
 * 1. backTracking
 * 2, DP
 */


// backTracking
class Solution {
    public static  List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) return res;

        backTrack(s, res, 0, new ArrayList<String>());
        return res;
    }

    private static void backTrack(String target, List<List<String>> res, int index, List<String> prev) {
        if (index == target.length())
            res.add(prev);

        for (int curIndex = index; curIndex < target.length(); curIndex++) {
            String cur = target.substring(index, curIndex + 1);
            if (isPartition(cur)) {
                prev.add(cur);
                backTrack(target, res, curIndex + 1, prev);
                prev.remove(prev.size() - 1);
            }
        }
        prev = null;
    }

    private static boolean isPartition(String s) {
        int before = 0, after = s.length() - 1;
        while (before < after) {
            if (s.charAt(before++) != s.charAt(after--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution4.partition("aab");
    }
}

// DB
class Solution {

    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] isPalindrom = new boolean[n][n];

        List<List<String>> result = new ArrayList<>();
        List<String> candidate = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            testForPalindrom(isPalindrom, s, i, i);
            testForPalindrom(isPalindrom, s, i, i+1);
        }

        getPartitions(result, candidate, isPalindrom, s, 0);
        return result;

    }

    private void getPartitions (List<List<String>> result, List<String> candidate, boolean[][] isPalindrom, String s, int start){
        if (start == s.length()) {
            result.add(new ArrayList<>(candidate));
            return;
        }

        for(int i = start;i<s.length();i++){
            if(isPalindrom[start][i]){
                candidate.add(s.substring(start,i+1));
                getPartitions(result,candidate,isPalindrom,s,i+1);
                candidate.remove(candidate.size()-1);
            }
        }
    }

    private void testForPalindrom(boolean[][] isPalindrom, String s, int l, int r){
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            isPalindrom[l][r] = true;
            l--;r++;
        }
    }

}