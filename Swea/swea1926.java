import java.util.Scanner;

public class swea1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			int cnt = 0;
			for (int j = 0; j < s.length(); j++)
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
					cnt++;
			if (cnt > 0) {
				while (cnt > 0) {
					System.out.print("-");
					cnt--;
				}
			} 
			else
				System.out.print(i);
			System.out.print(" ");
		}
	}
}
