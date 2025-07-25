class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int xmax = board[0] / 2;
        int xmin = 0 - xmax;
        int ymax = board[1] / 2;
        int ymin = 0 - ymax;
        
        for (String input : keyinput) {
            if (input.equals("up")) {
                if (y + dy[0] <= ymax) y += dy[0];
            }
            else if (input.equals("down")) {
                if (y + dy[1] >= ymin) y += dy[1];
            }
            else if (input.equals("left")) {
                if (x + dx[2] >= xmin) x += dx[2];
            }
            else {
                if (x + dx[3] <= xmax) x += dx[3];
            }
        }
        
        int[] answer = {x, y};
        
        return answer;
    }
}