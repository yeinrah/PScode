package a220419;

import java.util.Scanner;

public class boj1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toUpperCase().toCharArray();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] cnt = new int[alphabet.length()];
		for (int i = 0; i < alphabet.length(); i++)
			for (int j = 0; j < s.length; j++)
				if (alphabet.charAt(i) == s[j])
					cnt[i]++;

		int max = 0;
		int max_idx = 0;
		int max_cnt = 0;
		for (int i = 0; i < cnt.length; i++)
			max = Math.max(max, cnt[i]);
		for (int i = 0; i < cnt.length; i++)
			if (cnt[i] == max) {
				max_idx = i;
				max_cnt++;
			}
		if (max_cnt > 1)
			System.out.println("?");
		else
			System.out.println(alphabet.charAt(max_idx));
		sc.close();
	}
}
