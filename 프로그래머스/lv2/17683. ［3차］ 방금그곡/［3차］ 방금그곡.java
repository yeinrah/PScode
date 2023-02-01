class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int min = Integer.MIN_VALUE;
        m = replace(m);
        
        for (String s : musicinfos) {
            String[] split = s.split(",");
            int startHour = Integer.parseInt(split[0].split(":")[0]);
            int endHour = Integer.parseInt(split[1].split(":")[0]);
            int startMin = Integer.parseInt(split[0].split(":")[1]);
            int endMin = Integer.parseInt(split[1].split(":")[1]);
            int duration = (endHour - startHour) * 60 + (endMin - startMin);
            String melody = replace(split[3]);
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < duration; i++)
                sb.append(melody.charAt(i % melody.length()));
            
            if (sb.toString().contains(m) && duration > min) {
                answer = split[2];
                min = duration;
            }
        }
        return answer;
    }
    
    public String replace(String s) {
        StringBuilder sb  = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#') {
                sb.setCharAt(i - 1, Character.toLowerCase(sb.charAt(i - 1)));
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}