package baekjoon.selectnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(br.readLine());
            nodes.get(number).add(i);
        }

        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> node = nodes.get(i);
            for (int item : node) {
                //이미 선택한 숫자는 다시 탐색할 필요가 없다.
                if (!set.contains(item)) {
                    boolean result = dfs(set, nodes, item, i);
                    if (result) {
                        set.add(item);
                    }
                }
            }
        }
        System.out.println(set.size());
        for (int item : set) {
            System.out.println(item);
        }
    }


    /*
    * 1. 기저 조건 : 현재 노드 값과 선택할려는 숫자 와 같으면 탐색을 종료
    * 2. 탐색 결과
    *   2-1. 참인 경우 :  1 -> 2 -> 3 -> 1 == (윗줄,아랫줄) (1,3), (3,2), (2,1) 이므로, target 값을 찾은 경로 값 들은 모두 선택해준다.
    *   2-2. 거짓인 경우: 결국 target 값을 못 찾았으므로, 해당 숫자를 선택 하지 않음.
    * */
    public static boolean dfs(Set<Integer> set, List<List<Integer>> nodes, int current, int target) {
        if (current == target) {
            return true;
        } else {
            List<Integer> node = nodes.get(current);
            for (int item : node) {
                //이미 선택한 숫자는 탐색할 필요 없음.
                if (!set.contains(current)) {
                    boolean check = dfs(set, nodes, item, target);
                    if (check) {
                        //해당 값을 찾으면, 숫자를 선택하고, 그 숫자 카드는 하나 이기 때문에 또 다시 다른 경우로 선택되는 경우는 없기때문애 더 이상 탐색 하지 않고 반환.
                        set.add(item);
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
