package a220503;

import java.util.Scanner;

public class boj2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 점화식이 피보나치 수열이고 n의 범위가 최대 90이기 때문에 int로 받으면 터짐
		// 따라서 long으로 받아줘야만 제대로 된 결과가 나온다
		long[] arr = new long[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		System.out.println(arr[n]);
		sc.close();
	}
}
