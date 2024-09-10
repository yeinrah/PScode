class Solution {
    static int answer = 0;
    static int[] arr;
    public int solution(int[] number) {
        
        arr = number;
        dfs(0, 0, 0);
        
        return answer;
    }
    
    public void dfs(int sum, int cnt, int idx) {
        if (cnt == 3) {
            if (sum == 0)
                answer++;
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            dfs(sum + arr[i], cnt + 1, i + 1);
        }
    }
}