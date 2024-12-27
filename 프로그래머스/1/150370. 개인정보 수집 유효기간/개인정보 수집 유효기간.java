import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> term = new HashMap<>();
        
        for (String t : terms) {
            String[] temp = t.split(" ");
            term.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(today, pattern);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate due = LocalDate.parse(privacy[0], pattern);
            
            if (!date.isBefore(due.plusMonths(term.get(privacy[1])))) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}