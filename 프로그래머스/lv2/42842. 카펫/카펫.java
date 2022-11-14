class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 3; i < 10000; i++) {
            for (int j = 3; j < 10000; j++) {
                int brownCnt = (i * 2) + (j * 2) - 4;
                int yellowCnt = i * j - brownCnt;
                if (brownCnt == brown && yellowCnt == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}