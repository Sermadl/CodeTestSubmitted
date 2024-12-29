class Solution {
    private int answer;
    
    public int solution(int n, int k) {
        answer = 0;
        String temp = "";
        
        while(n > 0) {
            temp = n % k + temp;
            n /= k;
        }
        
        // for문으로 temp의 모든 인덱스에 접근하면 시간 초과가 발생할 수 있으니 temp를 split 해서 숫자만 확인하자!
        String[] nums = temp.split("0");
        
        for (String num : nums) {
            if (!num.isEmpty()) {
                    checkP(num);
                }
        }
        
        return answer;
    }
    
    private void checkP(String num) {
        // int로 숫자를 받게 되면 오버플로우로 인해 런타임 에러가 발생할 수 있으니 long으로 받아준다.
        long prime = Long.parseLong(num);
        if (prime < 2) return;
        // prime까지 모든 for문을 돌리면 시간 초과가 발생할 수 있으니 prime의 제곱근까지 for문을 돌린다. (소수 * 소수의 경우까지 생각했기 때문)
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) return;
        }
        
        answer++;
    }
}