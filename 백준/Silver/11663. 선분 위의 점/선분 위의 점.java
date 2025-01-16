import java.io.*;
import java.util.*;

class Main {
    private static int[] cord;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cord = new int[n];
        for (int i = 0; i < n; i++) {
            cord[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cord);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = findCord(Integer.parseInt(st.nextToken()), true);
            int b = findCord(Integer.parseInt(st.nextToken()), false);
            bw.write((b - a) + "\n");
        }

        bw.close();
        br.close();
    }

    private static int findCord(int target, boolean flag) {
        // flag: 시작점이면 true, 끝점이면 false
        int start = 0;
        int end = n - 1;
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            answer = mid;

            if (cord[mid] < target) {
                start = mid + 1;
            } else if (cord[mid] > target) {
                end = mid - 1;
            } else {
                break;
            }
        }

        if (flag) {
            if (cord[answer] < target) {
                return answer;
            } else {
                return answer - 1;
            }
        } else {
            if (cord[answer] > target) {
                return answer - 1;
            } else {
                return answer;
            }
        }
    }
}