import java.util.Scanner;

public class CodeUp1161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		if (num1 % 2 == 1) {
			if (num2 % 2 == 1)
				System.out.println("홀수+홀수=짝수");
			else
				System.out.println("홀수+짝수=홀수");
		} else {
			if (num2 % 2 == 1)
				System.out.println("짝수+홀수=홀수");
			else
				System.out.println("짝수+짝수=짝수");
		}
	}
}
