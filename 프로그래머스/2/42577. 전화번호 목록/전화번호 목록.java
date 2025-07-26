import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> num = new HashSet<>();
        
        Arrays.stream(phone_book).forEach(num::add);

        for (String phone_num : phone_book) {
            for (int i = 0; i < phone_num.length(); i++) {
                if (num.contains(phone_num.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}