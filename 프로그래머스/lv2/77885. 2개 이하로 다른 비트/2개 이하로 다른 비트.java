class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] % 2 == 0 || answer[i] == 1)
                answer[i]++;
            else {
                String s = Long.toBinaryString(answer[i]);
                StringBuilder sb = new StringBuilder(s);
                
                // 2진수가 1로만 구성되어 있으면 맨앞에 0 추가
                if (sb.indexOf("0") < 0)
                    sb.insert(0, '0');
                
                for (int j = s.length() - 1; j >= 0 ; j--) {
                    if (sb.charAt(j) == '0') {
                        sb.setCharAt(j, '1');
                        if (j != s.length() - 1)
                            sb.setCharAt(j + 1, '0');
                        break;
                    }
                }
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        return answer;
    }
}