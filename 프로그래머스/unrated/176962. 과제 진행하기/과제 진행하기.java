import java.util.*;

class Solution {
   static class Task {
       String name;
       int startTime;
       int remainingTime;
       
       public Task(String[] info) {
           name = info[0];
           String[] split = info[1].split(":");
           startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
           remainingTime = Integer.parseInt(info[2]);
        }
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> plan = new PriorityQueue<>((a, b) -> Integer.compare(a.startTime, b.startTime));
        Stack<Task> stack = new Stack<>();

        for (String[] p : plans)
            plan.add(new Task(p));

        String[] answer = new String[plans.length];
        int idx = 0;
        int currTime = 0;

        while (!plan.isEmpty() || !stack.isEmpty()) {
            if (plan.isEmpty())
                answer[idx++] = stack.pop().name;
            else if (stack.isEmpty()) {
                currTime = plan.peek().startTime;
                stack.push(plan.poll());
            }
            else {
                if (plan.peek().startTime < currTime + stack.peek().remainingTime) {
                    stack.peek().remainingTime -= plan.peek().startTime - currTime;
                    currTime = plan.peek().startTime;
                    stack.push(plan.poll());
                }
                else {
                    currTime += stack.peek().remainingTime;
                    answer[idx++] = stack.pop().name;
                }
            }
        }
        return answer;
    }
}