package programmers.p_키패드_누르기;

public class SolutionTest {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution solution = new Solution();
        
        String result = solution.solution(numbers, hand);
        System.out.println("result = " + result);
    }
}
