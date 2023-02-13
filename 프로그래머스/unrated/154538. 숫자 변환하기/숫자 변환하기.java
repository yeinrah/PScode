class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y * 3 + 1];
        for (int i = x + 1; i <= y; i++)
            dp[i] = 3000001;
        for (int i = x; i < y; i++) {
            dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        return dp[y] == 3000001 ? -1 : dp[y];
    }
}