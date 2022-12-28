import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : tangerine) {
            if (map.get(i) == null)
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }
        List<Integer> keyList = new ArrayList<Integer>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        for (int key : keyList) {
            if (k > 0) {
                k -= map.get(key);
                answer++;
            }
        }
        return answer;
    }
}