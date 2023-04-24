import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        
        String[] split = sb.toString().split("0");
        for (String s : split) {
            if (s.equals(""))
                continue;
            if (isPrime(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long l) {
        if (l < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(l); i++)
            if (l % i == 0)
                return false;
        return true;
    }
}