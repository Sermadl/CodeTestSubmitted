import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] splitStr = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitStr.length; i++) {
            String tmp = splitStr[i];
            if (tmp.length() % 2 != 0) {
                sb = new StringBuilder("-1");
                break;
            } else if (tmp.length() % 4 == 0) {
                sb.append("AAAA".repeat(tmp.length() / 4));
            } else {
                sb.append("AAAA".repeat(tmp.length() / 4));
                sb.append("BB");
            }
            
            if (i != splitStr.length - 1) {
                sb.append(".");
            }
        }
        
        String answer = sb.toString();
        
        if (!answer.equals("-1")) {
            sb.append(".".repeat(s.length() - sb.toString().length()));
        }
        
        System.out.println(sb);
    }
}
