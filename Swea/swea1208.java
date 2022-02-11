import java.util.Scanner;

public class swea1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			// 박스들의 높이(1 ~ 100)를 담을 배열 선언
			int[] box = new int[101];
			for (int i = 0; i < 100; i++)
				box[sc.nextInt()]++;
			// 높이 최대값, 최소값 구하기
			int max = 0;
			int min = 0;
			for (int i = 1; i < 101; i++) {
				if (box[i] > 0) {
					min = i;
					break;
				}
			}
			for (int i = 100; i >= 1; i--) {
				if (box[i] > 0) {
					max = i;
					break;
				}
			}
			// dump 횟수동안 덤프 실행
			while (dump > 0 && (max - min) > 1) {
				box[max]--;
				box[max - 1]++;
				box[min]--;
				box[min + 1]++;
				dump--;
				if (box[max] == 0)
					max--;
				if (box[min] == 0)
					min++;
			}
			System.out.println("#" + tc + " " + (max - min));
		}
	}
}
