import java.util.*;

public class AC9 {
    final static int N = 110;
    static int v[][] = new int[N][N];
    static int w[][] = new int[N][N];
    static int s[] = new int[N];
    static int f[] = new int[N];
    // 分组背包问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();

            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (v[i][k] <= j)
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                }
            }
        }
        
        System.out.println(f[m]);

        sc.close();
    }
}
