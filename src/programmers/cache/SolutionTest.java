package programmers.cache;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
        };
        int result = solution.solution(3, cities);
        System.out.println("result = " + result);
    }
}
