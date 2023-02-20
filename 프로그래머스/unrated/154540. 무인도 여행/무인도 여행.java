import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Node {
        int r;
        int c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(String[] maps) {
        // maps 파싱
        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++)
            for (int j = 0; j < maps[0].length(); j++)
                if (maps[i].charAt(j) != 'X')
                    map[i][j] = maps[i].charAt(j) - '0';
        
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Node> q = new LinkedList<>();
        
        // bfs
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;

                    int sum = 0;
                    
                    while (!q.isEmpty()) {
                        Node curr = q.poll();
                        sum += map[curr.r][curr.c];

                        for (int d = 0; d < 4; d++) {
                            int nr = curr.r + dr[d];
                            int nc = curr.c + dc[d];

                            // 범위 벗어나면 아웃
                            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length)
                                continue;
                            // 바다면 아웃
                            if (map[nr][nc] == 0)
                                continue;
                            // 이미 들른곳이면 아웃
                            if (visited[nr][nc])
                                continue;

                            q.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                ans.add(sum);
                }
            }
        }
        
        if (ans.size() == 0)
            return new int[] {-1};
        
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
        
    }
}