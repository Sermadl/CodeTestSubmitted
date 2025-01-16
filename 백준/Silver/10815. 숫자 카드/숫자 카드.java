import java.io.*;
import java.util.*;

class Main {
    private static int[] cards;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            bw.write(findNum(num) + " ");
        } 
        
        bw.close();
        br.close();
    }
    
    private static int findNum(int target) {
        int start = 0;
        int end = n - 1;
        int flag = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (cards[mid] < target) {
                start = mid + 1;
            } else if (cards[mid] > target) {
                end = mid - 1;
            } else {
                flag = 1;
                break;
            }
        }
        
        return flag;
    }
}