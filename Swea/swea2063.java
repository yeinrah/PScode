import java.util.Scanner;

public class swea2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		// 테케 배열 생성
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		// 오름차순 정렬
		for (int j = 0; j < n - 1; j++) {
			int tmp = 0;
			for (int k = 0; k < n - 1; k++) {
				if (arr[k] > arr[k + 1]) {
					tmp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = tmp;
				}
			}
		}
		System.out.println(arr[n / 2]);
	}
}
