import java.util.Scanner;

public class CodeUp1512 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int arr[][] = new int[100][100];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (x > i) {
					if (y > j)
						arr[i][j] = (x - i - 1) + (y - j - 1) + 1;
					else
						arr[i][j] = (x - i - 1) + (j - y + 1) + 1;
				}
				else
				{
					if (y > j)
						arr[i][j] = (i - x + 1) + (y - j - 1) + 1;
					else
						arr[i][j] = (i - x + 1) + (j - y + 1) + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
