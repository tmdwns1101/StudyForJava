package kakaofriendscolor;

import java.util.*;

public class Solution {

    private int[] moveX = {1, -1, 0, 0};
    private int[] moveY = {0, 0, 1, -1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] copyPicture = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                copyPicture[i][j] = picture[i][j];
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(copyPicture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(bfs(copyPicture, m, n, i, j, picture[i][j]),maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;


        return answer;
    }

    private int bfs(int[][] picture, int m, int n, int row, int col, int area) {

        class Position {
            int xpos;
            int ypos;

            Position(int xpos, int ypos) {
                this.xpos = xpos;
                this.ypos = ypos;
            }
        }

        Queue<Position> queue = new LinkedList<>();
        int count = 0;
        Position pos = new Position(col, row);
        queue.offer(pos);
        picture[row][col] = 0;
        while(!queue.isEmpty()) {
            Position front = queue.poll();
            count++;
            for(int i=0; i<4; i++) {
                int nx = front.xpos + moveX[i];
                int ny = front.ypos + moveY[i];
                if(nx >=0 && nx < n &&
                        ny >=0 && ny < m &&
                        picture[ny][nx] == area
                )  {
                    queue.offer(new Position(nx, ny));
                    picture[ny][nx] = 0;
                }
            }
        }
        return count;
    }
}
