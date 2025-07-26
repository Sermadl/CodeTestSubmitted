class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                int tmpMin = 0;
                int tmpMax = 0;
                
                if (lines[i][0] < lines[j][1] && lines[i][1] > lines[j][0]) {
                    tmpMin = Math.max(lines[i][0], lines[j][0]);
                    tmpMax = Math.min(lines[i][1], lines[j][1]);
                    
                    if (min != tmpMin || max != tmpMax) {
                        if (min > tmpMax || max < tmpMin) {
                            if (max != Integer.MIN_VALUE && min != Integer.MAX_VALUE)
                                answer += (max - min);
                            min = tmpMin;
                            max = tmpMax;
                        } else {
                            min = Math.min(min, tmpMin);
                            max = Math.max(max, tmpMax);
                        }
                    }
                }
            }
        }
        
        if (max != Integer.MIN_VALUE && min != Integer.MAX_VALUE)
            answer += (max - min);
        
        return answer;
    }
}