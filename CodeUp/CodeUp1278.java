import java.util.Scanner;

public class CodeUp1278 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		
		while (n > 9) {
			n /= 10;
			i++;
		}
		System.out.println(i);
	}
}
