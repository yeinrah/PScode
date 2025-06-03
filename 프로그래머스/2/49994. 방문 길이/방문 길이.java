import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int beforeX = 5;
        int beforeY = 5;
        
        char[] dir = dirs.toCharArray();
        for (char c : dir) {
            int currX = beforeX;
            int currY = beforeY;
            if (c == 'U')
                currY--;
            else if (c == 'D')
                currY++;
            else if (c == 'R')
                currX++;
            else if (c == 'L')
                currX--;
            
            if (currX < 0 || currX > 10)
                currX = beforeX;
            if (currY < 0 || currY > 10)
                currY = beforeY;
            
            if (currX != beforeX || currY != beforeY) {
                set.add(String.valueOf(beforeX) + String.valueOf(beforeY) + " " + String.valueOf(currX) + String.valueOf(currY));
                set.add(String.valueOf(currX) + String.valueOf(currY) + " " + String.valueOf(beforeX) + String.valueOf(beforeY));
            }
            
            beforeX = currX;
            beforeY = currY;
        }
        
        return set.size() / 2;
    }
}