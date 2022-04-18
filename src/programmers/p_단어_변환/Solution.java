package programmers.p_단어_변환;

public class Solution {
    private int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        boolean[] visited = new boolean[words.length];

        dfs(words, visited, begin, target, 0);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    private void dfs(String[] words, boolean[] visited, String begin, String target, int count) {
        if(begin.equals(target)){
            answer = Math.min(answer, count);
        }
        else {
            for(int i=0; i<words.length; i++) {
                String word = words[i];
                int dif = 0;
                for(int j=0; j<word.length(); j++) {
                    if(begin.charAt(j) != word.charAt(j)) {
                        dif++;
                    }
                }

                /**
                 * 1. 탐색하려는 다음 단어와 현재 begin 단어와 알파벳 차이가 1개 이면 탐색
                 * 2. but, 이미 탐색한 단어라면 탐색하지 않는다.
                 * */
                if(dif == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(words, visited, word, target, count+1);
                    visited[i] = false;
                }
            }
        }
    }
}
