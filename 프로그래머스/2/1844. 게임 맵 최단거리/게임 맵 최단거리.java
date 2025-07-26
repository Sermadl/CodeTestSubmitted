import java.util.*;

class Solution {
    int n, m;
    int[][] maps = {};
    boolean[][] visited = {};
    int[][] distance = {};
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        this.maps = maps;
        visited = new boolean[n][m];
        distance = new int[n][m];
        distance[0][0] = 1;
        
        return bfs(0, 0) == 0 ? -1 : bfs(0, 0);
    }
    
    public int bfs(int x, int y) {
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            
            int cx = tmp[0];
            int cy = tmp[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[ny][nx] && maps[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                        distance[ny][nx] = distance[cy][cx] + 1;
                    }
                }
            }
        }
        
        return distance[n-1][m-1];
    }
}