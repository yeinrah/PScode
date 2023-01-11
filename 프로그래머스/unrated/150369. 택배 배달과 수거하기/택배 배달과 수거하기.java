import java.util.*;

// https://velog.io/@seunghyun97/%ED%83%9D%EB%B0%B0-%EB%B0%B0%EB%8B%AC%EA%B3%BC-%EC%88%98%EA%B1%B0%ED%95%98%EA%B8%B0 참고
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0)
                dStack.add(i);
            if (pickups[i] > 0)
                pStack.add(i);
        }
        
        while (!dStack.isEmpty() && !pStack.isEmpty()) {
            answer += Math.max((dStack.peek() + 1) * 2, (pStack.peek() + 1) * 2);
            int box = 0;
            while (!dStack.isEmpty() && box <= cap) {
                if (deliveries[dStack.peek()] + box <= cap)
                    box += deliveries[dStack.peek()];
                else {
                    deliveries[dStack.peek()] -= cap - box;
                    break;
                }
                dStack.pop();
            }
            
            box = 0;
            while (!pStack.isEmpty() && box <= cap) {
                if (pickups[pStack.peek()] + box <= cap)
                    box += pickups[pStack.peek()];
                else {
                    pickups[pStack.peek()] -= cap - box;
                    break;
                }
                pStack.pop();
            }
        }
        
        while (!dStack.isEmpty()) {
            answer += (dStack.peek() + 1) * 2;
            int box = 0;
            while (!dStack.isEmpty() && box <= cap) {
                if (deliveries[dStack.peek()] + box <= cap)
                    box += deliveries[dStack.peek()];
                else {
                    deliveries[dStack.peek()] -= cap - box;
                    break;
                }
                dStack.pop();
            }
        }
        
        while (!pStack.isEmpty()) {
            answer += (pStack.peek() + 1) * 2;
            int box = 0;
            while (!pStack.isEmpty() && box <= cap) {
                if (pickups[pStack.peek()] + box <= cap)
                    box += pickups[pStack.peek()];
                else {
                    pickups[pStack.peek()] -= cap - box;
                    break;
                }
                pStack.pop();
            }
        }
        return answer;
    }
}