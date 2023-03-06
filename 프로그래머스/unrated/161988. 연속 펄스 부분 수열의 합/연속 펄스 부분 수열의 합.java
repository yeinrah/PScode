class Solution {
    public long solution(int[] sequence) {
        long[] sum = new long[sequence.length + 1];
        for (int i = 1; i < sum.length; i++) {
            if (i % 2 == 0)
                sum[i] = sum[i - 1] - (long) sequence[i - 1];
            else
                sum[i] = sum[i - 1] + (long) sequence[i - 1];
        }
        
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }
        return Math.abs(max - min);
    }
}