import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> history = new HashMap<>();
        
        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            
            if (!history.containsKey(temp[1])) {
                history.put(temp[1], new HashSet<>());
            } 
            
            if (!history.getOrDefault(temp[1], new HashSet<>()).contains(temp[0])) {
                history.get(temp[1]).add(temp[0]);
                count.put(temp[1], count.getOrDefault(temp[1], 0) + 1);
            }
        }
        
        for (String user : count.keySet()) {
            if (count.get(user) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (history.get(user).contains(id_list[i])) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}