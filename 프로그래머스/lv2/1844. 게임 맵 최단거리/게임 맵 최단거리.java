import java.util.*;

class Solution {
    static class Node {
        int r;
        int c;
        int dist;
        
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        visited[0][0] = true;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(0, 0, 1));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.r == maps.length - 1 && curr.c == maps[0].length - 1)
                return curr.dist;
            
            for (int i = 0; i < 4; i++) {
                    int nr = curr.r + dr[i];
                    int nc = curr.c + dc[i];
                    
                if (nr < 0 || nc < 0 || maps.length <= nr || maps[0].length <= nc)
                    continue;
                else if (!visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, curr.dist + 1));
                } 
            }
        }
        return -1;
    }
}