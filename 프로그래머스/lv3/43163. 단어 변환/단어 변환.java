class Solution {
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int diff = 0;
                for (int j = 0; j < begin.length(); j++)
                    if (words[i].charAt(j) != begin.charAt(j))
                        diff++;

                if (diff == 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, visited, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}