import java.util.Scanner;

public class Main {
	static int d, n;
	static int[] oven;
	static int dep, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		n = sc.nextInt();
		oven = new int[d];
		for (int i = 0; i < d; i++) {
			oven[i] = sc.nextInt();
			// 위층 오븐 지름이 더 작으면 어차피 그보다 큰 반죽을 넣을 수 없음
			// 따라서 작은 값으로 값을 재지정해줌(이진 탐색을 위한 정렬을 겸함)
			if (i > 0 && oven[i] > oven[i - 1])
				oven[i] = oven[i - 1];
		}
		dep = d - 1;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int dough = sc.nextInt();
			binarySearch(dough, 0, dep);
		}
		// 인덱스보다 1 큰 값이 정답
		System.out.println(min + 1);
		sc.close();
	}

	private static void binarySearch(int dough, int topIdx, int bottomIdx) {
		int res = -1;
		while (topIdx <= bottomIdx) {
			int mid = (topIdx + bottomIdx) / 2;
			if (oven[mid] >= dough) {
				res = mid;
				topIdx = mid + 1;
			} else
				bottomIdx = mid - 1;
		}
		min = Math.min(min, res);
		dep = res - 1;
	}
}
