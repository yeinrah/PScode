class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (long i = 1; i <= r2; i++)
            answer += (long) Math.sqrt((long) r2 * r2 - (long) i * i) + 1;
        for (long i = 1; i <= r1; i++) {
            double tmp = Math.sqrt((long) r1 * r1 - (long) i * i) + 1;
            if ((long) tmp == tmp)
                answer++;
            answer -= (long) tmp;
        }
        return answer * 4;
    }
}