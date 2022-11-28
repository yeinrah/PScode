import java.util.*;

// 투 포인터까지는 생각했으나 합을 계속 갱신하기 위해서 for문을 계속 돌리니 시간제한 걸림
// 질문하기 글들을 참고해서 sum1만 갱신하면 for문 돌릴 시간을 아낄 수 있다는 점을 알아냄
// 다만, 11, 28번은 sum1 갱신만으로는 풀리지 않는 반례인 것으로 추정, 무한루프
// 주어진 큐의 길이 제한이 30만이기 때문에 최대 60만번만 돌게 제한하여 해결
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
		long sum = 0;
		long sum1 = 0;
		long sum2 = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i : queue1) {
			sum += i;
			sum1 += i;
			arr.add(i);
		}

		for (int i : queue2) {
			sum += i;
			sum2 += i;
			arr.add(i);
		}
        
        for (int i : arr)
            if (i > sum / 2)
                return -1;
        
        if (sum1 == sum2)
            return 0;
        else if (sum % 2 == 1)
            return -1;
        else if (sum2 > sum1)
            return solution(queue2, queue1);
        
		if (sum % 2 == 0) {
			int index1 = 0;
			int index2 = queue1.length;
            int cnt = 0;
			while (cnt <= 600000 && sum1 != sum / 2) {
                while (cnt <= 600000 && sum1 > sum / 2) {
                    sum1 -= arr.get(index1++ % arr.size());
                    answer++;
                    cnt++;
                }
                while (cnt <= 600000 && sum1 < sum / 2) {
                    sum1 += arr.get(index2++ % arr.size());
                    answer++;
                    cnt++;
                }
                if (sum1 == sum / 2)
                    return answer;
			}
		}
        return -1;
	}
}