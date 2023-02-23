import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < days.length; i++) {
            int day = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }
            days[i] = day;
        }
        for (int i = 0; i < days.length - 1; i++)
            if (days[i] > days[i + 1])
                days[i + 1] = days[i];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < days.length; i++)
            map.put(days[i], map.getOrDefault(days[i], 0) + 1);
        int[] answer = new int[map.size()];
        int idx = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i : list) {
            answer[idx] = map.get(i);
            idx++;
        }
        return answer;
    }
}