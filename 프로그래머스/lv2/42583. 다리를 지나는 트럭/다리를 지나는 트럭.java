import java.util.*;

class Solution {    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int t : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                }
                if (q.size() == bridge_length)
                    sum -= q.poll();
                else {
                    if (sum + t > weight) {
                        q.add(0);
                        answer++;
                    }
                    else {
                        q.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}