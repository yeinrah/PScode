import java.util.*;
import java.util.Map.*;

// 참고 : https://fbtmdwhd33.tistory.com/249
class Solution {
    static HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for (int c : course) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (String o : orders) {
                StringBuilder sb = new StringBuilder();
                if (c <= o.length())
                    combi(o, sb, 0, 0, c);
            }
            for( Entry<String, Integer> entry : map.entrySet())
                max = Math.max(max, entry.getValue());
            for (Entry<String, Integer> entry : map.entrySet())
                if (max >= 2 && entry.getValue() == max)
                    list.add(entry.getKey());
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    
    public static void combi(String order, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n)
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        
        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combi(order, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }
}