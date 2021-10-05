package baekjoon.gatheringenergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> energies = new LinkedList<>();

        for(int i=0; i<n; i++) {
            energies.add(Integer.parseInt(st.nextToken()));
        }
        int answer = dfs(energies, 0,n);
        System.out.println(answer);
    }

    static int dfs(List<Integer> energies, int sum, int n) {
        if(n == 2) return sum;
        else {
            int result = 0;
            List<Integer> temp = new LinkedList<>();
            for(int energy: energies) {
                if(energy != 0) temp.add(energy);
            }
            for(int i=1; i<temp.size()-1;i++) {
                    int energy = temp.get(i);
                    temp.set(i,0);
                    result = Math.max(result,dfs(temp, sum+(temp.get(i-1)*temp.get(i+1)),n-1));
                    temp.set(i,energy);

            }
            return result;
        }
    }
}
