class Solution {
    public int solution(int[] numbers) {
        int max = 0;
        int idx = 0;
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                idx = i;
            }
        }
        for (int i = 0; i < numbers.length; i++)
            if (i != idx)
                answer = Math.max(answer, max * numbers[i]);
        return answer;
    }
}