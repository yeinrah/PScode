package a220405;

import java.util.Scanner;

public class swea6808_sumParam {
	static int win, lose;
	static int[] kyu, in;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			win = 0;
			lose = 0;
			kyu = new int[9];
			in = new int[9];
			boolean[] cards = new boolean[19];
			for (int i = 0; i < 9; i++) {
				int n = sc.nextInt();
				kyu[i] = n;
				cards[n] = true;
			}
			int index = 0;
			for (int i = 1; i < 19; i++) {
				if (!cards[i])
					in[index++] = i;
			}

			perm(0, 0, 0);

			System.out.println("#" + tc + " " + win + " " + lose);
		}
		sc.close();
	}

	public static void perm(int idx, int kScore, int iScore) {
		if (idx >= 9) {
			if (kScore > iScore)
				win++;
			else
				lose++;
		}

		for (int i = idx; i < 9; i++) {
			swap(i, idx);
			int score = kyu[idx] + in[idx];
			if (kyu[idx] > in[idx])
				perm(idx + 1, kScore + score, iScore);
			else
				perm(idx + 1, kScore, iScore + score);
			swap(i, idx);
		}
	}

	public static void swap(int a, int b) {
		int tmp = in[a];
		in[a] = in[b];
		in[b] = tmp;
	}
}
