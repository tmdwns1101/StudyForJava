package programmers.p_파일명_정렬;

public class SolutionTest {
    public static void main(String[] args) {
        String[] files = {"O00321", "O49qcGPHuRLR5FEfoO00321"};
        Solution solution = new Solution();
        String[] result= solution.solution(files);
        for(String r: result) {
            System.out.println(r);
        }
    }
}
