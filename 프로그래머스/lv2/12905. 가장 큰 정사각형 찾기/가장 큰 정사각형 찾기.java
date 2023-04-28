class Solution{
    public int solution(int[][] board) {
        int answer = 0;
        int m = board.length;
        int n = board[0].length;
        
        if (m < 2 || n < 2)
            return 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] != 0)
                    board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                if (answer < board[i][j])
                    answer = board[i][j];
            }
        }
        return answer * answer;
    }
}