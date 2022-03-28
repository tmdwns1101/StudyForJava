package programmers.p_신고결과받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //Map<유저명,유저 index>
        Map<String, Integer> userMap = new HashMap<>();

        //유저당 해당 유저가 신고한 유저 목록
        List<List<String>> userReportList = new ArrayList<>();


        for(int i=0; i<id_list.length; i++) {
            userMap.put(id_list[i],i);
            userReportList.add(new ArrayList<>());
        }

        //Map<유저명,신고 당한 횟수>
        Map<String, Integer> reportCount = new HashMap<>();

        for(String reportString: report) {
            String[] content = reportString.split(" ");
            String reporter = content[0];
            String badUser = content[1];

            int idx = userMap.get(reporter);
            List<String> myReports = userReportList.get(idx);


            if(!myReports.contains(badUser)) {   //이미 해당 유저가 신고한 유저인지 확인
                int count = reportCount.getOrDefault(badUser,0);
                reportCount.put(badUser, count+1);
                myReports.add(badUser); //신고 목록에 추가
            }
        }

        for(int i=0; i< userReportList.size(); i++) {
            List<String> myReportList = userReportList.get(i);
            for(String user: myReportList) {
                if(k <= reportCount.get(user)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
