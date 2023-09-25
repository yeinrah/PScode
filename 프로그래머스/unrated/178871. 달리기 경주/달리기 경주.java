import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rank = new HashMap<>();
        Map<String, Integer> rank2 = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(i, players[i]);
            rank2.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int currRank = rank2.get(callings[i]);
            String prev = rank.get(currRank - 1);
            
            rank.put(currRank - 1, callings[i]);
            rank.put(currRank, prev);
            
            rank2.put(callings[i], currRank - 1);
            rank2.put(prev, currRank);
        }
        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++)
            answer[i] = rank.get(i);
        return answer;
    }
}