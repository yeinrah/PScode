class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        while (all.length() < t * m)
            all.append(Integer.toString(i++, n));
        
        for (int idx = p - 1; idx < all.length(); idx += m)
            ans.append(all.charAt(idx));
        
        return ans.toString().toUpperCase().substring(0, t);
    }
}