package a220404;

import java.util.Scanner;

public class swea6808 {
	static int win, lose, N;
	static int[] kyuYoung, inYoung, visited, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			win = 0;
			lose = 0;
			// 인덱스가 18까지 있는 배열, T가 규영이 카드, F가 인영이 카드
			N = 19;
			boolean[] cards = new boolean[N];
			kyuYoung = new int[9];
			inYoung = new int[9];
			// 방문처리용 배열
			visited = new int[9];
			// 인영이가 내는 카드의 조합을 담을 배열
			sel = new int[9];
			
			for (int i = 0 ; i < 9; i++) {
				int num = sc.nextInt();
				cards[num] = true;
				kyuYoung[i] = num;
			}
			int index = 0;
			for (int i = 1; i < N; i++)
				if (!cards[i])
					inYoung[index++] = i;
			
			perm(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
		sc.close();
	}
	
	public static void perm(int idx) {
		if (idx >= 9) {
			int kyuScore = 0;
			int inScore = 0;
			for (int i = 0; i < 9; i++) {
				if (kyuYoung[i] > sel[i])
					kyuScore += kyuYoung[i]	+ sel[i];
				else
					inScore += sel[i] + kyuYoung[i];
			}
			
			if (kyuScore > inScore)
				win++;
			else
				lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i] == 1)
				continue;
			
			visited[i] = 1;
			sel[idx] = inYoung[i];
			perm(idx + 1);
			visited[i] = 0;
		}
	}
}
