import java.util.Scanner;

public class swea2047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		char[] arr = new char[c.length()];
		for (int i = 0; i < c.length(); i++) {
			arr[i] = c.charAt(i);
			if (97 <= arr[i] && arr[i] <= 122)
				arr[i] -= 32;
			System.out.print(arr[i]);
		}
	}
}
