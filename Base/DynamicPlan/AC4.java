import java.util.Scanner;

public class AC4 {
    final static int N = 110;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int s[] = new int[N];
    static int f[][] = new int[N][N];
    // 朴素多重背包
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        
        for(int i = 1; i <= n; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
            
            for(int j = 1; j <= m; j++){
                for(int k = 0; k * v[i] <= j && k <= s[i]; k++)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
            }
        }
        
        System.out.println(f[n][m]);

        sc.close();
    }
}