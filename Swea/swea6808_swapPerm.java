package a220405;

import java.util.Scanner;

public class swea6808_swapPerm {
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
			
			perm(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
		sc.close();
	}
	
	public static void perm(int idx) {
		if (idx >= 9) {
			int kyuScore = 0;
			int inScore = 0;
			
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > in[i])
					kyuScore += kyu[i] + in[i];
				else
					inScore += kyu[i] + in[i];
			}
			
			if (kyuScore > inScore)
				win++;
			else
				lose++;
		}
		
		for (int i = idx; i < 9; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = in[a];
		in[a] = in[b];
		in[b] = tmp;
	}
}
