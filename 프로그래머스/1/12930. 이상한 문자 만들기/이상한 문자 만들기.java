class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (String split : s.split(" ", -1)) {
            for (int i = 0; i < split.length(); i++) {
                if (i % 2 == 0)
                    sb.append(split.substring(i, i + 1).toUpperCase());
                else if (i % 2 == 1)
                    sb.append(split.substring(i, i + 1).toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().substring(0, s.length());
    }
}