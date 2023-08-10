class Solution {
    public int solution(int[] numbers) {
        boolean[] arr = new boolean[10];
        int answer = 0;
        for (int n : numbers)
            arr[n] = true;
        for (int i = 0; i < arr.length; i++)
            if (!arr[i])
                answer += i;
        return answer;
    }
}