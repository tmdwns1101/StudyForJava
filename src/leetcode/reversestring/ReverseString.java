package leetcode.reversestring;

class Solution {
    public void reverseString1(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char temp;
        while(i < j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }

    public void reverseString2(char[] s) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] rs = stringBuilder.append(s).reverse().toString().toCharArray();
        System.out.println(rs);
    }


}

public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s =  {'h','e','l','l','o'};
        solution.reverseString2(s);
    }

}
