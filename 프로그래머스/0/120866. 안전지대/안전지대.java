import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        boolean[][] danger = new boolean[board.length][board.length];
        int[] dx = {0, -1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0};
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 9; k++) {
                        int x = j + dx[k];
                        int y = i + dy[k];
                        
                        if (x >= 0 && x < len && y >= 0 && y < len){
                            danger[x][y] = true;
                        }
                    }
                }
            }
        }
        
        for (boolean[] map : danger)
            for (boolean status : map)
                if (!status) answer++;
        
        return answer;
    }
}