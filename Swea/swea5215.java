import java.util.Scanner;

public class swea5215 {
	static int n, l, res;
	static int[] score, calorie;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			l = sc.nextInt();
			score = new int[n];
			calorie = new int[n];
			for (int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			res = 0;
			recur(0, 0, 0);
			System.out.println("#" + tc + " " + res);
		}
	}

	public static void recur(int idx, int calSum, int scoreSum) {
		if (idx >= n) {
			if (calSum <= l)
				res = Math.max(res, scoreSum);
			return;
		}
		recur(idx + 1, calSum + calorie[idx], scoreSum + score[idx]);
		recur(idx + 1, calSum, scoreSum);
	}
}
