package baekjoon.p_13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 13904
 * 과제
 * */
public class Main {

    static class Homework implements Comparable<Homework>{

        int deadLine;
        int weight;
        boolean done;

        public Homework(int deadLine, int weight) {
            this.deadLine = deadLine;
            this.weight = weight;
            done = false;
        }

        @Override
        public int compareTo(Homework o) {
            return Integer.compare(o.weight,this.weight); //내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<Homework> homeworkList = new ArrayList<>();

        int lastDay = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            homeworkList.add(new Homework(deadLine, weight));
            lastDay = Math.max(lastDay, deadLine);
        }

        Collections.sort(homeworkList);

        int answer = 0;
        for(int i=lastDay; i>=1; i--) {
            for(Homework homework: homeworkList) {
                if(!homework.done && homework.deadLine >= i) {
                    answer += homework.weight;
                    homework.done = true;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
