class Solution {
    public int[] solution(int n) {
        int l = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] answer = new int[l];
        for (int i = 0; i < l; i++)
            answer[i] = 2 * i + 1;
        return answer;
    }
}