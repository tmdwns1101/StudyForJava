package removeduplicateletters;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> counter = new HashMap<>();
        char[] chars = s.toCharArray();

        //해당 문자열에 등장한 알파벳의 종류 당 개수 카운팅
        for (char alpha : chars) {
            if(counter.containsKey(alpha)) {
                 counter.put(alpha, counter.get(alpha)+1);
            } else {
                counter.put(alpha, 1);
            }
        }

        //확인 한 문자를 담아둔다.
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (char alpha : chars) {

            //확인 한 문자의 개수를 하나 씩 지우기
            counter.put(alpha, counter.get(alpha)-1);

            //이미 확인 된 문자는 더 이상 확인 할 필요가 없음
            //이미 앞에서 등장했기 때문에 해당 문자는 중복된 문자이므로
            if(seen.contains(alpha)) continue;

            /*
                 1. 중복 문자를 제거 할 때 사전순으로 정렬되어 있으여 한다.
                 2. stack의 최상단 문자가 해당 문자보다 크고, 최상단 문자가 해당 문자보다 뒤에 또 등장 하게 된다면
                제거.( counter.get(stack.peek()) == 0 이라는 것 은 더 이상 나오지 않을 문자이므로 제거하면 안됨.)
                 3. 제거 된 문자는 더 이상 확인 된 문자가 아니므로 seen에서 제거
             */
            while(!stack.isEmpty() &&  alpha < stack.peek() && counter.get(stack.peek()) > 0) {
                seen.remove(stack.pop());
            }
            stack.push(alpha);
            seen.add(alpha);
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
