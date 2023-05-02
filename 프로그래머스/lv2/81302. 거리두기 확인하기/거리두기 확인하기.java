import java.util.*;

class Solution {
    static class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            int ok = 1;
            char[][] map = new char[5][5];
            for (int j = 0; j < 5; j++)
                map[j] = places[i][j].toCharArray();
            
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 5; k++)
                    if (map[j][k] == 'P')
                        if (!check(map, j, k))
                            ok = 0;
            answer[i] = ok;
        }
        return answer;
    }
    
    public boolean check(char[][] map, int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;
                
                int d = Math.abs(nx - x) + Math.abs(ny - y);
                
                if (map[nx][ny] == 'P' && d <= 2)
                    return false;
                else if (map[nx][ny] == 'O' && d < 2)
                    q.add(new Pos(nx, ny));
            }
        }
        return true;
    }
}