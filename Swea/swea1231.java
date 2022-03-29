package a220329;

import java.util.Scanner;

public class swea1231 {
	static int n;
	static char[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder("#" + tc + " ");
			n = sc.nextInt();
			arr = new char[n + 1];

			// 입력 받기
			for (int nc = 0; nc < n; nc++) {
				int index = sc.nextInt();
				arr[index] = sc.next().charAt(0);
				// 입력 중 자식 노드 인덱스(필요없는 부분) 날리기
				sc.nextLine();
			}

			inOrder(1);

			System.out.println(sb);
		}
		sc.close();
	}

	public static void inOrder(int i) {

		// 배열 인덱스를 넘어가면 리턴
		if (i > n)
			return;

		// 왼쪽 자식 처리 (L)
		inOrder(i * 2);
		// 본인 출력 (V)
		sb.append(arr[i]);
		// 오른쪽 자식 처리 (R)
		inOrder(i * 2 + 1);
	}
}
