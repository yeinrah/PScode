class Solution {
    public int solution(int[][] sizes) {
        int maxGa = 0;
        int maxSe = 0;
        
        for (int[] s : sizes) {
            int ga = Math.max(s[0], s[1]);
            int se = Math.min(s[0], s[1]);
            maxGa = Math.max(maxGa, ga);
            maxSe = Math.max(maxSe, se);
        }
        
        return maxGa * maxSe;
    }
}