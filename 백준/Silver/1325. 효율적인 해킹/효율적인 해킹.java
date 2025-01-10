import java.io.*;
import java.util.*;

class Main {
    private static int n, m, max;
    private static ArrayList<Integer>[] com;
    private static boolean[] visit;
    private static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        com = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            com[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            com[a].add(b);
        }

        result = new int[n+1];

        for (int i = 1; i <= n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visit = new boolean[n+1];
            visit[i] = true;

            while(!queue.isEmpty()) {
                int curr = queue.poll();

                for (int next : com[curr]) {
                    if (!visit[next]) {
                        visit[next] = true;
                        result[next]++;
                        queue.offer(next);
                    }
                }
            }
        }

        for (int value : result) {
            max = Math.max(max, value);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        sb.append("\n");

		System.out.print(sb);
    }
}
