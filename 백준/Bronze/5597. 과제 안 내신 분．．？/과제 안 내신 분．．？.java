import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] student = new int[31];

        for (int i = 1; i < 29; i++) {
            int n = Integer.parseInt(br.readLine());
            student[n] = 1;
        }

        for (int i = 1; i < 31; i++) {
            if (student[i] == 0) {
                System.out.println(i);
            }
        }
    }
}