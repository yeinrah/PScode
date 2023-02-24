class Solution {
    public int solution(String[] board) {
        int o = 0;
        int x = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O')
                    o++;
                if (board[i].charAt(j) == 'X')
                    x++;
            }
        }

        if (o < x || o - x > 1)
            return 0;

        if (check(board,'O'))
            if (o - x != 1)
                return 0;
        
        if (check(board,'X'))
            if (o != x)
                return 0;

        return 1;
    }

    public boolean check(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++)
                if (board[i].charAt(j) != c)
                    flag = false;
            if (flag)
                return flag;
        }

        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            for (int j = 0; j < 3; j++)
                if (board[j].charAt(i) != c)
                    flag = false;
            if (flag)
                return flag;
        }
        
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)
            return true;

        return false;
    }
}