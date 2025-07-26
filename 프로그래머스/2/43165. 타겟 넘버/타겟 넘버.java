class Solution {
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        int answer = combination(0, 0);
        
        return answer;
    }
    
    public int combination(int curr, int sum) {
        if (curr == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        
        return combination(curr + 1, sum + numbers[curr]) + combination(curr + 1, sum - numbers[curr]);
    }
}