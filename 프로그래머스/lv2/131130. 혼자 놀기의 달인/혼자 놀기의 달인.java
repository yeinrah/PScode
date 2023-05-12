import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < cards.length; i++)
            find(allList, cards, visited, i);
        Collections.sort(allList, (a, b) -> b.size() - a.size());
        return allList.get(0).size() * allList.get(1).size();
    }
    
    public void find(List<List<Integer>> allList, int[] cards, boolean[] visited, int i) {
        List<Integer> list = new ArrayList<>();
        while (!visited[i]) {
            list.add(cards[i]);
            visited[i] = true;
            i = cards[i] - 1;
        }
        allList.add(list);
    }
}