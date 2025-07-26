import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : participant) {
            if(map.getOrDefault(str, 0) == 0) {
                return str;
            }
            map.put(str, map.get(str) - 1);
        }

        return null;
    }
}