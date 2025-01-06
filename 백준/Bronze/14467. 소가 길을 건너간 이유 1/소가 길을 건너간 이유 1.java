import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] cow = new int[10];
        Arrays.fill(cow, -1);
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int move = Integer.parseInt(st.nextToken());
            
            if (cow[idx] == -1) cow[idx] = move;
            else {
                if (cow[idx] != move){
                    cow[idx] = move;
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}