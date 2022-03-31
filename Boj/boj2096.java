package a220331;

import java.util.Scanner;

public class boj2096 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a_max = sc.nextInt();
		int b_max = sc.nextInt();
		int c_max = sc.nextInt();
		int a_min = a_max;
		int b_min = b_max;
		int c_min = c_max;
		
		for (int i = 1; i < n; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			int MaxA = a + Math.max(a_max, b_max);
			int MaxB = b + Math.max(a_max, Math.max(b_max, c_max));
			int MaxC = c + Math.max(b_max, c_max);
			a_max = MaxA;
			b_max = MaxB;
			c_max = MaxC;
			
			int MinA = a + Math.min(a_min, b_min);
			int MinB = b + Math.min(a_min, Math.min(b_min, c_min));
			int MinC = c + Math.min(b_min, c_min);
			a_min = MinA;
			b_min = MinB;
			c_min = MinC;
		}
		System.out.printf("%d %d", Math.max(a_max, Math.max(b_max, c_max)), Math.min(a_min, Math.min(b_min, c_min)));
		sc.close();
	}
}
