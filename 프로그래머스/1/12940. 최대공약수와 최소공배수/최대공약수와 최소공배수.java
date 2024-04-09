class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if (n % m == 0 || m % n == 0) {
            answer[0] = Math.min(n, m);
            answer[1] = Math.max(n, m);
        }
        else {
            for (int i = Math.min(n, m); i > 0; i--) {
                if (n % i == 0 && m % i == 0) {
                    answer[0] = i;
                    break;
                }
            }
            if (answer[0] == 0)
                answer[0] = 1;
            answer[1] = n * m / answer[0];
        }
        return answer;
    }
}