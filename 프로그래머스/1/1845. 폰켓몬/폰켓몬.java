import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashMap<Integer, Integer> pockemon = new HashMap<>();
        
        for (int n : nums) {
            pockemon.put(n, pockemon.getOrDefault(n, 0) + 1);
        }
        
        if (pockemon.size() > answer) return answer;
        else return pockemon.size();
    }
}