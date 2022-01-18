import java.util.Scanner;

public class CodeUp1380 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int a = 1; a < 7; a++) {
			for (int b = n - a; 0 < b  && b < 7;) {
				System.out.printf("%d %d \n", a, b);
				break;
			}
		}
	}
}
