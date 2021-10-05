package baekjoon.gerrymandering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> connections = new ArrayList<>();
    static int[] population = new int[10];
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        //N번째 구역 인구 입력
        population = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> connection = new ArrayList<>();
            for(int j=0; j<count; j++) {
                int zoneNumber = Integer.parseInt(st.nextToken())-1;
                connection.add(zoneNumber);
            }
            connections.add(connection);
        }

        //선거구 조합 생성
        List<Integer> precinct = new LinkedList<>();
        for(int i=1; i<=n/2; i++) {
            comb(precinct, 0,n,i);
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }

    static void comb(List<Integer> precinct, int start, int n, int r) {
        if(r == 0) {
            gerrymandering(precinct,n);
        }
        else {
            for(int i=start; i<n; i++) {
                precinct.add(i);
                comb(precinct, i+1, n, r-1);
                precinct.remove(precinct.size()-1);
            }
        }

    }

    static void gerrymandering(List<Integer> aPrecinct,int n) {
        List<Integer> bPrecinct = new LinkedList<>();
        for(int i=0; i<n;i++){
            if(!aPrecinct.contains(i)) {
                bPrecinct.add(i);
            }
        }
        if(isValid(aPrecinct) && isValid(bPrecinct)) {
            int aCount = 0;
            int bCount = 0;
            for(int zone: aPrecinct) {
                aCount += population[zone];
            }
            for(int zone: bPrecinct) {
                bCount += population[zone];
            }
            answer = Math.min(answer, Math.abs(aCount-bCount));
        }
    }

    static boolean isValid(List<Integer> precinct) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(precinct.get(0));
        boolean[] check = new boolean[10];
        check[precinct.get(0)] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            List<Integer> connection = connections.get(front);
            for(int zone: connection) {
                if(!check[zone] && precinct.contains(zone)) {
                    queue.offer(zone);
                    count++;
                    check[zone] = true;
                }
            }

        }
        return count == precinct.size();
    }

}
