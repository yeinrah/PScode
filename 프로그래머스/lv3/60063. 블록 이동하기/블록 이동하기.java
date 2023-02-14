import java.util.*;

class Solution {
    static class Node {
        int x1;
        int x2;
        int y1;
        int y2;
        int time;
        int vertical;
        
        Node(int x1, int y1, int x2, int y2, int time, int vertical) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;
            this.vertical = vertical;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[board.length][board.length][2];
        
        q.offer(new Node(0, 0, 0, 1, 0, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            // 범위밖이면 아웃
            if (oob(node.x1, board.length) || oob(node.y1, board.length) || oob(node.x2, board.length) || oob(node.y2, board.length))
                continue;
            // 벽이면 아웃
            if (board[node.x1][node.y1] == 1 || board[node.x2][node.y2] == 1)
                continue;
            // 방문한 곳이면 아웃
            if (visited[node.x1][node.y1][node.vertical] && visited[node.x2][node.y2][node.vertical])
                continue;
            // 도착하면 끝
            if ((node.x1 == board.length - 1 && node.y1 == board.length - 1) ||
               (node.x2 == board.length - 1 && node.y2 == board.length - 1)) {
                answer = node.time;
                break;
            }
            
            visited[node.x1][node.y1][node.vertical] = true;
            visited[node.x2][node.y2][node.vertical] = true;
            
            for (int i = 0; i < 4; i++) {
                int nx1 = node.x1 + dir[i][0];
                int ny1 = node.y1 + dir[i][1];
                int nx2 = node.x2 + dir[i][0];
                int ny2 = node.y2 + dir[i][1];
                
                q.offer(new Node(nx1, ny1, nx2, ny2, node.time + 1, node.vertical));
            }
            
            if (node.vertical == 1) {
                if (node.y1 - 1 >= 0 && board[node.x1][node.y1 - 1] == 0 && board[node.x2][node.y2 - 1] == 0) {
                    q.offer(new Node(node.x1, node.y1, node.x1, node.y1 - 1, node.time + 1, 0));
                    q.offer(new Node(node.x2, node.y2, node.x2, node.y2 - 1, node.time + 1, 0));
                }
                
                if (node.y1 + 1 <= board.length - 1 && board[node.x1][node.y1 + 1] == 0 && board[node.x2][node.y2 + 1] == 0) {
                    q.offer(new Node(node.x1, node.y1, node.x1, node.y1 + 1, node.time + 1, 0));
                    q.offer(new Node(node.x2, node.y2, node.x2, node.y2 + 1, node.time + 1, 0));
                }
            }
            else {
                if (node.x1 - 1 >= 0 && board[node.x1 - 1][node.y1] == 0 && board[node.x2 - 1][node.y2] == 0) {
                    q.offer(new Node(node.x1, node.y1, node.x1 - 1, node.y1, node.time + 1, 1));
                    q.offer(new Node(node.x2, node.y2, node.x2 - 1, node.y2, node.time + 1, 1));
                }
                
                if (node.x1 + 1 <= board.length - 1 && board[node.x1 + 1][node.y1] == 0 && board[node.x2 + 1][node.y2] == 0) {
                    q.offer(new Node(node.x1, node.y1, node.x1 + 1, node.y1, node.time + 1, 1));
                    q.offer(new Node(node.x2, node.y2, node.x2 + 1, node.y2, node.time + 1, 1));
                }
            }
        }
        return answer;
    }
    
    public boolean oob(int x, int l) {
        return x < 0 || x >= l;
    }
}