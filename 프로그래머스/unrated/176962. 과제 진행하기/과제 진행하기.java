import java.util.*;

class Solution {
    static class Task {
        String name;
        int remainingTime;
        
        public Task(String name, int remainingTime) {
            this.name = name;
            this.remainingTime = remainingTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Task> stack = new Stack<>();
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                int hourDiff = Integer.parseInt(a[1].substring(0, 2)) - Integer.parseInt(b[1].substring(0, 2));
                int minDiff = Integer.parseInt(a[1].substring(3, 5)) - Integer.parseInt(b[1].substring(3, 5));
                if (hourDiff < 0 || (hourDiff == 0 && minDiff < 0))
                    return -1;
                else
                    return 1;
            }
        });
        
        int idx = 0;
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int hour = Integer.parseInt(plans[i][1].substring(0, 2));
            int min = Integer.parseInt(plans[i][1].substring(3, 5));
            int playtime = Integer.parseInt(plans[i][2]);
            
            if (i == plans.length - 1) {
                stack.add(new Task(name, playtime));
                break;
            }
            
            int nextHour = Integer.parseInt(plans[i + 1][1].substring(0, 2));
            int nextMin = Integer.parseInt(plans[i + 1][1].substring(3, 5));
            int timeDiff = (nextHour - hour) * 60 + (nextMin - min);
            if (timeDiff < playtime)
                stack.add(new Task(name, playtime - timeDiff));
            else if (timeDiff > playtime) {
                answer[idx] = name;
                idx++;
                if (!stack.isEmpty()) {
                    int time = timeDiff - playtime;
                    while (time > 0) {
                        if (stack.isEmpty())
                            break;
                        Task task = stack.pop();
                        if (task.remainingTime <= time) {
                            time -= task.remainingTime;
                            answer[idx] = task.name;
                            idx++;
                        }
                        else {
                            task.remainingTime -= time;
                            time -= time;
                            stack.add(new Task(task.name, task.remainingTime));
                        }
                    }
                }
            }
            else {
                answer[idx] = name;
                idx++;
            }
        }
        while (!stack.isEmpty()) {
            Task task = stack.pop();
            answer[idx] = task.name;
            idx++;
        }
        return answer;
    }
}