import java.util.regex.Pattern;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String step2 = "[^a-z0-9._-]";
        String step3 = "[.]{2,}";
        String step4 = "^[.]|[.]$";
        String step5 = "a";
        String step6 = "^[a-z0-9_-]+$";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        new_id = new_id.replaceAll(step2, "");
        
        // 3단계
        new_id = new_id.replaceAll(step3, ".");
        
        // 4단계
        new_id = new_id.replaceAll(step4, "");
        
        // 5단계
        if (new_id.equals("")) {
            new_id = "a";
        }
        
        // 6단계
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        
        // 7단계
        if (new_id.length() < 3) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}