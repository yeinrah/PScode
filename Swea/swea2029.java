import java.util.Scanner;
 
public class swea2029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int q = a / b;
            int p = a % b;
            System.out.println("#" + tc + " " + q + " " + p);
        }
    }
}