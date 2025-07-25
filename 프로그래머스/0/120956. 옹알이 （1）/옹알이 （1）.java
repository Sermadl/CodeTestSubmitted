class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (int i=0; i < babbling.length; i++) {
            for (String word : words) {
                babbling[i] = babbling[i].replaceAll(word, "1");
            }
            
            babbling[i] = babbling[i].replaceAll("1", "");
            
            if (babbling[i].length() == 0) answer++;
        }
        
        return answer;
    }
}