import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville)
            pq.add(s);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (pq.size() >= 1 && curr < K) {
                int curr2 = pq.poll();
                pq.add(curr + curr2 * 2);
                answer++;
            }
            else if (pq.size() < 1 && curr < K)
                return -1;
        }
        return answer;
    }
}