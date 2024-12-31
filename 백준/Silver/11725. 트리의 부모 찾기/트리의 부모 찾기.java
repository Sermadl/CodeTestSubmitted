import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // bfs
        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n];
        queue.add(0);
        visited[0] = 1;
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();

            for (int i : tree.get(node)) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    parent[i] = node;
                    queue.addLast(i);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            bw.write(String.valueOf(parent[i] + 1) + "\n");
            bw.flush();
        }

        bw.close();
    }
}