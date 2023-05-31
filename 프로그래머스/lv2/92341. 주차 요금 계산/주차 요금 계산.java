import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();
        for (String r : records) {
            String[] split = r.split(" ");
            int num = Integer.parseInt(split[1]);
            int time = Integer.parseInt(split[0].substring(0, 2)) * 60 + Integer.parseInt(split[0].substring(3, 5));
            if (split[2].equals("IN")) {
                map.put(num, time);
                res.put(num, res.getOrDefault(num, 0));
            }
            else {
                res.put(num, res.get(num) + time - map.get(num));
                map.remove(num);
            }
        }
        
        int[] answer = new int[res.size()];
        List<Integer> list = new ArrayList<>(res.keySet());
        Collections.sort(list);
        for (int i = 0; i < res.size(); i++) {
            int time = 0;
            if (map.get(list.get(i)) != null)
                time = 1439 - map.get(list.get(i)) + res.get(list.get(i));
            else
                time = res.get(list.get(i));
            
            if (time <= fees[0])
                answer[i] = fees[1];
            else {
                time -= fees[0];
                time = time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1;
                answer[i] = fees[1] + time * fees[3];
            }
        }
        return answer;
    }
}