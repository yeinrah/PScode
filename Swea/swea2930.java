import java.util.Scanner;

public class swea2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			// 연산 수 + 1 크기의 배열
			int[] arr = new int[n + 1];
			// 현재 위치
			int index = 0;
			// swap용 임시 변수
			int tmp = 0;
			StringBuilder sb = new StringBuilder();
			for (int nc = 0; nc < n; nc++) {
				int x = sc.nextInt();
				if (x == 1) {
					int input = sc.nextInt();
					index++;
					arr[index] = input;
					int i = index;
					// 부모 노드가 자식 노드보다 작으면 swap
					while (i / 2 > 0 && arr[i / 2] < input) {
						tmp = arr[i / 2];
						arr[i / 2] = input;
						arr[i] = tmp;
						i = i / 2;
					}
				} else if (x == 2) {
					// 루트 노드가 비어있는 경우 -1 출력
					if (arr[1] == 0) {
						sb.append(" -1");
					} else {
						// 루트 노드 출력, 루트 노드에 마지막 노드 값 삽입
						sb.append(" " + arr[1]);
						arr[1] = arr[index];
						arr[index] = 0;
						int i = 1;
						// 자식 노드 둘 중 하나라도 부모 노드보다 크면 더 큰 쪽을 부모 노드와 swap
						while (2 * i + 1 < index && Math.max(arr[2 * i], arr[2 * i + 1]) > arr[i]) {
							// 왼쪽 노드가 더 크면 왼쪽 노드와 swap
							if (arr[2 * i] > arr[2 * i + 1]) {
								tmp = arr[2 * i];
								arr[2 * i] = arr[i];
								arr[i] = tmp;
								i = i * 2;
							}
							// 오른쪽 노드가 더 크면 오른쪽 노드와 swap
							else {
								tmp = arr[2 * i + 1];
								arr[2 * i + 1] = arr[i];
								arr[i] = tmp;
								i = i * 2 + 1;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + sb);
		}
		sc.close();
	}
}
