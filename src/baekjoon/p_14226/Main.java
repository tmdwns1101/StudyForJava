package baekjoon.p_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static class Node {
        int screenCount;
        int clipBoardCount;
        int time;

        public Node(int screenCount, int clipBoardCount, int time) {
            this.screenCount = screenCount;
            this.clipBoardCount = clipBoardCount;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int answer = solution(target);

        System.out.println(answer);

    }

    private static int solution(int target) {

        int answer = 0;


        //행 : 화면에 표시된 이모티콘 개수
        //열 : 클립보드에 저장된 이모티콘 개수
        boolean[][] visited = new boolean[2001][2001];


        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(1,0,0));
        visited[1][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int screenCount = node.screenCount;
            int clipBoardCount = node.clipBoardCount;
            int time = node.time;
            if(screenCount == target) {
                answer = time;
                break;
            }

            //1. 화면에 표시된 이모티콘 클립보드에 저장
            if(!visited[screenCount][screenCount]) {
                visited[screenCount][screenCount] = true;
                queue.offer(new Node(screenCount, screenCount, time+1));
            }

            //2. 화면에 클립보드에 저장된 이모티콘 붙이기
            //단, 화면에 최대 1000개만 표시 되므로, 화면에 최대 1000개, 클립보드에 1000개 만 저장 될 수 있음.
            if(clipBoardCount != 0 && screenCount+clipBoardCount <= 2000 &&!visited[screenCount+clipBoardCount][clipBoardCount]) {
                visited[screenCount+clipBoardCount][clipBoardCount] = true;
                queue.offer(new Node(screenCount+clipBoardCount, clipBoardCount, time+1));
            }

            //3. 화면에서 이모티콘 한 개 제거
            if(screenCount != 0 && !visited[screenCount-1][clipBoardCount]) {
                visited[screenCount-1][clipBoardCount] = true;
                queue.offer(new Node(screenCount-1, clipBoardCount, time+1));
            }

        }
        return answer;
    }
}
