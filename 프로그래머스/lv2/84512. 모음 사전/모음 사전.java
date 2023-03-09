import java.util.*;

class Solution {
    static String[] dict = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        comb("", 0);
        return list.indexOf(word);
    }
    
    public void comb(String str, int depth) {
        list.add(str);
        if(depth == 5)
            return;
        for (int i = 0; i < dict.length; i++)
            comb(str + dict[i], depth + 1);
    }
}