class Solution {
    static int member = 0;
    static int profit = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] arr = new int[emoticons.length];
        
        comb(arr, 0, users, emoticons);
        
        int[] answer = {member, profit};
        return answer;
    }
    
    public void comb(int[] arr, int start, int[][] users, int[] emoticons) {
        if (start == arr.length) {
            calc(arr, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            arr[start] = i;
            comb(arr, start + 1, users, emoticons);
        }
    }
    
    public void calc(int[] arr, int[][] users, int[] emoticons) {
        int cnt = 0;
        int tmp = 0;
        
        for (int[] user : users) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] >= user[0])
                    sum += emoticons[i] * (100 - arr[i]) / 100;
            if (sum >= user[1])
                cnt++;
            else
                tmp += sum;
        }
        
        if (cnt > member) {
            member = cnt;
            profit = tmp;
            return;
        }
        else if (cnt == member)
            if (profit < tmp)
                profit = tmp;
    }
}