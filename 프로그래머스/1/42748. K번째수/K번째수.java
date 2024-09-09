import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for (int[] comm : commands) {
            int start = comm[0];
            int end = comm[1];
            int index = comm[2];
            
            int[] sub = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(sub);
            answer[idx++] = sub[index - 1];
        }
        
        return answer;
    }
}