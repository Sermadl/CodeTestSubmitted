import java.util.*;
import java.io.*;

class Main {
    private static int[][] node;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        node = new int[n + 1][n + 1];
        N = n;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x][y] = node[y][x] = 1;
        }

        int[] visit = new int[n + 1];
        dfs(visit, v);

        System.out.println();

        visit = new int[n + 1];
        bfs(visit, v);
    }

    public static void dfs(int[] visit, int curr) {
        if (visit[curr] == 0) {
            System.out.print(curr + " ");
            visit[curr] = 1;
            for (int i = 1; i < N + 1; i++) {
                if (node[curr][i] == 1) {
                    dfs(visit, i);
                }
            }
        }
    }

    public static void bfs(int[] visit, int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(v);

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();
            if (visit[curr] == 1) {
                continue;
            }
            System.out.print(curr + " ");
            visit[curr] = 1;

            for (int i = 1; i < N + 1; i++) {
                if (node[curr][i] == 1 && visit[i] == 0) {
                    queue.addLast(i);
                }
            }
        }

    }
}