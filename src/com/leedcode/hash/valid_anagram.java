import java.util.HashMap;
import java.util.Set;

/**
 * 1. sort 
 * 2. hash
 */
class Solution {
    private HashMap sMap;

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        sMap = new HashMap();
        for (char c : s.toCharArray()) {
            if (sMap.containsKey(c)) sMap.put(c, (int)sMap.get(c) + 1);
            else sMap.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c)) {
                int count = (int)sMap.get(c);
                if (count == 1) sMap.remove(c);
                else sMap.put(c, --count);
            } else {
                return false;
            }
        }

        return sMap.isEmpty();
    }
}