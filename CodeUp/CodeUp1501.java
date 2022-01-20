import java.util.Scanner;

public class CodeUp1501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = (n * i + 1) + j;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}