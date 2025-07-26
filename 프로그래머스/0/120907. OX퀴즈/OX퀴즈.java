import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        // String[] answer = {};
        ArrayList<String> answer = new ArrayList<>();
        
        for (String curr : quiz) {
            int sum = 0;
            String[] num = curr.split(" ");
            boolean flag = true;
            
            for (String n : num) {
                if (n.equals("-")) flag = false;
                else if (n.equals("+")) flag = true;
                else if (n.equals("=")) break;
                else {
                    if (flag) sum += Integer.parseInt(n);
                    else sum -= Integer.parseInt(n);
                }
            }
            
            if (sum == Integer.parseInt(num[num.length - 1])) answer.add("O");
            else answer.add("X");
        }
        
        return answer.toArray(new String[quiz.length]);
    }
}