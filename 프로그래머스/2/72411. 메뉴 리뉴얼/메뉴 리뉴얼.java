import java.util.*;

class Solution {
    Map<String, Integer> tmp;
    int max = 0;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        ArrayList<String> result = new ArrayList<>();
        
        // "스카피"가 추가하고 싶어하는 코스 요리 메뉴 개수 별로 가장 많은 주문을 받은 메뉴를 후보에 추가한다.
        for (int c : course) {
            tmp = new HashMap<>(); // 개수 별로 메뉴 조합을 저장하기 때문에 초기화를 여기서 해줌
            max = 0; // 개수 별로 메뉴 가장 많은 주문을 저장하기 때문에 초기화를 여기서 해줌
            
            for (String order : orders) {
                // 손님들이 주문한 메뉴를 정렬해서 중복을 제거
                char[] orderSort = order.toCharArray();
                Arrays.sort(orderSort);

                combination(0, orderSort, c, ""); // 현재 개수(c)에 해당하는 메뉴 조합 완전 탐색
            }

            // 조합들 중에서 2번 이상 주문된 메뉴 중에 가장 많이 주문된 조합을 result에 추가
            for (String key : tmp.keySet()) {
                int value = tmp.get(key);
                if (value > 1 && value == max) {
                    result.add(key);
                }
            }
        }
        
        // result를 정렬하고 answer에 형변환하여 저장
        answer = result.toArray(new String[0]);
        Arrays.sort(answer);
        
        return answer;
    }
    
    private void combination(int start, char[] target, int c, String result) {
        // 현재 개수와 같은 개수의 메뉴 조합만 저장
        if (c == result.length()) {
            tmp.put(result, tmp.getOrDefault(result, 0) + 1);
            
            // max에 저장되어 있는 값보다 해당 메뉴의 주문 수가 많으면 max를 바꿈
            if (max < tmp.get(result)) {
                max = tmp.get(result);
            }
        }

        // 완전 탐색을 위한 반복문
        for (int i = start; i < target.length; i++) {
            combination(i + 1, target, c, result + target[i]);
        }
    }
}