import java.io.*;
import java.util.*;

class Main {
    private static int[][] bingo, numCall;
    private static boolean[][] check;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        bingo = new int[5][5];
        numCall = new int[5][5];
        check = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0, y = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numCall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cnt = 0;
                checkBingo(numCall[i][j]);
                if (cnt >= 3) {
                    System.out.println(i * 5 + (j + 1));
                    return;
                }
            }
        }
    }

    private static void checkBingo(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num)
                    check[i][j] = true;
            }
        }

        boolean flag = false;

        for (int i = 0; i < 5; i++) {
            // 세로 빙고 체크
            if (check[0][i]) {
                flag = true;

                for (int j = 1; j < 5; j++) {
                    if (!check[j][i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    cnt++;
            }

            // 가로 빙고 체크
            if (check[i][0]) {
                flag = true;

                for (int j = 1; j < 5; j++) {
                    if (!check[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    cnt++;
            }
        }

        // 대각선 위 체크
        if (check[0][0]) {
            flag = true;

            for (int i = 1; i < 5; i++) {
                if (!check[i][i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                cnt++;
        }


        // 대각선 아래 체크
        if (check[0][4]) {
            flag = true;

            for (int i = 1; i < 5; i++) {
                if (!check[i][4-i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                cnt++;
        }
    }
}