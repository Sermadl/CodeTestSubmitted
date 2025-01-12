import java.io.*;
import java.util.*;

public class Main {
    private static int n = 5;
    private static char[] sound = {'q', 'u', 'a', 'c', 'k'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sounds = br.readLine();
        int len = sounds.length();
        boolean[] used = new boolean[len];
        if (len % 5 != 0 || sounds.charAt(0) != 'q') { // 길이가 5의 배수가 아니거나 q로 시작하지 않으면
            System.out.println(-1); // 올바르지 않은 문자열
            return;
        }

        int totalDuck = 0;
        for (int i = 0; i < len; i++) { // 탐색 시작 위치
            if (used[i]) continue; // 이미 탐색했다면 넘어가기

            int idx = 0;
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < len; j++) { // 하나씩 탐색하기
                if (!used[j] && sound[idx] == sounds.charAt(j)) { // 오리의 울음순서와 일치하는지 확인
                    used[j] = true;
                    list.add(sound[idx]);
                    idx = (idx + 1) % n;
                }
            }

            int duckLen = list.size();
            if (duckLen != 0 && duckLen % n == 0) { // 오리의 울음소리가 5의 배수면 올바른 경우
                totalDuck++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        br.close();
        System.out.println(totalDuck);
    }
}