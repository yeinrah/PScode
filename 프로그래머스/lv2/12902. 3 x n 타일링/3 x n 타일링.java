public class Solution {
    public int solution(int n) {
        final int mod = 1000000007;
        long unique = 0;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i<=n; i+=2) {
            unique += (2 * dp[i - 4]) % mod;
            dp[i] = (3 * dp[i - 2] + unique) % mod;
        }

        return (int) dp[n];
    }
}