class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        
        int gcd = gcd(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gcd;
        
        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
        int c = a % b;
        if (c == 0)
            return b;
        else
            return gcd(b, c);
    }
}