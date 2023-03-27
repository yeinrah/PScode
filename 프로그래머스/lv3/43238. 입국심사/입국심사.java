import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long st = times[0];
        long ed = (long) times[times.length - 1] * n;
        while (st <= ed) {
            long mid = (st + ed) / 2;
            long sum = 0;
            for (int t : times)
                sum += mid / t;
            if (sum >= n) {
                ed = mid - 1;
                answer = mid;
            }
            else
                st = mid + 1;
        }
        return answer;
    }
}