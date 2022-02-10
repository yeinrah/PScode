import java.util.Scanner;

public class swea2056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int year = n / 10000;
			int mon = (n % 10000) / 100;
			int day = n % 100;
			String res = "#" + i;
			if (mon < 1 || mon > 12 || day < 1 || day > 31)
				res += " -1";
			else if ((mon == 4 || mon == 6 || mon == 9 || mon == 11) && day > 30)
				res += " -1";
			else if (mon == 2 && day > 28)
				res += " -1";
			//유효한 경우
			else {
				if (year / 1000 == 0)
					res += " 0" + year;
				else
					res += " " + year;
				if (mon / 10 == 0)
					res += "/0" + mon;
				else
					res += "/" + mon;
				if (day / 10 == 0)
					res += "/0" + day;
				else
					res += "/" + day;
			}
				System.out.println(res);
		}
	}
}
