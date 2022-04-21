package programmers.p_파일명_정렬;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private class FileInfo implements Comparable<FileInfo> {

        String head;
        int number;
        String originName;

        public FileInfo(String head, int number, String originName) {
            this.head = head;
            this.number = number;
            this.originName = originName;
        }

        @Override
        public int compareTo(FileInfo o) {
            int result = this.head.compareToIgnoreCase(o.head);
            if(result == 0) {
                result = Integer.compare(this.number, o.number);
            }
           return result;
        }
    }

    public String[] solution(String[] files) {
        List<FileInfo> fileInfoList = new ArrayList<>();

        for (String file : files) {
            char[] chars = file.toCharArray();
            boolean state = true;
            StringBuilder headSb = new StringBuilder();
            StringBuilder numberSb = new StringBuilder();

            for (char ch : chars) {
                if (Character.isDigit(ch)) {
                    if (state) {
                        state = false;
                    }
                    numberSb.append(ch);

                } else {
                    if (!state) {
                        break;
                    }
                    headSb.append(ch);
                }
            }

            String head = headSb.toString();
            int number = Integer.parseInt(numberSb.toString());
            fileInfoList.add(new FileInfo(head, number, file));
        }

        return fileInfoList.stream().sorted().map(fileInfo -> fileInfo.originName).toArray(String[]::new);
    }
}
