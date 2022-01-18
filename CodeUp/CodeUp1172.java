import java.util.Scanner;

public class CodeUp1172 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if (num1 < num2) {
			if (num2 < num3)
				System.out.printf("%s %s %s", num1, num2, num3);
			else if (num3 < num1)
				System.out.printf("%s %s %s", num3, num1, num2);
			else
				System.out.printf("%s %s %s", num1, num3, num2);
		}
		else {
			if (num1 < num3)
				System.out.printf("%s %s %s", num2, num1, num3);
			else if (num2 < num3)
				System.out.printf("%s %s %s", num2, num3, num1);
			else
				System.out.printf("%s %s %s", num3, num2, num1);
		}
	}
}
