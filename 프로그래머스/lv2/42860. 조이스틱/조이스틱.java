class Solution {
    public int solution(String name) {
        int diff = 0;
        int idx = 0;
        int l = name.length();
        int dist = l - 1;

        for (int i = 0; i < l; i++) {
            diff += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            idx = i + 1;
            while (idx < l && name.charAt(idx) == 'A')
                idx++;
            
            dist = Math.min(dist, i * 2 + l - idx);
            dist = Math.min(dist, (l - idx) * 2 + i);
        }
        return diff + dist;
    }
}