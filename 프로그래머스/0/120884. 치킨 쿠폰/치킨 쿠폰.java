class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(chicken >= 10) {
            int service = chicken / 10;
            int tmp = chicken % 10;
            chicken = service + tmp;
            answer += service;
        }
        
        return answer;
    }
}