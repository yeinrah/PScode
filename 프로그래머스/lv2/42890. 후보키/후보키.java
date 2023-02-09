import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();
    
    public int solution(String[][] relation) {
        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i + 1, relation);
        }
        return ans.size();
    }
    
    public void dfs(boolean[] visited, int st, int idx, int end, String[][] relation) {
        if (idx == end) {
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(String.valueOf(i));
                    list.add(i);
                }
            }
        
            Set<String> set = new HashSet<>();

            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb2 = new StringBuilder();
                for (int j: list)
                    sb2.append(relation[i][j]);
                if (set.contains(sb2.toString()))
                    return;
                else
                    set.add(sb2.toString());
            }
            
            for (String s : ans) {
                int cnt = 0;
                for (int i = 0; i < sb.length(); i++) {
                    String sub = String.valueOf(sb.charAt(i));
                    if (s.contains(sub))
                        cnt++;
                }
                if (cnt == s.length())
                    return;
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = st; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, i, idx + 1, end, relation);
                visited[i] = false;
            }
        }
    }
}