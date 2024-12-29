import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int min=1000000;
        int max=-1000000;

        for (String s : str) {
            int num = Integer.parseInt(s);
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }

        System.out.println(min + " " + max);
    }
}