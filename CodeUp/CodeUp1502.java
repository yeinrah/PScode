import java.util.Scanner;

public class CodeUp1502 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = (n * j + 1) + i;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}