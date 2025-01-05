import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] node = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            node[i] = new ArrayList<>();
        }

        int[] visit = new int[n+1];
        int[] parent = new int[n+1];

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x].add(y);
            node[y].add(x);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);

        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            if (visit[curr] == 1) continue;

            visit[curr] = 1;

            for (int next : node[curr]) {
                if (visit[next] == 0) {
                    queue.addLast(next);
                    parent[next] = curr;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            System.out.println(parent[i]);
        }

    }
}