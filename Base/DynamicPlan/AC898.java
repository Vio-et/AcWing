import java.util.Arrays;
import java.util.Scanner;

public class AC898 {
    final static int N = 510;
    final static int MAX_INF = 0x3f3f3f3f;
    static int w[][] = new int[N][N];
    static int f[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), res = -MAX_INF;

        init();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        f[1][1] = w[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1] + w[i][j], f[i - 1][j] + w[i][j]);
            }
        }

        for (int i = 1; i <= n; i++)
            res = Math.max(res, f[n][i]);

        System.out.println(res);

        sc.close();
    }
    
    public static void init() {
        for (int i = 0; i < N; i++) 
            Arrays.fill(f[i], -MAX_INF);
    }
}