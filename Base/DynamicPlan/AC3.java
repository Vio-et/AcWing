import java.util.Scanner;

public class AC3 {
    final static int N = 1010;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];    // 优化为一维

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();    
            // 用f(i, j -v)优化K
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);

        sc.close();
    }
}
