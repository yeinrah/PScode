import java.util.Scanner;

public class boj2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 00)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
