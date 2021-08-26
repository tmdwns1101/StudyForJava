package test;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        Problem2 problem2 = new Problem2();
        Problem3 problem3 = new Problem3();

//        String[] input2 = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F","MD1111 B-", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
//        String[] input2 = {"DS7651 A0", "DS7652 C-", "DS7651 A+", "DS7652 B-", "DS7652 B-"};
//        List<String> result2 = problem2.solution(input2);
//        System.out.println("result2 = " + result2);
        
        String[] input3 = {"ABL","DPC"};
        int result = problem3.solution("AP", input3);
        System.out.println("result = " + result);
    }
}
