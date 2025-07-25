class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String tmp = my_string.replaceAll("[^0-9]", "_");
        String[] nums = tmp.split("_");
        
        for (String num : nums) {
            if (!num.isBlank())
                answer += Integer.parseInt(num);
        }
        
        return answer;
    }
}