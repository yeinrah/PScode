import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);
                
                if (file1[0].compareTo(file2[0]) == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);
                    return num1 - num2;
                }
                else
                    return file1[0].compareTo(file2[0]);
            }
            
            public String[] detach(String s) {
                int idx1 = 0;
                int idx2 = 0;
                for (int i = 0; i < s.length(); i++)
                    if (Character.isDigit(s.charAt(i))) {
                        idx1 = i;
                        break;
                    }
                for (int i = idx1; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        idx2 = i;
                        break;
                    }
                    else if (i - idx1 >= 5) {
                        idx2 = i;
                        break;
                    }
                    else if (i == s.length() - 1)
                        idx2 = i + 1;
                }
                String head = s.substring(0, idx1).toLowerCase();
                String num = s.substring(idx1, idx2);
                
                String[] file = {head, num};
                return file;
            }
        });
        return files;
    }
}