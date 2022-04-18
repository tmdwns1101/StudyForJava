package programmers.p_단어_변환;

public class SolutionTest {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        Solution solution = new Solution();

        int result = solution.solution(begin,target,words);
        System.out.println(result);
    }
}
