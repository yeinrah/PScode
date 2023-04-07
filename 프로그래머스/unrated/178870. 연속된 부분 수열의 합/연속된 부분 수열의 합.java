class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] dp = new int[sequence.length + 1];
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < sequence.length; i++)
            dp[i + 1] = sequence[i] + dp[i];

        int left = 0;
        int right = 0;

        while (left < sequence.length && right < sequence.length 
               && left <= right) {
            int sum = dp[right + 1] - dp[left];
            if (sum == k) {
                int now = right - left;
                if (min > now) {
                    answer[0] = left;
                    answer[1] = right;
                    min = now;
                }
            }
            if (sum < k)
                right++;
            else
                left++;
        }
        return answer;
    }
}