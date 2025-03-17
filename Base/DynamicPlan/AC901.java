import java.util.*;

public class AC901 {
    final static int N = 310;
    static int h[][] = new int[N][N];
    static int f[][] = new int[N][N];
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt(); 
        c = sc.nextInt();
        int res = 0;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++)
                h[i][j] = sc.nextInt();
        }

        for (int i = 0; i < N; i++)
            Arrays.fill(f[i], -1);

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++)
                res = Math.max(res, dp(i, j));
        }

        System.out.println(res);

        sc.close();
    }
    
    public static int dp(int x, int y) {
        int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

        if (f[x][y] == -1) {
            f[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];

                if (a >= 1 && a <= r && b >= 1 && b <= c && h[a][b] < h[x][y]) 
                    f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
            }
        }

        return f[x][y];
    }
}