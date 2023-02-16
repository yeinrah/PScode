import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        int tmp = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            if (i > 0 && weights[i] == weights[i - 1]) {
                tmp--;
                answer += tmp;
                continue;
            }
            tmp = 0;
            
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i] == weights[j] ||
                    weights[i] * 4 == weights[j] * 3 ||
                    weights[i] * 4 == weights[j] * 2 ||
                    weights[i] * 3 == weights[j] * 2)
                    tmp++;
            }
            answer += tmp;
        }
        return answer;
    }
}