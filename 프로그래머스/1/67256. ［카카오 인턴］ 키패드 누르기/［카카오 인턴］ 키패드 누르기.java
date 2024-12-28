import java.util.*;

class Solution {
    private static int[][] keypad = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}, 
        {-1, 0, 10}
    };
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        int[] leftSide = new int[]{1, 4, 7};
        int[] rightSide = new int[]{3, 6, 9};
        
        if (hand.equals("right")) {
            hand = "R";
        } else {
            hand = "L";
        }
        
        for (int num : numbers) {
            if (Arrays.stream(leftSide).anyMatch(i -> i == num)) {
                left = find(num);
                answer += "L";
            } else if (Arrays.stream(rightSide).anyMatch(i -> i == num)) {
                right = find(num);
                answer += "R";
            } else {
                int[] temp = find(num);
    
                int leftDistance = Math.abs((left[0] - temp[0])) + 
                    Math.abs((left[1] - temp[1]));
                int rightDistance = Math.abs((right[0] - temp[0])) + 
                    Math.abs((right[1] - temp[1]));
                
                if (leftDistance < rightDistance) {
                    left = find(num);
                    answer += "L";
                } else if (leftDistance > rightDistance) {
                    right = find(num);
                    answer += "R";
                } else {
                    if (hand.equals("L")) {
                        left = find(num);
                    } else {
                        right = find(num);
                    }
                    answer += hand;
                }
            }
        }
        
        return answer;
    }
    
    private static int[] find(int x) {
        for (int i=0; i<4; i++) {
            for(int j=0; j<3; j++){
                if (keypad[i][j] == x){
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
}