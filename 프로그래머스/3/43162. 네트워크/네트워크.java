class Solution {
    int n;
    int[][] computers = {};
    boolean[] visited = {};
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int idx, boolean[] visited) {
        if (visited[idx]) return;
        
        visited[idx] = true;
        
        for (int i = 0; i < n; i++) {
            if (idx == i) continue;
            if (computers[idx][i] == 1) dfs(i, visited);
        }
    }
}