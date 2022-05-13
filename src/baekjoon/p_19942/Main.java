package baekjoon.p_19942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 다이어트 - 19942
 * */
public class Main {

    private static int n;

    private static int mp; //최소 단백질
    private static int mf; //최소 지방
    private static int ms; //최소 탄수화물
    private static int mv; //최소 비타민

    private static int minCost = Integer.MAX_VALUE;
    private static List<Integer> answer;

    private static class Ingredient {
        int protein;
        int fat;
        int carbohydrate;
        int vitamins;
        int cost;

        public Ingredient(int protein, int fat, int carbohydrate, int vitamins, int cost) {
            this.protein = protein;
            this.fat = fat;
            this.carbohydrate = carbohydrate;
            this.vitamins = vitamins;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        Ingredient[] ingredients = new Ingredient[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int protein = Integer.parseInt(st.nextToken());
            int fat = Integer.parseInt(st.nextToken());
            int carbohydrate = Integer.parseInt(st.nextToken());
            int vitamins = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            ingredients[i] = new Ingredient(protein, fat, carbohydrate, vitamins, cost);
        }

        boolean[] isVisited = new boolean[n];
        dfs(ingredients, isVisited, 0,0,0,0,0,0);
        if(minCost == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minCost);
            StringBuilder sb = new StringBuilder();
            for(int number: answer) {
                sb.append(number).append(" ");
            }
            System.out.println(sb);
        }

    }

    private static void dfs(Ingredient[] ingredients, boolean[] isVisited, int start, int accP, int accF, int accS, int accV, int sumCost) {
        if (accP >= mp && accF >= mf && accS >= ms && accV >= mv && minCost > sumCost) {
            minCost = sumCost;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < isVisited.length; i++) {
                if (isVisited[i]) list.add(i + 1);
            }
            answer = list;
        } else {
            for (int i = start; i < n; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(ingredients,
                            isVisited,
                            i + 1,
                            accP + ingredients[i].protein,
                            accF + ingredients[i].fat,
                            accS + ingredients[i].carbohydrate,
                            accV + ingredients[i].vitamins,
                            sumCost + ingredients[i].cost);
                    isVisited[i] = false;
                }
            }
        }
    }
}
