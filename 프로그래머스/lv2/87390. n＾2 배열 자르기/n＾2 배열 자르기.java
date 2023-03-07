class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        for (long i = left; i <= right; i++) {
            if (i / n == 0)
                answer[(int)(i - left)] = (int)(i % n) + 1;
            else {
                if (i % n <= i / n)
                    answer[(int)(i - left)] = (int)(i / n) + 1;
                else
                    answer[(int)(i - left)] = (int)(i % n) + 1;
            }
        }
        return answer;
    }
}