import java.util.Scanner;

public class Main {
	static int n, res;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		perm(0);

		System.out.println(res);
		sc.close();
	}

	private static void perm(int idx) {

		if (idx == n) {
			int sum = 0;
			for (int i = 0; i < n - 1; i++)
				sum += Math.abs(arr[i] - arr[i + 1]);

			res = Math.max(sum, res);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
