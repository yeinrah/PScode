import java.util.Scanner;

public class CodeUp1492 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		
		for (int i = 0; i < n; i++)
			arr1[i] = sc.nextInt();
		
		for (int i = 1; i < n; i++)
			arr1[i] += arr1[i - 1];
		
		for (int i = 0; i < n; i++)
			System.out.print(arr1[i] + " ");
	}
}
