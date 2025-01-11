import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        String line = br.readLine();
        boolean flag = false;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                sb.append(reversed(tmp));
                tmp.setLength(0);

                flag = true;
                sb.append('<');
            } else if (line.charAt(i) == '>') {
                flag = false;
                sb.append('>');
            } else if (line.charAt(i) == ' '){
                if (flag)
                    sb.append(' ');
                else {
                    sb.append(reversed(tmp)).append(' '); // tmp.reverse() 로 대체 가능
                    tmp.setLength(0);
                }
            } else {
                if (flag)
                    sb.append(line.charAt(i));
                else
                    tmp.append(line.charAt(i));
            }
        }

        if (tmp.length() != 0) // tmp.isEmpty()는 java 11에서 사용 불가
            sb.append(reversed(tmp));

        System.out.println(sb);
    }

    private static String reversed(StringBuilder sb) {
        StringBuilder result = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            result.append(sb.charAt(i));
        }

        return result.toString();
    }
}