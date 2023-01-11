import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;
        for (int p : priorities)
            pq.add(p);
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location)
                        return answer;
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}