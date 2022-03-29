package a220329;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class swea2930_2_pq {
	public static void main(String[] args) {
		// java pq는 기본적으로 최소 힙이므로 Collections.reverseOrder()로 최대힙으로 바꾸기
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			StringBuilder sb = new StringBuilder();
			// 매 테케마다 pq 비워주기
			pq.clear();
			int n = sc.nextInt();
			for (int nc = 0; nc < n; nc++) {
				int x = sc.nextInt();
				if (x == 1) {
					int input = sc.nextInt();
					pq.add(input);
				}
				else if (x == 2) {
					if (pq.isEmpty()) {
						sb.append(" -1");
					}
					else {
						sb.append(" " + pq.poll());
					}
				}
			}
			System.out.println("#" + tc + sb);
		}
		sc.close();
	}
}
