import java.util.*;

public class AC91 {
    final static int N = 21;
    final static int M = 1 << N;
    final static int MAX_INF = 0x3f3f3f3f;
    static int f[][] = new int[M][N];
    static int weight[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        init();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                weight[i][j] = sc.nextInt();
        }

        f[1][0] = 0;

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        if ((i >> k & 1) == 1) 
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + weight[k][j]);
                    }
                }
            }
        }

        System.out.println(f[(1 << n) - 1][n - 1]);

        sc.close();
    }

    public static void init() {
        for (int i = 0; i < M; i++)
            Arrays.fill(f[i], MAX_INF);
    }
}
