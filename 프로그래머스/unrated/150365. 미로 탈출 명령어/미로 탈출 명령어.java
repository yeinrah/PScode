class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] direction = {"d","l","r","u"};
    static String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if (!canArrive(x, y, r, c, k))
            return "impossible";
        dfs(n, m, x, y, r, c, k - 1, "");
        return answer;
    }
    
    public boolean canArrive(int x, int y, int r, int c, int k) {
        int d = Math.abs(x - r) + Math.abs(y - c);
        if (d > k || (k - d) % 2 == 1)
            return false;
        return true;
    }
    
    public void dfs(int n, int m, int x, int y, int r, int c, int cnt, String route) {
        if (answer.length() > 0 || cnt < 0)
            return;
        
        for(int i = 0 ; i < 4 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            String dir = direction[i];
            if (nx <= 0 || nx > n || ny <= 0 || ny > m || !canArrive(nx, ny, r, c, cnt))
                continue;
            if (nx == r && ny == c && cnt == 0) {
                answer = route + dir;
                return;
            }
            dfs(n, m, nx, ny, r, c, cnt - 1, route + dir);
        }
    }
}