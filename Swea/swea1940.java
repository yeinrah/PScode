import java.util.Scanner;

public class swea1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int spd = 0;
			int dist = 0;
			for (int j = 0; j < n; j++) {
				int cmd = sc.nextInt();
				if (cmd != 0) {
					if (cmd == 1)
						spd += sc.nextInt();
					else if(cmd == 2)
						spd -= sc.nextInt();
					if (spd < 0)
						spd = 0;
				}
				dist += spd;
			}
			System.out.println("#" + i + " " + dist);
		}
	}
}
