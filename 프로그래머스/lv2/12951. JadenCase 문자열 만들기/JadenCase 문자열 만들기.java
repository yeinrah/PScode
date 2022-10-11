class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] split = s.toLowerCase().split("");
        
        boolean flag = true;
        
        for (int i = 0 ; i < split.length; i++) {
            if (flag) {
                sb.append(split[i].toUpperCase());
                flag = false;
            }
            else if (!flag)
                sb.append(split[i]);
            if (split[i].equals(" "))
                flag = true;
        }
        
        return sb.toString();
    }
}