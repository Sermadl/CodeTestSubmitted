import java.io.*;
import java.util.*;

class Main {
    private static boolean[][] mines;
    private static char[][] result;
    private static int n;
    // 상, 하, 좌, 우, 대각선 왼쪽 위, 대각선 오른쪽 위, 대각선 왼쪽 아래, 대각선 오른쪽 아래
    private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String line;

        mines = new boolean[n][n];
        result = new char[n][n];

        // 맵 정보 입력받기
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < n; j++) {
                // 결과판 초기화
                result[i][j] = '.';

                // 지뢰 위치 표시
                if (line.charAt(j) == '*') mines[i][j] = true;
            }
        }

        // 플레이 현황 기록하기
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'x') {
                    if (!mines[i][j])
                        result[i][j] = checkSurroundings(i, j);
                    else
                        findMines();
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(result[i][j]);
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    private static char checkSurroundings(int x, int y) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;

            if (mines[nextX][nextY]) {
                cnt++;
            }
        }

        return (char) (cnt + '0');
    }

    private static void findMines() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j])
                    result[i][j] = '*';
            }
        }
    }
}