package Base.SearchGraph;

import java.util.Scanner;

public class AC843 {
    final static int N = 20;
    static int n;
    static char chessBroad[][] = new char[N][N];
    static boolean col[] = new boolean[N], dg[] = new boolean[N], udg[] = new boolean[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                chessBroad[i][j] = '.';
        }

        dfs(0);

        scanner.close();
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(chessBroad[i][j]);

                System.out.println("");
            }
            System.out.println("");
        }
        
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i + u] && !udg[i - u + n]) {
                chessBroad[u][i] = 'Q';
                col[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                chessBroad[u][i] = '.';
                col[i] = dg[i + u] = udg[i - u + n] = false;
            }
        }
    }
}
