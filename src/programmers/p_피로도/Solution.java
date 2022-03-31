package programmers.p_피로도;

public class Solution {

    private int answer;

    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited);

        return answer;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited) {
        boolean noMore = true;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                noMore = false;
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }

        //더 이상 탐색을 못 할 경우, 지금까지 탐색한 던전 개수 계산
        if (noMore) {
            int count = 0;
            for (boolean v : visited) {
                if (v) count++;
            }
            //가장 많은 탐색 수 결정
            answer = Math.max(answer, count);
        }
    }


}
