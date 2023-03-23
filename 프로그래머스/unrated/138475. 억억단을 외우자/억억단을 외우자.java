class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] nums = new int[e + 1];
        int[] cnt = new int[e + 1];
        nums[1] = 1;
        cnt[1] = 1;
        for (int i = 2; i <= e; i++) {
            int j = i;
            for (int k = 1; k <= e / i; k++) {
                nums[j] += 1;
                j += i;
            }   
        }
        
        int a = 0;
        for (int i = e; i >= 1; i--) {
            if (nums[i] >= a) {
                a = nums[i];
                cnt[i] = i;
            }
            else
                cnt[i] = cnt[i + 1];
        }
        
        for(int i = 0; i < starts.length; i++)
            answer[i] = cnt[starts[i]];
        return answer;
    }
}