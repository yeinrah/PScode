import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1)
            return 0;
        
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        out : for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < sb.length(); j++) {
                Character c = sb.charAt(j);
                if (c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else {
                    if (stack.size() == 0)
                        continue out;
                    else {
                        if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']'))
                            stack.pop();
                    }
                }
            }
            if (stack.size() == 0)
                answer++;
        }
        return answer;
    }
}