import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] cards, nums;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cards = new int[n];
		for (int i = 0; i < n; i++)
			cards[i] = sc.nextInt();
		m = sc.nextInt();
		nums = new int[m];
		for (int i = 0; i < m; i++)
			nums[i] = sc.nextInt();

		Arrays.sort(cards);

		sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int st = 0;
			int mid = n / 2;
			int end = n - 1;

			binarySearch(st, mid, end, nums[i]);
		}
		System.out.println(sb);
		sc.close();
	}

	private static void binarySearch(int st, int mid, int end, int num) {
		if (cards[mid] == num) {
			sb.append("1 ");
			return;
		}
		else if (st >= end) {
			sb.append("0 ");
			return;
		} else if (cards[mid] < num) {
			st = mid + 1;
			mid = (st + end) / 2;
			binarySearch(st, mid, end, num);
		} else if (cards[mid] > num) {
			end = mid - 1;
			mid = (st + end) / 2;
			binarySearch(st, mid, end, num);
		}
	}
}
