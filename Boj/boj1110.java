package a220414;

import java.util.Scanner;

public class boj1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 1;
		
		int next1 = n % 10;
		int next2 = (n / 10 + next1) % 10;
		int tmp = next1 * 10 + next2;
		
		while (tmp != n) {
			next1 = tmp % 10;
			next2 = (tmp / 10 + next1) % 10;
			tmp = next1 * 10 + next2;
			res++;
		}
		
		System.out.println(res);
		sc.close();
	}
}
