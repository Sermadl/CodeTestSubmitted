import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] stones = new long[n];
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        
        // 최소 힘
        long start = 1;
        // 최대 힘
        long end = (n-1) * (1 + Math.abs(stones[n-1] - stones[0]));
        long answer = 0;

        // 다리를 건널 때 mid 값 보다 작은 힘이 들 때에만 스택에 저장
        while (start <= end) {
            long mid = (start + end) / 2;

            boolean[] visited = new boolean[n];
            boolean flag = false;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            visited[0] = true;

            while (!stack.isEmpty()) {
                int pop = stack.pop();

                if (pop == n - 1) {
                    flag = true;
                    break;
                }

                for (int i = pop + 1; i < n; i++) {
                    long power = (i - pop) * (1 + Math.abs(stones[i] - stones[pop]));
                    if (!visited[i] && power <= mid) {
                        stack.push(i);
                        visited[i] = true;
                    }
                }
            }

            // mid 값 보다 작은 힘으로 다리를 다 건널 수 있었을 경우 범위를 작게 함 -> end를 mid - 1로 바꿈
            if (flag) {
                answer = mid;
                end = mid - 1;
            } else { 
                // mid 값보다 작은 힘으로 다리를 다 건너지 못했을 경우 범위를 크게 함 -> start를 mid + 1로 바꿈
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}