import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodes = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[x] = 0;
        queue.addLast(x);

        while(!queue.isEmpty()) {
            int now = queue.pollFirst();

            if (dist[now] > k) break;

            for (int next : nodes[now]) {
                if (dist[next] != INF) continue;
                dist[next] = dist[now] + 1;
                queue.add(next);
            }
        }

        boolean flag = false;

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }
}