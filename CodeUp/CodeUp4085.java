
import java.util.Scanner;

public class CodeUp4085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        }
        
        int ans = 0;
        for(int i = 0; i <= n - y; i++) {
            for(int j = 0; j <= m - x; j++) {
                int sum = 0;
                for(int a = 0; a < y; a++) {
                    for(int b = 0; b < x; b++)
                        sum+= map[i + a][j + b];
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}
