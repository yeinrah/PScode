import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Long> arr = new ArrayList<Long>();
        
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            answer[i] = arr.get(i).intValue();
        return answer;
    }
}