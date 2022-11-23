import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<String>();
        
        for (int i = 0; i < cities.length; i++) {
            // 캐시 사이즈가 0이면 무조건 cache miss이므로 5씩 증가
            if (cacheSize == 0)
                answer += 5;
            // 캐시에 존재하는지 확인하고 있으면 지우고 다시 넣어주면서 hit : 1
            // 없으면 가장 오래전에 들어간 걸 지우고 지금 도시를 넣으면서 miss : 5 씩 증가
            else if (q.contains(cities[i].toLowerCase())) {
                q.remove(cities[i].toLowerCase());
                q.offer(cities[i].toLowerCase());
                answer += 1;
            } else {
                if (q.size() == cacheSize)
                    q.poll();
                q.offer(cities[i].toLowerCase());
                answer += 5;
            }
        }
        return answer;
    }
}