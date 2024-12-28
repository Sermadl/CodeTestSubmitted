import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.addLast(queue1[i]);
            q2.addLast(queue2[i]);
        }
        
        long q1Sum = (long) Arrays.stream(q1.stream().mapToInt(Integer::intValue).toArray()).sum();
            long q2Sum = (long) Arrays.stream(q2.stream().mapToInt(Integer::intValue).toArray()).sum();
        
        while (q1Sum != q2Sum) {
            if (q1Sum < q2Sum) {
                int temp = q2.pollFirst();
                q1.addLast(temp);
                
                q2Sum -= temp;
                q1Sum += temp;
            } else if (q1Sum > q2Sum) {
                int temp = q1.pollFirst();
                q2.addLast(temp);
                
                q1Sum -= temp;
                q2Sum += temp;
            } else {
                return answer;
            }
            
            if (answer >= (queue1.length + queue2.length) * 2)
                return -1;
            
                            
            answer++;
        }
        
        return answer;
    }
}