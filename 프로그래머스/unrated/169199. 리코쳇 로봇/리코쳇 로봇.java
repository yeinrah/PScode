import java.util.*;

class Solution {
    static class Pos {
        int x;
        int y;
        int cnt;
        
        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[map.length][map[0].length];
        int stx = 0;
        int sty = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    stx = i;
                    sty = j;
                }
            }
        }
        return bfs(stx, sty);
    }
    
    public int bfs(int stx, int sty) {
        Queue<Pos> q = new LinkedList<>();
        visited[stx][sty] = true;
        q.add(new Pos(stx, sty, 0));
        while(!q.isEmpty()) {
            Pos curr = q.poll();
            if(map[curr.x][curr.y] == 'G')
                return curr.cnt;
            for(int i = 0; i < 4; i++) {
                int nx = curr.x;
                int ny = curr.y;
                while(nx + dx[i] >= 0 && ny + dy[i] >= 0
                      && nx + dx[i] < map.length
                      && ny + dy[i] < map[0].length
                      && map[nx + dx[i]][ny + dy[i]] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pos(nx, ny, curr.cnt + 1));
                }
            }
        }
        return -1;
    }
}