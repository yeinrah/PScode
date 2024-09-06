class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {"4", "1", "2"};
        while (n > 3) {
            sb.append(arr[n % 3]);
            if (n % 3 == 0)
                n = n / 3 - 1;
            else
                n /= 3;
        }
        sb.append(arr[n % 3]);
        return sb.reverse().toString();
    }
}