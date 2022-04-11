package programmers.p_다리를_지나는_트럭;

public class SolutionTest {
    public static void main(String[] args) {

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        Solution solution = new Solution();
        int result = solution.solution(bridge_length,weight,truck_weights);
        System.out.println(result);
    }
}
