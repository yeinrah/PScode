import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < picks.length; i++)
            sum += picks[i];
        if (minerals.length > sum * 5)
            minerals = Arrays.copyOfRange(minerals, 0, sum * 5);
        int cnt = (minerals.length / 5);
        cnt = minerals.length % 5 == 0 ? cnt : cnt + 1;
        
        int diaPick = Math.min(cnt, picks[0]);
        int ironPick = Math.min(cnt - diaPick, picks[1]);
        int stonePick = Math.min(cnt - diaPick - ironPick, picks[2]);
        
        for (int i = 0; i < cnt; i++) {
            int[] tmp = new int[3];
            for (int j = i * 5; j < i * 5 + 5; j++) {
                if (j >= minerals.length)
                    break;
                if (minerals[j].equals("stone")) {
                    tmp[0] += 1;
                    tmp[1] += 1;
                    tmp[2] += 1;
                }
                if (minerals[j].equals("iron")) {
                    tmp[0] += 5;
                    tmp[1] += 1;
                    tmp[2] += 1;
                }
                if (minerals[j].equals("diamond")) {
                    tmp[0] += 25;
                    tmp[1] += 5;
                    tmp[2] += 1;
                }
            }
            list.add(tmp);
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < stonePick; i++)
            answer += list.get(i)[0];
        for (int i = stonePick; i < stonePick + ironPick; i++)
            answer += list.get(i)[1];
        for (int i = stonePick + ironPick; i < list.size(); i++)
            answer += list.get(i)[2];
        
        return answer;
    }
}