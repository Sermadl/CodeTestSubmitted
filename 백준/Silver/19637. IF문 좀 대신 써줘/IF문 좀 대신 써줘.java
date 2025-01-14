import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> rate = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (rate.containsKey(num)) continue;
            rate.put(num, tmp);
        }

        String[] answer = new String[m];
        ArrayList<Integer> nums = new ArrayList<>(rate.keySet());
        Collections.sort(nums);

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = nums.size() - 1;
            int target = Integer.parseInt(br.readLine());

            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums.get(mid) >= target) {
                    answer[i] = rate.get(nums.get(mid));
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }

        for (String s : answer) {
            bw.write(s + "\n");
        }

        bw.close();
        br.close();
    }
}