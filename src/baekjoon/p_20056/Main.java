package baekjoon.p_20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 20056
 * 마법사 상어와 파이어볼
 * */
public class Main {
    private static int[][] directions = {
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1}
    };
    static class FireBall {
        int row;
        int col;
        int weight;
        int direct;
        int speed;

        public FireBall(int row, int col, int weight, int speed, int direct) {
            this.row = row;
            this.col = col;
            this.weight = weight;
            this.direct = direct;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<FireBall> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.offer(new FireBall(info[0]-1,info[1]-1,info[2],info[3] ,info[4]));
        }

        List<List<List<FireBall>>> board = new ArrayList<>();
        for(int i=0; i<n; i++) {
            board.add(new ArrayList<>());
            for(int j=0; j<n; j++) {
                board.get(i).add(new ArrayList<>());
            }
        }

        while(k > 0) {
            while(!queue.isEmpty()) {
                FireBall fireBall = queue.poll();
                int nextRow = fireBall.row + directions[fireBall.direct][0] * (fireBall.speed % n);
                int nextCol = fireBall.col + directions[fireBall.direct][1] * (fireBall.speed % n);
                if(nextRow < 0 || nextRow >= n) {
                    nextRow = (n+nextRow) % n;
                }
                if(nextCol < 0 || nextCol >= n) {
                    nextCol = (n+nextCol) % n;
                }
                fireBall.row = nextRow;
                fireBall.col = nextCol;
                board.get(nextRow).get(nextCol).add(fireBall);
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    List<FireBall> fireBalls = board.get(i).get(j);

                    if(fireBalls.size() == 1)  {
                        queue.offer(fireBalls.get(0));
                    }
                    if(fireBalls.size() >= 2){
                        int totalWight = 0;
                        int totalSpeed = 0;
                        int dir = 0;
                        for(FireBall fireBall: fireBalls) {
                            totalWight += fireBall.weight;
                            totalSpeed += fireBall.speed;
                            if(fireBall.direct % 2 == 0) {
                                dir++;
                            } else {
                                dir--;
                            }
                        }
                        int nextWeight = totalWight / 5;
                        int nextSpeed = totalSpeed / fireBalls.size();
                        int[] nextDirs;
                        if(Math.abs(dir) == fireBalls.size()) {
                            nextDirs = new int[]{0,2,4,6};
                        } else {
                            nextDirs = new int[]{1,3,5,7};
                        }
                        if(nextWeight > 0) {
                            for(int d: nextDirs) {
                                queue.offer(new FireBall(i,j,nextWeight,nextSpeed,d));
                            }
                        }
                    }
                    if(fireBalls.size() != 0) {
                        board.get(i).get(j).clear();
                    }
                }
            }
            k--;
        }
        int answer = queue.stream().mapToInt(fireball -> fireball.weight).sum();
        System.out.println(answer);
    }
}
