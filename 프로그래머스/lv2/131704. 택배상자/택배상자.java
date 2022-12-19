import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 1; i <= order.length; i++) {
            if (i != order[index]) {
                stack.add(i);
                continue;
            }
            index++;
            answer++;
            
            while (!stack.isEmpty() && order[index] == stack.peek()) {
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}