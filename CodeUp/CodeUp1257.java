import java.util.Scanner;

public class CodeUp1257 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b == a && a % 2 == 1)
			System.out.println(a);
		else if(b > a) {
			if(a % 2 == 1) {
				while (a <= b) {
					System.out.println(a);
					a += 2;
				}
			}
			else {
				while (a < b) {
					System.out.println(a + 1);
					a += 2;
				}
			}
		}
	}
}
