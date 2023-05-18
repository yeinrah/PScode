import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || st.peek() != s.charAt(i))
                st.push(s.charAt(i));
            else
                st.pop();
        }
        if (st.isEmpty())
            answer = 1;

        return answer;
    }
}