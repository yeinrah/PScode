import java.util.Arrays;
import java.util.Scanner;

public class swea1983 {
	public static void main(String[] args) {
		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			// 각 학점별 가능 인원
			int cnt = n / 10;
			double[] students = new double[n];
			double[] scores = new double[n];
			String res = "";
			for (int j = 0; j < n; j++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int hw = sc.nextInt();
				students[j] = (mid * 0.35) + (fin * 0.45) + (hw * 0.2);
				scores[j] = (mid * 0.35) + (fin * 0.45) + (hw * 0.2);
			}
			Arrays.sort(scores);
			//k번째 학생의 점수와 정렬된 점수 비교하여 학점 산출
			for (int l = 0; l < n; l++) {
				if (students[k - 1] == scores[l]) {
					res = grade[l / cnt];
				}
			}
			System.out.println("#" + i + " " + res);
		}
	}
}
