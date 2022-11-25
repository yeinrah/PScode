import java.util.*;

class Solution {
    public long solution(long n) {
        long n2 = n;
        int l = 0;
        while (n2 > 0) {
            n2 /= 10;
            l++;
        }
        Long[] arr = new Long[l];
        for (int i = 0; i < l; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Long i : arr)
            sb.append(String.valueOf(i));
        return Long.parseLong(sb.toString());
    }
}