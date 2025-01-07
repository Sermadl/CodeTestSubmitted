import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int mv = n;
        int curr = 0;

        int[][] matrix = new int[n][n];
        int num = n*n;

        while (num > 0) {
            y = curr;

            for (int j = x; j < mv; j++) {
                matrix[j][y] = num--;
            }

            x = mv - 1;

            for (int j = y + 1; j < mv; j++) {
                matrix[x][j] = num--;
            }

            y = mv - 1;

            for (int j = x - 1; j >= curr; j--) {
                matrix[j][y] = num--;
            }

            x = curr;

            for (int j = y - 1; j > curr; j--) {
                matrix[x][j] = num--;
            }

            curr++;
            mv--;
            x = curr;
        }

        int resultX = 0;
        int resultY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == m) {
                    resultX = i + 1;
                    resultY = j + 1;
                }

                bw.write(matrix[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.write(resultX + " " + resultY);
        bw.close();
        br.close();
    }
}