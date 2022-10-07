import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        
        for (int i = 2; i <= n; i++) {
            arr.add((arr.get(i - 2) + arr.get(i - 1)) % 1234567);
        }
        return arr.get(n);
    }
}