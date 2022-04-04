package programmers.p_방금그곡;

import java.util.Arrays;


public class Solution {

    private final String[][] replaceAlpha = {
            {"C#", "c"},
            {"D#", "d"},
            {"F#","f"},
            {"G#", "g"},
            {"A#", "a"}
    };
    public String solution(String m, String[] musicinfos) {

        //방금 그곡 제목
        String answer = "";


        String memory = replaceSharp(m);

        //방금 그곡의 재생 시간
        int time = 0;

        for(String musicInfoStr: musicinfos) {
            String[] info = musicInfoStr.split(",");
            String startTime = info[0];
            String endTime = info[1];

            int curMusicLen = getTimeLength(startTime, endTime);

            String title = info[2];
            String music = replaceSharp(info[3]);

            StringBuilder sb = new StringBuilder();

            int loopCnt = curMusicLen / music.length();

            for(int i=0; i<loopCnt; i++) {
                sb.append(music);
            }
            String subStr =  music.substring(0, curMusicLen % music.length());

            music = sb + subStr;

            if(music.contains(memory)) {
                if(time < curMusicLen) {  //조건을 만족하고, 이전에 기록한 방금 그곡의 재생시간보다 길 때 갱신
                    answer = title;
                    time = curMusicLen;
                }
            }
        }

        if(answer.isEmpty()) {
            answer = "(None)";
        }

        return answer;
    }

    /*
    * 악보에 들어간 "A#", "C#", "D#", "F#", "G#"을 다른 한 개(A,B,C,D,E,F,G를 제외한)의 문자로 치환하는 메서드
    **/
    private String replaceSharp(String s) {
        String result = s;
        for(String[] target: replaceAlpha) {
            result = result.replaceAll(target[0],target[1]);
        }
        return result;
    }

    /**
     * 음악 재생 길이를 반환하는 메서드
     * */
    private int getTimeLength(String startTime, String endTime) {
        int[] start = Arrays.stream(startTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(endTime.split(":")).mapToInt(Integer::parseInt).toArray();

        return (end[0] * 60 + end[1]) - (start[0]*60 + start[1]);
    }
}
