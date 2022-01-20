import java.util.Scanner;

public class CodeUp1411 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		//인덱스와 실제 수가 1씩 차이나므로 -1해서 넣고 +1해서 출력
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			arr[a - 1]++;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				System.out.println(i + 1);
		}
	}
}
