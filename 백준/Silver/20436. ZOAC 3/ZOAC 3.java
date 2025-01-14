import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        char lStart = st.nextToken().charAt(0);
        char rStart = st.nextToken().charAt(0);
        String target = br.readLine();
        int result = 0;
        int[] left = new int[2];
        int[] right = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < keyboard[i].length(); j++) {
                if (lStart == keyboard[i].charAt(j)) {
                    left[0] = i;
                    left[1] = j;
                }

                if (rStart == keyboard[i].charAt(j)) {
                    right[0] = i;
                    right[1] = j;
                }
            }
        }

        for (int i = 0; i < target.length(); i++) {
            char tmp = target.charAt(i);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < keyboard[j].length(); k++) {
                    if (tmp == keyboard[j].charAt(k)) {
                        if (k < (keyboard[j].length() + 1) / 2){
                            result += (Math.abs(left[0] - j) + Math.abs(left[1] - k)) + 1;
                            left[0] = j;
                            left[1] = k;
                        } else {
                            result += (Math.abs(right[0] - j) + Math.abs(right[1] - k)) + 1;
                            right[0] = j;
                            right[1] = k;
                        }

                    }
                }
            }
        }

        System.out.println(result);
    }
}