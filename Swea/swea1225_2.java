import java.util.Scanner;

public class swea1225_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++)
				arr[i] = sc.nextInt();
			int cnt = 1;
			int idx = 0;
			while (arr[idx % 8] > cnt) {
				arr[idx % 8] -= cnt;
				idx++;
				cnt++;
				if (cnt > 5)
					cnt = 1;
			}
			arr[idx % 8] = 0;
			System.out.print("#" + tc + " ");
			for (int i = 1; i <= 8; i++)
				System.out.print(arr[(i + idx) % 8] + " ");
			System.out.println();
		}
		sc.close();
	}
}
