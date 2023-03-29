class Solution {
    public int solution(String my_string) {
        int answer = 0;
        boolean plus = true;
        String[] split = my_string.split(" ");
        for (String s : split) {
            if (s.equals("+"))
                plus = true;
            else if (s.equals("-"))
                plus = false;
            else {
                if (plus)
                    answer += Integer.parseInt(s);
                else
                    answer -= Integer.parseInt(s);
            }
        }
        return answer;
    }
}