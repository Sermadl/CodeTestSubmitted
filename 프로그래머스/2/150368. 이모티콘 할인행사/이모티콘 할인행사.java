import java.util.*;

class Solution {
    private int signUp = 0;
    private int sell = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        
        combination(discount, 0, users, emoticons);
        
        int[] answer = {signUp, sell};
        
        return answer;
    }
    
    private void combination(int[] discount, int start, int[][] users, int[] emoticons) {
        if (start == discount.length) {
            assume(discount, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discount[start] = i;
            combination(discount, start + 1, users, emoticons);
        }
    }
    
    private void assume(int[] discount, int[][] users, int[] emoticons) {
        int count = 0;
        int total = 0;
        
        for (int[] user : users) {
            int sum = 0;
            int per = user[0];
            int upto = user[1];
            
            for (int i = 0; i < emoticons.length; i++) {
                if (per <= discount[i]) {
                    sum += (emoticons[i] / 100) * (100 - discount[i]);
                }
            }
            
            if (sum >= upto) {
                count++;
            } else {
                total += sum;
            }
        }
        
        if (count > signUp) {
            signUp = count;
            sell = total;
        } else if (count == signUp) {
            if (sell < total) {
                sell = total;
            }
        }
    }
}