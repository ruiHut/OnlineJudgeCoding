import java.awt.List;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    private HashMap mappings;

    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack stack = new Stack<>();
        for (int i = 0; i < s.length() -1; i++) {
            char temp = s.charAt(i);
            if (mappings.containsKey(temp))
            {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) 
                  return false;
            } else{
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}