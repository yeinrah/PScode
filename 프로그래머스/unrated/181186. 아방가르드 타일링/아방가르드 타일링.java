class Solution {
    public long solution(int n) {
        long[] dp = new long[100001];
        long[] cache = {8, 0, 2};
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        for (int i = 4; i <= n; i++) {
            int remainder = i % 3;
            long sum = cache[remainder];
            long plus = i % 3 == 0 ? 4 : 2;
            sum += dp[i - 1] * 1;
            sum += dp[i - 2] * 2;
            sum += dp[i - 3] * 5;
            sum += plus;
            sum %= 1000000007;
            cache[remainder] += dp[i - 1] * 2;
            cache[remainder] += dp[i - 2] * 2;
            cache[remainder] += dp[i - 3] * 4;
            cache[remainder] %= 1000000007;
            dp[i] = sum;
        }
        return dp[n];
    }
}