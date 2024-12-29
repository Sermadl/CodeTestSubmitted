class Solution {
    private int[] answer = new int[5];
    private int[][] visited;
    private int flag;
    // 상, 하, 좌, 우, 대각선 상, 대각선 하, 대각선 좌, 대각선 우
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++){
            String[] place = places[i];
            visited = new int[5][5];
            flag = 1;
            
            for(int j = 0; j < 5; j++){
                for (int k = 0; k < 5; k++) {
                    // 현재 (j, i) 위치가 사람인 경우에만 거리 2 이내 주변 탐색
                    if (place[j].charAt(j) == 'P'){
                        dfs(0, 0, place, 0);
                        if (flag == 0) break; // 거리두기가 지켜지지 않은 경우가 확인되면 바로 반복문 종료
                    }
                }
                if (flag == 0) break; // 반복문 종료
            }
            
            answer[i] = flag;
        }
        
        return answer;
    }
    
    private void dfs(int x, int y, String[] info, int depth) {
        if (depth >= 2) return; // 맨해튼 거리가 2보다 더 먼 경우 바로 dfs 실행 중단

        visited[y][x] = 1; // 현재 x, y를 기준으로 방문 처리
        
        // 사방 탐색
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            
            // 탐색된 x와 y가 범위 안에 있고, 방문한 적 없는 경우에만 반복문 진행
            if (tempX < 0 || tempX > 4 || tempY < 0 || tempY > 4 || visited[tempY][tempX] == 1) continue;
            
            // 만약 맨해튼 거리 2 이내에서 'O'를 발견한 경우
            if (info[tempY].charAt(tempX) == 'O') {
                // 'O'의 사방을 탐색한다. -> 대각선도 탐색 가능함
                dfs(tempX, tempY, info, depth + 1);
            } // 맨해튼 거리 2 이내에서 'P'를 발견한 경우
            else if (info[tempY].charAt(tempX) == 'P') {
                // 거리두기가 지켜지지 않았으므로 flag는 0, 즉시 dfs 종료
                flag = 0;
                return;
            }
        }
    }
}