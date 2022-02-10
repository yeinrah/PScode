import java.util.Arrays;
import java.util.Scanner;

public class swea1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int[] arr = new int[10];
			// 테케 배열 생성
			for (int j = 0; j < 10; j++)
				arr[j] = sc.nextInt();
			// 오름차순 정렬
			for (int j = 0; j < 9; j++) {
				int tmp = 0;
				for (int k = 0; k < 9; k++) {
					if (arr[k] > arr[k + 1]) {
						tmp = arr[k];
						arr[k] = arr[k + 1];
						arr[k + 1] = tmp;
					}
				}
			}
			// 최소값, 최대값 제외 평균 구하기
			float sum = 0;
			for (int j = 1; j < 9; j++)
				sum += arr[j];
			sum /= 8;
			System.out.printf("#" + i + " " + "%.0f\n", sum);
		}
	}
}
