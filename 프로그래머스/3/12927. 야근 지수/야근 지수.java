import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            sum += works[i];
            pq.add(works[i]);   
        }
        
        if (sum < n)
            return 0;
        
        while (n > 0) {
            int max = pq.poll();
            pq.add(--max);
            n--;
        }
        
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            answer += curr * curr;
        }
        
        return answer;
    }
}