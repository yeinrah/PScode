import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reporter = new HashMap<>();
        Map<String, Integer> reported = new HashMap<>();
        
        Set<String> reportSet = new HashSet<>();
        for (String r : report)
            reportSet.add(r);
        List<String> reportList = new ArrayList<>(reportSet);
        for (String r : reportList) {
            String[] split = r.split(" ");
            Set<String> set;
            if (reporter.get(split[0]) != null)
                set = reporter.get(split[0]);
            else
                set = new HashSet<>();
            set.add(split[1]);
            reporter.put(split[0], set);
            
            reported.put(split[1], reported.getOrDefault(split[1], 0) + 1);
        }
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            if (reporter.get(id_list[i]) == null)
                continue;
            Set<String> set = reporter.get(id_list[i]);
            List<String> list = new ArrayList<>(set);
            for (int j = 0; j < list.size(); j++)
                if (reported.get(list.get(j)) >= k)
                    cnt++;
            answer[i] = cnt;
        }
        return answer;
    }
}