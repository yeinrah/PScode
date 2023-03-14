class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int sum = 0;
        for (int i : sides) {
            sum += i;
            max = Math.max(max, i);
        }
        sum -= max;
        if (max < sum)
            return 1;
        else
            return 2;
    }
}