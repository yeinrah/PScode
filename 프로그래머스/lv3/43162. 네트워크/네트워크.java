class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        return answer;
    }
    
    public void dfs(int[][] computers, int idx) {
        visited[idx] = true;
        for (int i = 0; i < computers.length; i++)
            if (!visited[i] && computers[idx][i] == 1 && i != idx)
                dfs(computers, i);
    }
}