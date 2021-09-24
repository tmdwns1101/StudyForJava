package baekjoon.populationmovement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nlr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nlr[0];
        int l = nlr[1];
        int r = nlr[2];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = row;
        }

        int answer = 0;


        while (true) {
            Map<Integer, List<int[]>> map = new HashMap<>();

            int[][] tempArr = new int[n][n];
            int number = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tempArr[i][j] == 0) {
                        List<int[]> result = bfs(arr, tempArr, n, l, r, i, j, number);
                        map.put(number++, result);
                    }
                }
            }
            //1. number값이 n*n 보다 작거나 같다는 것은 연합이 생성되어 인구가 이동했다.
            //2. number 값이 n*n 보다 크다는 것은 number 값이 n*n 까지 증가하여 해당 배열에 연합이 생성이 안되어 인구가 이동하지 않는 상태
            // 따라서 종료 조건이 된다.
            if(number <= n*n) {
                answer++;
                for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()) {
                    int size = entry.getValue().size();

                    int total = 0;
                    for(int[] location: entry.getValue()) {
                        total += arr[location[0]][location[1]];
                    }
                    for(int[] location: entry.getValue()) {
                       arr[location[0]][location[1]] = total/size;
                    }
                }

            } else {
                System.out.println(answer);
                break;
            }
        }

    }

    public static List<int[]> bfs(int[][] arr, int[][] tempArr, int n, int l, int r, int row, int col, int number) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        tempArr[row][col] = number;

        //해당 연합에 속하는 나라의 좌표를 저장.
        List<int[]> unions = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int x = front[1];
            int y = front[0];
            unions.add(new int[]{y, x});
            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if (nx >= 0 &&
                        nx < n &&
                        ny >=0 &&
                        ny < n &&
                        tempArr[ny][nx] == 0 &&
                        Math.abs(arr[y][x] - arr[ny][nx]) >= l && Math.abs(arr[y][x] - arr[ny][nx]) <= r
                ) {
                    tempArr[ny][nx] = number;
                    queue.offer(new int[]{ny, nx, arr[ny][nx]});
                }
            }
        }
        return unions;
    }


}
