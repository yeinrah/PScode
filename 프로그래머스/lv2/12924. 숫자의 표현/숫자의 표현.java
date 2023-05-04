class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            for (int j = 0; j <= n / 2; j++) {
                sum += i + j;
                if (sum == n)
                    answer++;
                else if (sum > n)
                    break;
            }
        }
        return answer;
    }
}