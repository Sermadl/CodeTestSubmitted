import java.io.*;
import java.util.*;

class Main {
    // 우, 대각선 위 오른쪽, 하, 대각선 밑 오른쪽
    private static int[] dx = {0, -1, 1, 1};
    private static int[] dy = {1, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] omok = new int[19][19];
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오목 찾기
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 돌이 놓여 있을 경우
                if (omok[j][i] != 0) {
                    // 4방 탐색 (깊이 우선으로)
                    for (int k = 0; k < 4; k++) {
                        int nextX = j;
                        int nextY = i;
                        int cnt = 1;

                        while (true) {
                            nextX += dx[k];
                            nextY += dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= 19 || nextY >= 19) break;

                            if (omok[nextX][nextY] == omok[j][i]) {
                                cnt++;
                            } else {
                                break;
                            }
                        }

                        nextX = j;
                        nextY = i;

                        // 역방향에도 같은 돌이 놓여있는지 확인
                        while (true) {
                            nextX -= dx[k];
                            nextY -= dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= 19 || nextY >= 19) break;

                            if (omok[nextX][nextY] == omok[j][i]) {
                                cnt++;
                            } else {
                                break;
                            }
                        }

                        // 완벽한 오목인 경우에만 승리 결과 출력
                        if (cnt == 5) {
                            int x = j + 1;
                            int y = i + 1;
                            System.out.println(omok[j][i]);
                            System.out.println(x + " " + y);
                            return;
                        }
                    }
                }
            }
        }
        // 아무도 이기지 않은 경우
        System.out.println(0);
    }
}