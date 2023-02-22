import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Node {
        int r;
        int c;
        int time;
        
        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int st_r = 0;
        int st_c = 0;
        int lv_r = 0;
        int lv_c = 0;
        boolean lever = false;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    st_r = i;
                    st_c = j;
                }
                else if (maps[i].charAt(j) == 'L') {
                    lv_r = i;
                    lv_c = j;
                }
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(st_r, st_c, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (map[curr.r][curr.c] == 'L') {
                for (int j = 0; j < visited.length; j++)
                    Arrays.fill(visited[j], false);
                q.clear();
                visited[curr.r][curr.c] = true;
                lever = true;
            }
            if (lever && map[curr.r][curr.c] == 'E')
                return curr.time;
            
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == 'X')
                    continue;
                
                visited[nr][nc] = true;
                q.offer(new Node(nr, nc, curr.time + 1));
            }
        }
        return -1;
    }
}