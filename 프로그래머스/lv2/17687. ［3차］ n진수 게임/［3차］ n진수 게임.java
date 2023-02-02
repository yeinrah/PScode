class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        while (all.length() < t * m)
            all.append(Integer.toString(i++, n));
        
        for (int idx = 0; idx < t; idx++)
            ans.append(all.charAt(idx * m + p - 1));
        
        return ans.toString().toUpperCase();
    }
}