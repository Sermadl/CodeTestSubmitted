import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oct = sc.nextLine();
        StringBuilder result = new StringBuilder();

        String[] lib = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < oct.length(); i++) {
            int left = oct.charAt(i) - '0';
            result.append(lib[left]);
        }

        if (oct.equals("0")) {
            System.out.println(0);
        } else {
            while(result.charAt(0) == '0') {
                result = new StringBuilder(result.substring(1));
            }

            System.out.println(result);
        }
    }
}