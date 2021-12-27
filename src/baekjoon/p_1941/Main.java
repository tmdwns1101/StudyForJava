package baekjoon.p_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static char[][] board = new char[5][5];
    private static int[] values = new int[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 25; i++) {
            values[i] = i;
        }

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        List<Integer> list = new ArrayList<>();
        int answer = dfs(0, list, 0);
        System.out.println(answer);

    }

    private static int dfs(int start, List<Integer> list, int yCount) {
        if (list.size() == 7) {
            return isCloseEachOther(list) ? 1 : 0;
        } else {
            int answer = 0;
            for (int i = start; i < values.length; i++) {
                int current = values[i];
                int row = current / 5;
                int col = current % 5;
                int isY = board[row][col] == 'Y' ? 1 : 0;
                if (yCount + isY <= 3) {
                    list.add(current);
                    answer += dfs(i + 1, list, yCount + isY);
                    list.remove(Integer.valueOf(current));
                }
            }
            return answer;
        }
    }

    private static boolean isCloseEachOther(List<Integer> list) {
        int size = list.size();
        boolean[] isVisited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        isVisited[0] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
            int i = queue.poll();
            cnt++;
            for (int j = 0; j < size; j++) {
                if (i != j && !isVisited[j]) {
                    int a = list.get(i);
                    int b = list.get(j);
                    if (a % 5 == 0) { //맨 왼쪽에 있을 경우, 원래 왼쪽에 근접한 원소가 없으므로, 연산 넘어가기
                        if (a - 1 == b) continue;
                    }
                    if (a % 5 == 4) { //맨 오른쪽에 있을 경우, 원래 오른쪽에 근접한 원소가 없으므로, 연산 넘어가기
                        if (a + 1 == b) continue;
                    }
                    if (a - 1 == b || a + 1 == b || a - 5 == b || a + 5 == b) { //-1: 좌, +1 : 우, -5 : 상, +5 : 하
                        isVisited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        return cnt == 7;
    }
}
