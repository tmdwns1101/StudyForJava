package programmers.p_오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private class Log {
        String uuid;
        String message;

        public Log(String uuid, String message) {
            this.uuid = uuid;
            this.message = message;
        }
    }

    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();

        List<Log> logs = new ArrayList<>();

        for(String record: records) {
            String[] info = record.split(" ");
            String operation = info[0];

            if(operation.equals("Change")) {
                map.put(info[1],info[2]);
            } else if (operation.equals("Enter")) {
                map.put(info[1], info[2]);
                logs.add(new Log(info[1],"님이 들어왔습니다."));
            } else {
                logs.add(new Log(info[1],"님이 나갔습니다."));
            }
        }
        List<String> answer = new ArrayList<>();
        for(Log log: logs) {
            answer.add(map.get(log.uuid) + log.message);
        }


        return answer.toArray(new String[0]);
    }
}
