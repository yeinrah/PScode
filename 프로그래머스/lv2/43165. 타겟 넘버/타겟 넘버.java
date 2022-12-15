class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        calc(numbers, target, numbers[0], 0);
        calc(numbers, target, -numbers[0], 0);
        return answer;
    }
    
    public void calc(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length - 1) {
            if (sum == target)
                answer++;
            return;
        }
        
        calc(numbers, target, sum + numbers[index + 1], index + 1);
        calc(numbers, target, sum - numbers[index + 1], index + 1);
    }
}