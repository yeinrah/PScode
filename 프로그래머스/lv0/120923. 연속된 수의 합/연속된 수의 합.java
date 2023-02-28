class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center = total / num;
        int div = num / 2;
        if (num % 2 == 1) {
            int n = -div;
            for (int i = 0; i < num; i++)
                answer[i] = center + n++;
        }
        else {
            int n = -div + 1;
            for (int i = 0; i < num; i++)
                answer[i] = center + n++;
        }
        return answer;
    }
}