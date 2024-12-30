 import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] machine = new long[n];
        
        for (int i = 0; i < n; i++) {
            machine[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(machine);
        long min = 0;
        
        if (n % 2 == 0){
            for (int i = 0; i < n/2; i++){
                min = Math.max(min, machine[i] + machine[n - i - 1]);
            }
        } else {
            min = machine[n-1];
            
            for (int i = 0; i < n/2; i++){
                min = Math.max(min, machine[i] + machine[n - i - 2]);
            }
        }

        System.out.print(min);
    }
}