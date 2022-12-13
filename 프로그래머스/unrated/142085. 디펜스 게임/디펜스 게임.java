import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < enemy.length; i++) {
            // pq에 집어넣고
            pq.add(enemy[i]);
            // 무적권보다 라운드수가 많아지면 작은 수부터 계산
            if (pq.size() > k)
                n -= pq.poll();
            // 남은 병사수가 0보다 적어지면 해당 라운드가 한계이므로 리턴
            if (n < 0)
                return i;
        }
        return enemy.length;
    }
}