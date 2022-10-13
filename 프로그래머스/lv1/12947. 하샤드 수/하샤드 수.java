class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int x2 = x;
        while (x2 > 0) {
            sum += x2 % 10;
            x2 /= 10;
        }
        return x % sum == 0 ? true : false;
    }
}