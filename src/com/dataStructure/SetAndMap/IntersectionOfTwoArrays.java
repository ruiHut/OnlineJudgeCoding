/**
 * 349 intersection of two arrays
 * 1. two set
 * 
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int var : nums1) s1.add(var);

        Set<Integer> s2 = new HashSet<>();
        for (int var : nums2) s2.add(var);

        s1.retainAll(s2);
        int[] res = new int[s1.size()];
        int index = 0;
        for (int var : s1)
            res[index++] = var;
        
        return res;
    }
}