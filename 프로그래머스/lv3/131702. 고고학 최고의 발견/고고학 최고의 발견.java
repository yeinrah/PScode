class Solution {
    public int solution(int[][] clockHands) {
        int answer = Integer.MAX_VALUE;
        int l = clockHands.length;
        for (int i = 0; i < Math.pow(4, l); i++) {
            int[][] arr = new int[l][l];
            for (int j = 0; j < l; j++)
                arr[j] = clockHands[j].clone();
            int count = 0;
            int a = i;
            for (int j = 0; j < l; j++) {   
                int cnt = (int) Math.floor(a % 4);
                a /= 4;
                arr = rotate(arr, 0, j, cnt);
                count += cnt;
            }

            for (int r = 1; r < l; r++) {
                for (int c = 0; c < l; c++) {
                    int cnt = (4 - arr[r - 1][c]) % 4;
                    arr = rotate(arr, r, c, cnt);
                    count += cnt;
                }
            }
            
            if (check(arr))
                answer = Math.min(answer, count);
        }
        return answer;
    }
        
    public int[][] rotate(int[][] arr, int r, int c, int cnt) {
        int l = arr.length;
        arr[r][c] = (arr[r][c] + cnt) % 4;
        if (r > 0) 
            arr[r - 1][c] = (arr[r - 1][c] + cnt) % 4;
        if (c > 0) 
            arr[r][c - 1] = (arr[r][c - 1] + cnt) % 4;
        if (r < l - 1) 
            arr[r + 1][c] = (arr[r + 1][c] + cnt) % 4;
        if (c < l - 1)
            arr[r][c + 1] = (arr[r][c + 1] + cnt) % 4;
        return arr;
    }
    
    public boolean check(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[arr.length - 1][i] != 0)
                return false;
        return true;
    }
}