class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int c = 0;
        
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
            answer = false;
            return answer;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                c++;
            else
                c--;
            if (c < 0) {
                answer = false;
                return answer;
            }
        }
        
        if (c != 0)
            answer = false;

        return answer;
    }
}