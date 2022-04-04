package programmers.p_방금그곡;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:05,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m = "A#";
        String[] musicinfos = {"03:00,03:01,FOO,A#"};

        String ans = solution.solution(m,musicinfos);
        System.out.println(ans);
    }
}
