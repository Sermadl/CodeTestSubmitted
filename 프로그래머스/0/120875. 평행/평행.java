import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                int[][] tmp = new int[2][2];
                int len = 0;
                
                for (int k = 0; k < dots.length; k++) {
                    if (k == i || k == j) continue;
                    tmp[len] = dots[k];
                    len++;
                }
                
                int doty = (dots[i][1] - dots[j][1]);
                int dotx = (dots[i][0] - dots[j][0]);
                int tmpy = (tmp[0][1] - tmp[1][1]);
                int tmpx = (tmp[0][0] - tmp[1][0]);
                
                if ((double)doty / dotx == (double)tmpy / tmpx) {
                    answer = 1;
                    break;
                }
                else if (dotx == tmpx && doty == tmpy) {
                    answer = 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}