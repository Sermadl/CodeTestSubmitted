import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> index = new HashMap<>();
        int[] rate = new int[friends.length];
        int[][] history = new int[friends.length][friends.length];
        
        
        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }
        
        for(String gift : gifts) {
            String[] fromTo = gift.split(" ");
            
            rate[index.get(fromTo[0])]++;
            rate[index.get(fromTo[1])]--;
            
            history[index.get(fromTo[0])][index.get(fromTo[1])]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++){
                if (history[i][j] > history[j][i]) {
                    cnt++;
                } else if (history[i][j] == history[j][i] && rate[i] > rate[j]) {
                    cnt++;
                    System.out.println(i + " " + j);
                }
            }

            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}