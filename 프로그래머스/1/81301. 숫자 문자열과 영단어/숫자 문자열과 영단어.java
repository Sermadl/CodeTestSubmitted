import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> nums = new HashMap<>();
        
        nums.put("one", 1);
        nums.put("two", 2);
        nums.put("three", 3);
        nums.put("four", 4);
        nums.put("five", 5);
        nums.put("six", 6);
        nums.put("seven", 7);
        nums.put("eight", 8);
        nums.put("nine", 9);
        nums.put("zero", 0);
        
        for (String num : nums.keySet()) {
            if (s.contains(num)) {
                s = s.replace(num, nums.get(num).toString());
            }
        }
        
        return Integer.parseInt(s);
    }
}