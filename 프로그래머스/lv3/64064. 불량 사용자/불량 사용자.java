import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<>(), 0, user_id, banned_id);
        return answer.size();
    }
    
    public void dfs(Set<String> set, int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            answer.add(set);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i]))
                continue;
            if (check(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                dfs(new HashSet<>(set), depth + 1, user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }
    
    public boolean check(String u, String b) {
        if (u.length() != b.length())
            return false;
        for (int i = 0; i < u.length(); i++)
            if (u.charAt(i) != b.charAt(i) && b.charAt(i) != '*')
                return false;
        return true;
    }
}