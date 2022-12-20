import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (String s : operations) {
            String[] ss = s.split(" ");
            if (ss[0].equals("I")) {
                minpq.add(Integer.parseInt(ss[1]));
                maxpq.add(Integer.parseInt(ss[1]));
            }
            else if (!minpq.isEmpty() && !maxpq.isEmpty()) {
                if (ss[0].equals("D")) {
                    if (ss[1].equals("1"))
                        minpq.remove(maxpq.poll());
                    else if (ss[1].equals("-1"))
                        maxpq.remove(minpq.poll());
                }
            }
        }
        if (maxpq.isEmpty() && minpq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = maxpq.peek();
            answer[1] = minpq.peek();
        }
        return answer;
    }
}