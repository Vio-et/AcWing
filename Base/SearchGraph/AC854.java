import java.util.Scanner;

public class AC854 {
    final static int N = 210;
    final static int MAX_INF = 0x3f3f3f3f;
    static int distance[][] = new int[N][N];    // 邻接表存储图

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        init();

        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();

        while (m-- > 0) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();

            distance[x][y] = Math.min(distance[x][y], z);
        }

        floyd(n);

        while (k-- > 0) {
            int x = scanner.nextInt(), y = scanner.nextInt();

            if (distance[x][y] > MAX_INF / 2)
                System.out.println("impossible");
            else
                System.out.println(distance[x][y]);
        }

        scanner.close();
    }
    // Floyd算法 O(n^3)
    public static void floyd(int n) {
        // 三重循环 K在最外层
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
            }
        }
    }
    
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = MAX_INF;
            }
        }
    }
}
