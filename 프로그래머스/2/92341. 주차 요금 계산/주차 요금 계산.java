import java.util.*;

class Solution {
    private Map<String, String> inRecord = new HashMap<>();
    private Map<String, Integer> totalTime = new TreeMap<>();
    private int[] rule;
    
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        rule = fees;
        
        for (String record : records) {
            String[] info = record.split(" ");
            
            if (info[2].equals("IN")) {
                inRecord.put(info[1], info[0]);
            } else {
                int in = getTime(inRecord.get(info[1]));
                int out = getTime(info[0]);
            
                totalTime.put(info[1], totalTime.getOrDefault(info[1], 0) + out-in);
                
                inRecord.remove(info[1]);
            }
        }
        
        if (!inRecord.isEmpty()) {
            for (String key : inRecord.keySet()) {
                int in = getTime(inRecord.get(key));
                int out = getTime("23:59");
                
                totalTime.put(key, totalTime.getOrDefault(key, 0) + out-in);
            }
        }
        
        for (String car : totalTime.keySet()) {
            answer.add(calculate(car));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int calculate(String car) {
        int time = totalTime.get(car);
        int fee;
        if (time > rule[0]) {
            fee = (int) (rule[1] + (Math.ceil((double)((time - rule[0])) / rule[2]) * rule[3]));
        } else {
            fee = rule[1];
        }
        
        return fee;
    }
    
    private int getTime(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]) * 60;
        int minute = Integer.parseInt(temp[1]);
        
        return hour + minute;
    }
}