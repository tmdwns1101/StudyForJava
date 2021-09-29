package baekjoon.fishingking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Shark {
        int row;
        int col;
        int direct;
        int speed;
        int size;

        Shark(int row, int col, int speed, int direct, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direct = direct;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        Shark[][] sharks = new Shark[r][c];

        Shark[][] sea = new Shark[r][c];
        List<Shark> sharks = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int[] sharkInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = sharkInfo[0];
            int col = sharkInfo[1];
            int s = sharkInfo[2];
            int d = sharkInfo[3];
            int z = sharkInfo[4];
            Shark shark = new Shark(row - 1, col - 1, s, d, z);
            sharks.add(shark);
            sea[row - 1][col - 1] = shark;

        }

        int person = 0;
        int answer = 0;

        while (person < c) {

            int minRow = r;
            int removeIdx = -1;
            for (Shark shark : sharks) {
                if (shark.col == person && shark.row < minRow) {
                    minRow = shark.row;
                    removeIdx = sharks.indexOf(shark);
                }
            }

            if (removeIdx != -1) {
                Shark shark = sharks.get(removeIdx);
                answer += shark.size;
                sharks.remove(shark);

            }


            //상어 이동


            for (Shark shark : sharks) {
                int nx = shark.col;
                int ny = shark.row;


                //위
                if (shark.direct == 1) {
                    int p = shark.speed - shark.row;
                    if (p <= 0) {
                        ny = shark.row - shark.speed;
                    } else {
                        int share = p / (r - 1);
                        int rest = p % (r - 1);
                        if (share % 2 == 0) {
                            shark.direct = 2;
                            ny = rest;
                        } else {
                            ny = r - 1 - rest;
                        }

                    }
                }
                //아래
                else if (shark.direct == 2) {
                    int p = shark.speed - (r - 1 - shark.row);
                    if (p <= 0) {
                        ny = shark.row + shark.speed;
                    } else {
                        int share = p / (r - 1);
                        int rest = p % (r - 1);
                        if (share % 2 == 0) {
                            shark.direct = 1;
                            ny = r - 1 - rest;
                        } else {
                            ny = rest;
                        }
                    }
                }

                //오른쪽
                else if (shark.direct == 3) {
                    int p = shark.speed - (c - 1 - shark.col);
                    if (p <= 0) {
                        nx = shark.col + shark.speed;
                    } else {
                        int share = p / (c - 1);
                        int rest = p % (c - 1);
                        if (share % 2 == 0) {
                            shark.direct = 4;
                            nx = c - 1 - rest;
                        } else {
                            nx = rest;
                        }
                    }
                }

                //왼쪽
                else {
                    int p = shark.speed - shark.col;
                    if (p <= 0) {
                        nx = shark.col - shark.speed;
                    } else {
                        int share = p / (c - 1);
                        int rest = p % (c - 1);
                        if (share % 2 == 0) {
                            shark.direct = 3;
                            nx = rest;
                        } else {
                            nx = c - 1 - rest;
                        }
                    }
                }

                shark.row = ny;
                shark.col = nx;

            }

            //사이즈가 더 큰 상어만 살아남기
            //temp : 해당 행 열에는 가장 큰 상어만 저장
            //deadSharks : 먹힌 상어
            //이미 상어가 해당 위치에 있으면, 큰 상어는 temp에 남기고, 둘 중 작은 상어는 deadSharks에 넣는다.
            //상어가 해당 위치에 없으면, temp에 무조건 넣음.
            Shark[][] temp = new Shark[r][c];
            List<Shark> deadSharks = new LinkedList<>();
            for (Shark shark : sharks) {
                int row = shark.row;
                int col = shark.col;
                if (temp[row][col] != null) {
                    if (temp[row][col].size < shark.size) {
                        deadSharks.add(temp[row][col]);
                        temp[row][col] = shark;
                    } else {
                        deadSharks.add(shark);
                    }
                } else {
                    temp[row][col] = shark;
                }
            }
            sharks.removeAll(deadSharks);

            //낚시왕 한 칸 오른쪽으로 이동.
            person++;
        }
        System.out.println(answer);
    }
}
