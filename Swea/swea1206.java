import java.util.Arrays;
import java.util.Scanner;

public class swea1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			int[] arr = new int[t];
			int res = 0;
			for (int j = 0; j < t; j++) {
				arr[j] = sc.nextInt();
			}
			//양옆 2칸은 무조건 0이므로 인덱스는 2부터 시작해서 t - 2까지
			for (int k = 2; k < t - 2; k++) {
				//양옆 두줄보다 길면 조망권 확보
				if (arr[k] > arr[k - 2] && arr[k] > arr[k - 1] && arr[k] > arr[k + 1] && arr[k] > arr[k + 2]) {
					//양옆 2개 및 자신으로 구성된 tmp 배열에서 sort해서 자신이 최대값이면 2번째 최대값과의 차이가 조망권 확보 세대 수
					int[] tmp = new int[5];
					for (int l = 0; l < 5; l++) {
						tmp[l] = arr[k - 2 + l];
					}
					Arrays.sort(tmp);
					res += tmp[4] - tmp[3];
				}
			}
			System.out.println("#" + i + " " + res);
		}
	}
}
