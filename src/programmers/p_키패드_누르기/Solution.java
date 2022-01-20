package programmers.p_키패드_누르기;

public class Solution {

    private int[][] keyPad = {
            {3,1}, // 0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2} //9
    };

    private int[] leftHandPos = {3,0};
    private int[] rightHandPos = {3,2};


    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        for(int number: numbers) {
            String pushNumber = pushKeyPad(number, hand);
            if(pushNumber.equals("L")) leftHandPos = keyPad[number];
            if(pushNumber.equals("R")) rightHandPos = keyPad[number];
            answer.append(pushNumber);
        }
        return answer.toString();
    }

    private String pushKeyPad(int target, String hand) {
        //왼손 입력
        if(target == 1 || target == 4 || target == 7) {
            return "L";
        }

        //오른손 입력
        if(target == 3 || target == 6 || target == 9) {
            return "R";
        }

        String pushNumber;
        int leftDistance = getDistance(target, leftHandPos);
        int rightDistance = getDistance(target, rightHandPos);

        if(leftDistance < rightDistance) {
            pushNumber = "L";
        } else if(leftDistance > rightDistance) {
            pushNumber = "R";
        } else {
            if(hand.equals("left")) {
                pushNumber = "L";
            } else {
                pushNumber = "R";
            }
        }
        return pushNumber;
    }

    private int getDistance(int target, int[] handPos) {
        return Math.abs(handPos[0] - keyPad[target][0]) + Math.abs(handPos[1] - keyPad[target][1]);
    }
}
