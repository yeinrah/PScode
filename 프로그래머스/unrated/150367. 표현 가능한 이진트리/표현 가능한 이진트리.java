class Solution {
    static int[] answer;
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));
            int e = 0;
            while (Math.pow(2, e) - 1 < sb.length())
                e++;
            while (Math.pow(2, e) - 1 != sb.length())
                sb.insert(0, "0");
            if (check(sb.toString()))
                answer[i] = 1;
        }
        return answer;
    }
    
    public boolean check(String str) {
        boolean valid = true;
        int mid = (str.length() - 1) / 2;
        char root = str.charAt(mid);
        String left = str.substring(0, mid);
        String right = str.substring(mid + 1, str.length());
        
        // 부모가 0인데 자식이 1이면 이진트리로 표현 불가
        if (root == '0' && (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1'))
            return false;
        
        if (left.length() >= 3) {
            valid = check(left);
            if (valid)
                valid = check(right);
        }
        return valid;
    }
}