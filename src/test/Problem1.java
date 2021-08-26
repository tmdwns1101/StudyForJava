package test;

import java.util.*;

public class Problem1 {

    public List<Boolean> solution(String[] infos, String[] actions) {
        List<Boolean> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Arrays.stream(infos).forEach(s -> {
            String[] idAndPassword = s.split(" ");
            map.put(idAndPassword[0], idAndPassword[1]);
        });

        boolean loginState = false;
        boolean isEmptyShopping = true;

        for(String action: actions) {
            String[] parse = action.split(" ");
            String actionType = parse[0];
            if(actionType.equals("LOGIN")) {
                String id = parse[1];
                String password = parse[2];
                if(map.containsKey(id) && map.get(id).equals(password) && !loginState) {
                    loginState = true;
                    answer.add(true);
                } else {
                    answer.add(false);
                }
            } else if(actionType.equals("ADD")) {
                if(loginState) {
                    answer.add(true);
                    isEmptyShopping = false;
                } else {
                    answer.add(false);
                }
            } else {
                if(!isEmptyShopping) {
                    answer.add(true);
                    isEmptyShopping = true;
                } else {
                    answer.add(false);
                }
            }
        }

        return answer;
    }
}
