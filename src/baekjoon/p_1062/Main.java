package baekjoon.p_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 가르침 - 1062
 * */
public class Main {

    private static int n;
    private static int k;

    private static final char[] requireAlpha = {'a','n','t','i','c'};

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            answer = 0;
        } else {
            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            boolean[] isStudy = new boolean[26];
            for(char alpha: requireAlpha) {
                isStudy[alpha-'a'] = true;
            }

            dfs(words, isStudy, 0,5);
        }

        System.out.println(answer);
    }


    private static void dfs(String[] words, boolean[] isStudy, int start, int count) {
        if(count == k) {
            int result = 0;
            for(String word: words) {
                if(isKnow(word, isStudy)) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
        } else {
            for(int i=start; i<26; i++) {
                if(!isStudy[i]) {
                    isStudy[i] = true;
                    dfs(words, isStudy, i,count+1);
                    isStudy[i] = false;
                }
            }
        }

    }

    private static boolean isKnow(String word, boolean[] isStudy) {
        boolean flag = true;
        for(char alpha: word.toCharArray()) {
            if(!isStudy[alpha-'a']) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
