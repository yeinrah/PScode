class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        out : for (int i = 0; i < prices.length; i++) {
            int t = 0;
            for (int j = i + 1; j < prices.length; j++) {
                t++;
                if (prices[i] > prices[j]) {
                    answer[i] = t;
                    continue out;
                }
            }
            answer[i] = t;
        }
        return answer;
    }
}