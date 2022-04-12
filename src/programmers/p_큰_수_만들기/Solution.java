package programmers.p_큰_수_만들기;

public class Solution {

    public String solution(String number, int k) {
       StringBuilder sb = new StringBuilder();

       int rest = number.length() - k;
       while(rest > 0) {
           for(int i=9; i>=0; i--) {
               int idx = number.indexOf(String.valueOf(i));
               if(idx != -1 && number.length() - (idx + 1) >= rest - 1) {
                   sb.append(number.charAt(idx));
                   number = number.substring(idx+1);
                   rest--;
                   break;
               }
           }
       }

        return sb.toString();
    }

}
