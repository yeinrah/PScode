import java.util.Scanner;

public class Main {
	public static int[] button;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		button = new int[n + 1];
		for (int i = 1; i <= n; i++)
			button[i] = sc.nextInt();
		int m = sc.nextInt();
		int[] student = new int [m];
		int[] num = new int [m];
		for (int i = 0; i < m; i++) {
			student[i] = sc.nextInt();
			num[i] = sc.nextInt();
		}
		
		// 남자는 배수 토글, 여자는 회문 토글 
		for (int i = 0; i < m; i++) {
			if (student[i] == 1)
				toggle(num[i], 1, n);
			else {
				int offset = palindrome(num[i]);
				toggle(1, num[i] - offset, num[i] + offset);
			}
		}
		
		// 21번째 스위치부터는 줄 바꿔서 출력
		for (int i = 0; i <= n / 20; i++) {
			if (n / 20 != 0 && i != n / 20)
				for (int j = 1 + (20 * i); j <= 20 + (20 * i); j++)
					System.out.print(button[j] + " ");
			else
				for (int j = 1 + (20 * i); j <= n; j++)
					System.out.print(button[j] + " ");
			System.out.println();
		}
	}
	
	public static void toggle(int num, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (i % num == 0) {
				if (button[i] == 0)
					button[i] = 1;
				else
					button[i] = 0;
			}
		}
	}
	
	public static int palindrome(int num) {
		int offset = 0;
		while (num > offset && num + offset <= n && button[num - offset] == button[num + offset])
			offset++;
		return offset - 1;
	}
}
