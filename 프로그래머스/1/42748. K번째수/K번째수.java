import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            tmp = Arrays.stream(tmp).sorted().toArray();
            answer[i] = (tmp[commands[i][2] - 1]);
        }
        
        return answer;
    }
}