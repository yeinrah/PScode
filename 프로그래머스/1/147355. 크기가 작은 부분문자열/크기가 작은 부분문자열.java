class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long longP = Long.parseLong(p);
        for (int i = 0; i <= t.length() - len; i++)
            if (longP >= Long.parseLong(t.substring(i, i + len)))
                answer++;
        return answer;
    }
}