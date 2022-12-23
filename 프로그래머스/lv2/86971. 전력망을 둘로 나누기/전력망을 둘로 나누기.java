import java.util.*;

// 참고 : https://dlee0129.tistory.com/156
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        List<Integer>[] list = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<Integer>();
        
        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1], n, list);
            int n2 = bfs(wire[1], wire[0], n, list);
            answer = Math.min(answer, Math.abs(n1 - n2));
        }
        
        return answer;
    }
    
    public static int bfs(int i1, int i2, int n, List<Integer>[] list) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n + 1];
        
        int cnt = 0;
        q.add(i1);
        visited[i1] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            cnt++;
            
            for (int next : list[curr]) {
                if (!visited[next] && next != i2) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return cnt;
    }
}