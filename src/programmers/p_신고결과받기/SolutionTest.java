package programmers.p_신고결과받기;

public class SolutionTest {
    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution solution = new Solution();
        int[] result = solution.solution(idList,report,k);
        for(int r: result){
            System.out.println(r);
        }
    }
}
