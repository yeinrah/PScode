import java.util.Scanner;

public class swea2027 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 5 - i; j < 5; j++)
				System.out.print("+");
			System.out.print("#");
			for (int j = 5 - i; j > 1; j--)
				System.out.print("+");
			System.out.println();
		}
	}
}
