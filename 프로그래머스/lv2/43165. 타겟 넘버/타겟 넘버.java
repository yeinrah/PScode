class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        calc(numbers, target, 0, 0);
        return answer;
    }
    
    public void calc(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target)
                answer++;
            return;
        }
        
        calc(numbers, target, sum + numbers[index], index + 1);
        calc(numbers, target, sum - numbers[index], index + 1);
    }
}