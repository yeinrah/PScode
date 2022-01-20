import java.util.Scanner;

public class CodeUp1507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[][] = new int[4][4];
		boolean arr[][] = new boolean[100][100];
		int count = 0;

		//값 2차원 배열로 받아오기
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		
		//받은 값 토대로 불리언 배열 값 채워주기
		for (int i = 0; i < 4; i++) {
			for (int j = num[i][0]; j < num[i][2]; j++) {
				for (int k = num[i][1]; k < num[i][3]; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		//불리언 배열의 true값 카운팅
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}

}
