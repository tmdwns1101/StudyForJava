package programmers.p_주차요금_계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] solution(int[] fees, String[] records) {

        /*
        *  map
        *  key: 자동차 번호, value : 주차장 진입 시간
        * */
        Map<String, Integer> map = new HashMap<>();

        /*
        * result
        * key : 자동차 번호, value = 주차장 총 이용 시간
        * TreeMap을 이용해 자동차 번호가 작은 순으로 정렬
        * */
        Map<String, Integer> result = new TreeMap<>();

        for(String record: records) {
            String[] info = record.split(" ");
            int[] hourAndMin = Arrays.stream(info[0].split(":")).mapToInt(Integer::parseInt).toArray();
            int time = hourAndMin[0]*60 + hourAndMin[1];
            String carNumber = info[1];
            String mode = info[2];

            if(mode.equals("IN")) {
                map.put(carNumber,time);
            }
            if(mode.equals("OUT")) {
                this.calcTime(map,result,carNumber,time);
                map.remove(carNumber);
            }
        }

        //들어온 정보만 있고 나간 정보가 없을 때 23:59에 나간 것으로 일괄 처리
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String carNumber = entry.getKey();
            int time = 23*60 + 59;
            this.calcTime(map,result,carNumber,time);
        }

        return result.values().stream().mapToInt(elem -> calcPay(fees[0],fees[1],fees[2],fees[3],elem)).toArray();
    }

    /*
    *  calcPay
    *  1. 실제 주차장 이용 시간 = 주차장 총 이용시간 또는 기본 이용 시간보다 적을 경우 초과 요금을 낼 필요 없으니 0
    *  2. 기본 요금 + 올림(실제 주차장 이용시간 / 단위 시간) * 단위 요금
    * */
    private int calcPay(int baseTime, int baseFee, int unitTime, int overFee, int useTime) {
        int realUseTime = Math.max(useTime - baseTime, 0);
        return baseFee +  (int) Math.ceil((double) realUseTime / unitTime) * overFee;
    }

    /*
    *  calcTime
    *  주차장 총 이용시간 계산
    * */
    private void calcTime(Map<String, Integer> map, Map<String, Integer> result, String carNumber, int outTime) {
        int inTime = map.get(carNumber);
        int useTime = outTime - inTime;

        int totalUseTime = result.getOrDefault(carNumber, 0) + useTime;
        result.put(carNumber, totalUseTime);
    }


}
