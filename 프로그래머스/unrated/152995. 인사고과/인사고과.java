import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int max = 0;
        int[] wanho = scores[0];
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int[] s : scores) {
            if (s[1] < max) {
                if (wanho[0] == s[0] && wanho[1] == s[1])
                    return -1;
            }
            else {
                max = Math.max(s[1], max);
                if (wanho[0] + wanho[1] < s[0] + s[1])
                    answer++;
            }
        }
        return answer;
    }
}