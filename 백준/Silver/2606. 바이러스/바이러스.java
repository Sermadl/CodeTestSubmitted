import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] com = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            com[x][y] = com[y][x] = 1;
        }

        int[] visit = new int[n+1];
        int cnt = -1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);

        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            if (visit[curr] == 1) {
                continue;
            }
            visit[curr] = 1;
            cnt++;

            for (int i = 1; i < n+1; i++) {
                if (com[curr][i] == 1 && visit[i] == 0) {
                    queue.addLast(i);
                }
            }
        }

        System.out.println(cnt);
    }
}