class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[][] newBoard = new int[r + 1][c + 1];
        
        for (int[] s : skill) {
            if (s[0] == 1) {
                newBoard[s[1]][s[2]] -= s[5];
                newBoard[s[1]][s[4] + 1] += s[5];
                newBoard[s[3] + 1][s[2]] += s[5];
                newBoard[s[3] + 1][s[4] + 1] -= s[5];
            }
            else {
                newBoard[s[1]][s[2]] += s[5];
                newBoard[s[1]][s[4] + 1] -= s[5];
                newBoard[s[3] + 1][s[2]] -= s[5];
                newBoard[s[3] + 1][s[4] + 1] += s[5];
            }
        }
        
        for (int i = 0; i < r + 1; i++)
            for (int j = 0; j < c; j++)
                newBoard[i][j + 1] += newBoard[i][j];
        
        for (int i = 0; i < c + 1; i++)
            for (int j = 0; j < r; j++)
                newBoard[j + 1][i] += newBoard[j][i];
        
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (newBoard[i][j] + board[i][j] > 0)
                    answer++;
        return answer;
    }
}