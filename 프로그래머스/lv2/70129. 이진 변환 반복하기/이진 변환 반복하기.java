class Solution {
    public int[] solution(String s) {
        int processCnt = 0;
        int zeroRemoveCnt = 0;
        
        while (!s.equals("1")) {
            processCnt++;
            int cnt1 = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1')
                    cnt1++;
            zeroRemoveCnt += s.length() - cnt1;
            s = s.substring(0, cnt1).replace('0', '1');
            s = Integer.toBinaryString(s.length());
        }
        
        int[] answer = {processCnt, zeroRemoveCnt};
        return answer;
    }
}