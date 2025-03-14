import java.util.*;

public class AC282 {
    final static int N = 310;
    final static int MAX_INF = 0x3f3f3f3f;
    static int s[] = new int[N];
    static int f[][] = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            s[i] = sc.nextInt();

        for (int i = 1; i <= n; i++)
            s[i] += s[i - 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i, r = i + len - 1;
                f[l][r] = MAX_INF;
                
                for (int k = l; k < r; k++)
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
            }
        }
        
        System.out.println(f[1][n]);

        sc.close();
    }
}
