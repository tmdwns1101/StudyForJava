package programmers.p_특별모의고사.p2;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] booked = {{"09:55", "hae"}, {"10:05", "jee"}};
        String[][] unbooked = {{"10:04", "hee"}, {"14:07", "eom"}};
        solution.solution(booked, unbooked);
    }
}
