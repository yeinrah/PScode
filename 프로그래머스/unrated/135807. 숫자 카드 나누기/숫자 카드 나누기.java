import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int divisor = getDivisor(arrayA, arrayA[arrayA.length - 1]);
        if (divisor != 0) {
            while (!check(arrayB, divisor)) {
                if (divisor == -1)
                    break;
                divisor = getDivisor(arrayA, divisor - 1);
            }
        }
        answer = Math.max(answer, divisor);
        
        divisor = getDivisor(arrayB, arrayB[arrayB.length - 1]);
        if (divisor != 0) {
            while (!check(arrayA, divisor)) {
                if (divisor == -1)
                    break;
                divisor = getDivisor(arrayB, divisor - 1);
            }
        }
        answer = Math.max(answer, divisor);
        return answer;
    }
    
    public int getDivisor(int[] arr, int d) {
        out : for (int i = d; i > 1; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0)
                    continue out;
                if (j == arr.length - 1 && arr[j] % i == 0)
                    return i;
            }
        }
        return -1;
    }
    
    public boolean check(int[] arr, int divisor) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % divisor == 0)
                return false;
        return true;
    }
}