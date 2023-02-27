import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("},\\{");
        int l = split.length;
        int[] answer = new int[l];
        String[][] tmp = new String[l][];
        for (int i = 0; i < l; i++) {
            String[] ss = split[i].split(",");
            tmp[ss.length - 1] = ss;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                int key = Integer.parseInt(tmp[i][j]);
                if (!set.contains(key)) {
                    answer[i] = key;
                    set.add(key);
                }
            }
        }
        
        return answer;
    }
}