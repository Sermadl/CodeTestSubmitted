import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] numbers = new Integer[numlist.length];
        for (int i = 0; i<numlist.length; i++){
            numbers[i] = numlist[i];
        }

        Arrays.sort(numbers, (a,b) -> {
            if (Math.abs(a - n) == Math.abs(b - n)) return b - a;
            else {
                return Math.abs(a - n) - Math.abs(b - n);
            }
        });

        return Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
    }
}