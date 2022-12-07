class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        out : for (int i = 0; i < discount.length - 9; i++) {
            int[] number_copy = number.clone();
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < want.length; k++)
                    if (discount[i + j].equals(want[k]))
                        number_copy[k]--;
            for (int k = 0; k < number_copy.length; k++)
                if (number_copy[k] != 0)
                    continue out;
            answer++;
        }
        return answer;
    }
}