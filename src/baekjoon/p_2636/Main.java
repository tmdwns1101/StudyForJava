package baekjoon.p_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 치즈 - 2636
 * */
public class Main {

    private static final int[][] directions = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cheeses = new int[n][m];

        int cheeseCount = 0;
        for(int i=0; i<n; i++) {
            cheeses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++) {
                if(cheeses[i][j] == 1) cheeseCount++;
            }
        }

        int time = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;
        List<int[]> temp = new ArrayList<>();



        while(cheeseCount > 0) {

            count = cheeseCount;
            time++;


            while(!queue.isEmpty()) {
                int[] front = queue.poll();
                for(int[] dir: directions) {
                    int nextRow = front[0] + dir[0];
                    int nextCol = front[1] + dir[1];
                    if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !isVisited[nextRow][nextCol]) {
                        if(cheeses[nextRow][nextCol] == 1) {
                            temp.add(new int[]{nextRow,nextCol});
                            cheeseCount--;
                        }
                        if(cheeses[nextRow][nextCol] == 0) {
                            queue.offer(new int[]{nextRow,nextCol});
                        }
                        isVisited[nextRow][nextCol] = true;
                    }
                }
            }

            for(int[] elem: temp) {
                cheeses[elem[0]][elem[1]] = 0;
                queue.offer(elem);
            }
            temp.clear();
        }
        System.out.println(time);
        System.out.println(count);
    }
}
