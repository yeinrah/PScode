class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center = total / num;
        int div = num / 2;
        int n = num % 2 == 0 ? -div + 1 : -div;
        for (int i = 0; i < num; i++)
            answer[i] = center + n++;
        return answer;
    }
}