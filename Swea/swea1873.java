import java.util.Scanner;

public class swea1873 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++)
				map[i] = sc.next().toCharArray();
			int n = sc.nextInt();
			String command = sc.next();
			// 전차 현재 좌표 구하기
			int curH = 0;
			int curW = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
						curH = i;
						curW = j;
						break;
					}
				}
			}
			// 커맨드별 움직임 및 맵 재구성
			for (int k = 0; k < n; k++) {
				if (command.charAt(k) == 'U') {
					map[curH][curW] = '^';
					if (curH != 0 && map[curH - 1][curW] == '.') {
						map[curH][curW] = '.';
						curH--;
						map[curH][curW] = '^';
					}
				} else if (command.charAt(k) == 'D') {
					map[curH][curW] = 'v';
					if (curH != h - 1 && map[curH + 1][curW] == '.') {
						map[curH][curW] = '.';
						curH++;
						map[curH][curW] = 'v';
					}
				} else if (command.charAt(k) == 'L') {
					map[curH][curW] = '<';
					if (curW != 0 && map[curH][curW - 1] == '.') {
						map[curH][curW] = '.';
						curW--;
						map[curH][curW] = '<';
					}
				} else if (command.charAt(k) == 'R') {
					map[curH][curW] = '>';
					if (curW != w - 1 && map[curH][curW + 1] == '.') {
						map[curH][curW] = '.';
						curW++;
						map[curH][curW] = '>';
					}
				} 
				// S일때
				else if (command.charAt(k) == 'S') {
					if (map[curH][curW] == '^') {
						for (int i = curH; i >= 0; i--) {
							if (map[i][curW] == '*') {
								map[i][curW] = '.';
								break;
							}
							if (map[i][curW] == '#') {
								break;
							}
						}
					} else if (map[curH][curW] == 'v') {
						for (int i = curH; i < h; i++) {
							if (map[i][curW] == '*') {
								map[i][curW] = '.';
								break;
							}
							if (map[i][curW] == '#') {
								break;
							}
						}
					} else if (map[curH][curW] == '<') {
						for (int i = curW; i >= 0; i--) {
							if (map[curH][i] == '*') {
								map[curH][i] = '.';
								break;
							}
							if (map[curH][i] == '#') {
								break;
							}
						}
					} else if (map[curH][curW] == '>') {
						for (int i = curW; i < w; i++) {
							if (map[curH][i] == '*') {
								map[curH][i] = '.';
								break;
							}
							if (map[curH][i] == '#') {
								break;
							}
						}
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
		sc.close();
	}
}
