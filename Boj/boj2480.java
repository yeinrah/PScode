package a220414;

import java.util.Scanner;

public class boj2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int res = 0;
		
		if (a == b && b == c)
			res = 10000 + (a * 1000);
		else if (a != b && b != c && a != c)
			res = Math.max(a, Math.max(b, c)) * 100;
		else {
			if (a == b)
				res = 1000 + a * 100;
			else if (b == c)
				res = 1000 + b * 100;
			else if (a == c)
				res = 1000 + a * 100;
		}
		
		System.out.println(res);
		sc.close();
	}
}
