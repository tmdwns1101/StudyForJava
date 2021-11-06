package programmers.p_전화번호목록;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Boolean> map = new HashMap<>();

        for(String phone: phone_book) {
            map.put(phone, true);
        }

        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++) {
                String subStr = phone.substring(0,i);
                if(map.containsKey(subStr)) {
                    answer = false;
                    break;
                }
            }
            if(!answer) break;
        }
        return answer;
    }
}
