class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int idx = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] >= section[idx] + m) {
                answer++;
                idx = i;
            }
        }
        return answer;
    }
}