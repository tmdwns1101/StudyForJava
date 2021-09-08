package targetnumber;
/*
* 프로그래머스 타겟 넘버
 * */
public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int startIndex, int sumValue, int target) {
        if (startIndex == numbers.length) {
            if (sumValue == target) return 1;
            else return 0;
        } else {
            int result = 0;

            result += dfs(numbers, startIndex + 1, sumValue + numbers[startIndex], target);
            result += dfs(numbers, startIndex + 1, sumValue - numbers[startIndex], target);

            return result;
        }
    }
}
