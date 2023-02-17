import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
                public int compare(String n1, String n2) {
                    return (n2 + n1).compareTo(n1 + n2);
                }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}