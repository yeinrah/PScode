import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        boolean zero = true;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
            if (numbers[i] != 0)
                zero = false;
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
                public int compare(String n1, String n2) {
                    return (n2 + n1).compareTo(n1 + n2);
                }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        return zero ? "0" : sb.toString();
    }
}