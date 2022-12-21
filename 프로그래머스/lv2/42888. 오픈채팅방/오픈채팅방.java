import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (s[0].charAt(0) != 'L')
                map.put(s[1], s[2]);
        }
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if (s[0].charAt(0) == 'E')
                list.add(map.get(s[1]) + "님이 들어왔습니다.");
            else if (s[0].charAt(0) == 'L')
                list.add(map.get(s[1]) + "님이 나갔습니다.");
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}