package baekjoon.treeinvestment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] moveX = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] moveY = {0, -1, -1, -1, 0, 1, 1, 1};
    static class Tree {
        int row;
        int col;
        int age;
        Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];

        int[][] area = new int[n][n];
        Arrays.stream(area).forEach(a -> Arrays.fill(a, 5));
        int[][] memoryArea = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            memoryArea[i] = row;
        }

        List<Tree> trees = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = input[0] - 1;
            int col = input[1] - 1;
            int age = input[2];
            trees.add(new Tree(row, col, age));
        }

        Queue<Tree> deadTrees = new LinkedList<>();
        while (k > 0) {

            //봄
            Iterator<Tree> iterator = trees.iterator();
            while (iterator.hasNext()) {
                Tree tree = iterator.next();
                int age = tree.age;
                int row = tree.row;
                int col = tree.col;
                if(age <= area[row][col]) {
                    area[row][col] -= age;
                    tree.age += 1;
                } else {
                    iterator.remove();
                    deadTrees.offer(tree);
                }
            }

            //여름
            while(!deadTrees.isEmpty()) {
                Tree tree = deadTrees.poll();
                area[tree.row][tree.col] += tree.age / 2;
            }


            //가을
            List<Tree> newTrees = new LinkedList<>();
            for(Tree tree: trees) {
                int x = tree.col;
                int y = tree.row;
                if(tree.age % 5 == 0) {
                    for(int i=0; i<8; i++) {
                        int nx = x + moveX[i];
                        int ny = y + moveY[i];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            newTrees.add(new Tree(ny,nx,1));
                        }
                    }
                }
            }
            trees.addAll(0, newTrees); //나이 적은 나무들이 항상 앞으로 정렬 됨.

            //겨울
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    area[i][j] += memoryArea[i][j];
                }
            }

            k--;
        }
        int answer = trees.size();
        System.out.println(answer);
    }
}
