import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        String[] split = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (String s : split)
            dict.add(s);
        
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder curr = new StringBuilder();
            curr.append(msg.charAt(i));
            int idx = 1;
            while (i + idx < msg.length() && dict.contains(curr.toString()))
                curr.append(msg.charAt(i + idx++));
            if (!dict.contains(curr.toString())) {
                dict.add(curr.toString());
                curr.deleteCharAt(curr.length() - 1);
            }
            answer.add(dict.indexOf(curr.toString()));
                
            if (curr.length() > 1)
                i += curr.length() - 1;
        }
        return answer;
    }
}