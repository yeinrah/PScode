import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) { // 개수
            for (int j = 0; j < elements.length; j++) { // 시작 인덱스
                int sum = 0;
                for (int k = 0; k < i; k++) // 수열 인덱스
                    sum += elements[(j + k) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}