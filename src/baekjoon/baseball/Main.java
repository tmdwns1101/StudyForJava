package baekjoon.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int battingOrder = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] informations = new int[n][10];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                informations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //타순
        List<List<Integer>> orders = new ArrayList<>();
        int[] players = {2,3,4,5,6,7,8,9};
        makeOrders(orders,new ArrayList<>(), players);

        int answer = 0;
        for (List<Integer> order : orders) {
            int score = 0;
            battingOrder = 0;
            for (int[] information : informations) {
                score += calcScore(order, information);
            }
            answer = Math.max(answer, score);
        }
        System.out.println(answer);
    }

    static void makeOrders(List<List<Integer>> orders, List<Integer> order, int[] players) {
        if(order.size() == 9) {
            orders.add(order);
        }
        else if(order.size() == 3) {
            order.add(1);
            makeOrders(orders, order, players);
        }
        else {
            for(int i=0; i<players.length; i++) {
                if(players[i] == 0) continue;
                List<Integer> newOrder = new ArrayList<>(order);
                int player = players[i];
                players[i] = 0;
                newOrder.add(player);
                makeOrders(orders, newOrder, players);
                players[i] = player;
            }
        }
    }

    static int calcScore(List<Integer> order, int[] information) {
       int outCount = 0;
       int[] base = new int[3];
       int score = 0;

       while(outCount < 3) {
           int player = order.get(battingOrder % 9);
           int go = information[player];
           if(go == 0) outCount++;
           else {
               for(int i=2; i>=0; i--) {
                   if(base[i] == 1) {
                       base[i] = 0;
                       if(i+go >= 3) score += 1;
                       else base[i+go] = 1;
                   }
               }
               if(go-1>=3) score += 1;
               else base[go-1] = 1;
           }
           battingOrder++;
       }
       return score;
    }

}
