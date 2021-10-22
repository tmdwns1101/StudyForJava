package hacker_rank.save_the_prisoner;

public class Solution {

    public int saveThePrisoner(int n, int m, int s) {
        int answer = 0;
        answer = (s+(m-2)) % n + 1;
        return answer;
    }
}
