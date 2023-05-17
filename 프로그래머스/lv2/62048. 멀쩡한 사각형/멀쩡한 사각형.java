class Solution {
    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        return ((long) w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}