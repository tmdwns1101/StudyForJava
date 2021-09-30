package programmers.ranksearch;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] infoes = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] queries = {
                "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"
        };
//        List<Integer> list =  solution.solution(infoes,queries);
        int[] result = solution.solution(infoes, queries);
        System.out.println("list.toString() = " + Arrays.toString(result));
    }
}
