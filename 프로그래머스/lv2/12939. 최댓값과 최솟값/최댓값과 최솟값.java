class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        String[] split = s.split(" ");
        
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        
        answer = String.valueOf(min) + " " + String.valueOf(max);
        
        return answer;
    }
}