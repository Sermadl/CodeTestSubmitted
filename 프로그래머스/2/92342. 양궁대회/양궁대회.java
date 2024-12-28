class Solution {
    private int total = 0;
    private int[] answer = {-1};
    private int[] ryanInfo = new int[11];
    private int N;
    private int maxScore = 0;
    
    public int[] solution(int n, int[] info) {
        N = n;
        dfs(0, 0, info);
        
        return answer;
    }
    
    private void dfs(int start, int n, int[] info) {
        if (n >= N) {
            scoreCheck(info);
            return;
        }
        
        // 10 - i번째 과녁에 라이언이 쏜 화살의 개수가 어피치가 쏜 화살의 개수보다 많아지면 멈춤
        // 그 전까지 계속해서 dfs로 모든 경우의 수를 조합함
        for (int i = start; i < 11; i++) {
            if(ryanInfo[i] > info[i]) continue;
            ryanInfo[i]++;
            dfs(i, n + 1, info);
            ryanInfo[i]--; // 모든 경우의 수를 조합해보기 위해 원상복구
        }
        
        
    }
    
    private void scoreCheck(int[] info) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (info[i] < ryanInfo[i]) {
                ryanScore += 10 - i;
            } else if (info[i] > ryanInfo[i]){
                apeachScore += 10 - i;
            } else {
                if (ryanInfo[i] != 0) {
                    apeachScore += 10 - i;
                }
            }
        }
        
        if (ryanScore > apeachScore) {
            int temp = ryanScore - apeachScore;
            if (maxScore < temp) {
                maxScore = temp;
                answer = ryanInfo.clone();
            } else if (maxScore == temp) {
                for (int j = 10; j >= 0; j--) {
                    if (answer[j] < ryanInfo[j]) {
                        answer = ryanInfo.clone();
                    } else if (answer[j] > ryanInfo[j]) {
                        return;
                    }
                }
            }
        }
    }
}