class Solution {
    public int solution(int slice, int n) {
        int ans = n / slice;
        return n % slice == 0 ? ans : ans + 1;
    }
}