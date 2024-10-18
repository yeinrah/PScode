import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = len - 1; i >= 0; i--) {
            if (len - i <= citations[i])
                answer = len - i;
        }
        
        return answer;
    }
}