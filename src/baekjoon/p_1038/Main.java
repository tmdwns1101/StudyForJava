package baekjoon.p_1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1038 - 감소하는 수
 * */
public class Main {
    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String answer;



        //모든 감소하는 수 찾기
        //순서는 보장 못 함. (깊이 우선 탐색이기 때문에)
        for (int i = 0; i < 10; i++) {
            String start = String.valueOf(i);
            list.add(Long.valueOf(start));
            dfs(i, start);
        }

        //감소하는 수를 정렬
        //순서를 맞춘다.
        list.sort(null);

        if(n >= list.size()) {
            answer = "-1";
        } else {
            answer = String.valueOf(list.get(n));
        }

        System.out.println(answer);
    }

    private static void dfs(int cur, String result) {

        for (int i = 0; i < 10; i++) {
            if (i < cur) {
                Long next = Long.valueOf(result+i);
                list.add(next);
                dfs(i, result+i);
            }
        }


    }
}
