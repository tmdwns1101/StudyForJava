package validParentheses;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isValid("(){}[]");
        System.out.println("result = " + result);
    }
}
