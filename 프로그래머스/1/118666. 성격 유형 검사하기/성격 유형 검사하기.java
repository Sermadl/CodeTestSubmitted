import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> personality = new HashMap<>();
        String[] rate = new String[]{"RT", "CF", "JM", "AN"};
        
        personality.put('R', 0);
        personality.put('T', 0);
        personality.put('C', 0);
        personality.put('F', 0);
        personality.put('J', 0);
        personality.put('M', 0);
        personality.put('A', 0);
        personality.put('N', 0);
        
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 3) {
                char temp = survey[i].charAt(1);
                personality.put(temp, personality.get(survey[i].charAt(1)) + (choices[i] - 4));
            } else {
                personality.put(survey[i].charAt(0), personality.get(survey[i].charAt(0)) + (4 - choices[i]));
            }
        }
        
        for (String r : rate) {
            if (personality.get(r.charAt(0)) < personality.get(r.charAt(1))) {
                answer += r.charAt(1);
            } else {
                answer += r.charAt(0);
            }
        }
        
        return answer;
    }
}