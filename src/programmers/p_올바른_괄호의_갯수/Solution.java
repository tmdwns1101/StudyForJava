package programmers.p_올바른_괄호의_갯수;

public class Solution {

    public int solution(int n) {
        int answer = dfs(n,0,0);
        return answer;
    }
    /*
    1. left : '('의 개수
    2. right : ')'의 개수
    3. 올바른 괄호가 되기 위한 조건
        1. '('와 ')'의 개수는 n개 이하로만 사용 할 수 있음.
        2. 괄호 문자열의 사용된 '('의 개수가 ')'의 개수보다 작다면 해당 문자열은 올바른 괄호 문자열이 될 수 없음. (괄호를 열지 않는한 닫을 수 없으므로)
        3. 2번 조건을 만족하면서 '('과 ')'를 n 개씩 모두 사용하면 괄호 문자열이 만들어진다.
     */
    private int dfs(int n, int left, int right) {
        if(left == n && right == n) {
            return 1;
        } else {
            int sum = 0;
            if(left <= n && right <= n && right <= left) {
                sum += dfs(n,left+1,right);
                sum += dfs(n,left,right+1);
            }
            return sum;
        }
    }
}

