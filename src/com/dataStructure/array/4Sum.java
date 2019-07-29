import java.util.HashMap;

/**
 * 454 4Sum solution
 * 1. fuck it (N4)
 * 2. use window (N3)
 * 3. space ex time HashMap (N2) space N2
 */

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                int value = map.containsKey(sum) ? map.get(sum) + 1 : 1;
                map.put(sum, value);
            }
        }
    
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
               int sum = A[i] + B[j];
               if (map.containsKey(-sum))
                    res += map.get(-sum);
            }
        }
        return res;
    }
}

// use func map getOrdefault
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }
}

// conpare the array length
// use func map getOrdefault
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        // fixme: 四个数查找出最小的两个数 

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }
}