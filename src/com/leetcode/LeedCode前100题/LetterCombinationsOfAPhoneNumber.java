import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.tools.javac.util.List;

class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) backtrack("", digits);

        return output;
    }
    
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) output.add(combination); // the combination is done

        // if there are still digits to check
        else {
            // iterate over all letteers which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) { // 处理 3 或者 4 letter 情况
                String letter = letters.substring(i, i + 1);
                 // apend the current letter to the combination
                 // add proceed to the next digits
                 backtrack(combination + letter, next_digits.substring(1));                
            }
        }
    }
}
