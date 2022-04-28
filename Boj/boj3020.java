package a220428;

import java.util.Scanner;

public class boj3020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		// 석순
		int[] bottom = new int[h + 1];
		// 종유석
		int[] top = new int[h + 1];
		for (int i = 0; i < n / 2; i++) {
			bottom[sc.nextInt()]++;
			top[sc.nextInt()]++;
		}
		
		for (int i = 1; i <= h; i++) {
			bottom[i] += bottom[i - 1];
			top[i] += top[i - 1];
		}
		
		int cnt = 0;
		int min = n;
		for (int i = 1; i <= h; i++) {
			int sum = 0;
			
			sum += bottom[h] - bottom[i - 1];
			sum += top[h] - top[h - i];
			
			if (min > sum) {
				min = sum;
				cnt = 1;
			}
			else if (min == sum)
				cnt++;
		}
		System.out.println(min + " " + cnt);
		sc.close();
	}
}
