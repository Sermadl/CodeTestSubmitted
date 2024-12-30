import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String minkyum = sc.next();

        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();
        
        int m = 0;

        for (int i = 0; i < minkyum.length(); i++) {
            if (minkyum.charAt(i) == 'M') {
                m++;
            } else {
                max.append(5);
                if (m > 0) {
                    max.append("0".repeat(m));
                    min.append(1);
                    min.append("0".repeat(m-1));
                }
                min.append(5);
                m = 0;
            }
        }
        
        if (m > 0) {
            min.append(1);
            min.append("0".repeat(m-1));
            max.append("1".repeat(m));
        }
        
        System.out.println(max);
        System.out.println(min);
    }
}