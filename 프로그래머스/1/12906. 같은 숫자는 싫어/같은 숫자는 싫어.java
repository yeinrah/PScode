import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (q.isEmpty())
                q.add(i);
            else if (q.peek() != i) {
                list.add(q.poll());
                q.add(i);
            }
        }
        while (!q.isEmpty())
            list.add(q.poll());
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}