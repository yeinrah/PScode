class Solution {
    public int solution(int n) {
        String bin = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < bin.length(); i++)
            if (bin.charAt(i) == '1')
                cnt++;
        
        int cnt2 = 0;
        while (cnt != cnt2) {
            cnt2 = 0;
            String bin2 = Integer.toBinaryString(++n);
            for (int i = 0; i < bin2.length(); i++)
                if (bin2.charAt(i) == '1')
                    cnt2++;
        }
        return n;
    }
}