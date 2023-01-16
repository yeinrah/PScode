import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int open = 0;
        int idx = 0;
        
        // 1
        if (p.length() == 0)
            return answer;
        
        // 2
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                open++;
            else
                open--;
            if (open == 0) {
                idx = i;
                break;
            }
        }
        u.append(p.substring(0, idx + 1));
        v.append(p.substring(idx + 1, p.length()));
        
        // 3
        if (check(u.toString()))
            // 3-1
            answer = u.append(solution(v.toString())).toString();
        // 4
        else {
            // 4-1
            StringBuilder sb = new StringBuilder("(");
            // 4-2, 4-3
            sb.append(solution(v.toString()) + ')');
            // 4-4
            String tmp = u.substring(1, u.length() - 1);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }
            // 4-5
            return sb.toString();
        }
        return answer;
    }
    
    public boolean check(String s) {
        int open = 0;
        if (s.charAt(0) == ')')
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            else
                open--;
            if (open < 0)
                return false;
        }
        return true;        
    }
}