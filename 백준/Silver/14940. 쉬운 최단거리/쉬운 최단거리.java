import java.io.*;
import java.util.*;

class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map, result;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (map[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        result = new int[n][m];
        int X;
        int Y;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            X = curr[0];
            Y = curr[1];

            for (int k = 0; k < 4; k++) {
                int nextX = X + dx[k];
                int nextY = Y + dy[k];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                result[nextX][nextY] = result[X][Y] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) result[i][j] = -1;

                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}