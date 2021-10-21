package hacker_rank.non_divisible_subset;

import java.util.List;
public class Solution {

    //s[i] 와 s[j] 의 합이 k로 나누어지지 않기 위해서는, s[i] % k 값과 s[j] % k 의 합이 0 또는 k가 아니면 된다.
    public int nonDivisibleSubset(int k, List<Integer> s) {
        int answer = 0;

        int[] arr = new int[k];

        for(int item: s) {
            arr[item % k]++;
        }

        //k가 짝수 일 경우, s[i]를 나눈 나머지 값이 k/2 인경우 최대 한 개만 선택 가능.
        if(k % 2 == 0) {
            answer = Math.min(arr[k/2],1);
        }

        //s[i]를 나눈 나머지 값 0 은 최대 한 개만 선택 가능.
        answer += Math.min(arr[0],1);

        for(int i =1; i<=k/2; i++) {
            if(i != k - i) {
                //1. 선택시, m(s[i]를 k로 나눈 나머지 값) 은 k - m 값을 나머지로 갖는 정수랑만 같이 선택 하지 않는다면, 어떤 한 수와 합해도 k로 나누어 떨어지지 않음.
                //2. 즉 둘 중에서 더 많은 수를 갖는 것을 선택한다.
                answer += Math.max(arr[i], arr[k-i]);
            }
        }

        return answer;
    }
}
