import java.util.Scanner;

public class CodeUp1274 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean prime = true;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		if (prime)
			System.out.println("prime");
		else
			System.out.println("not prime");
	}
}
