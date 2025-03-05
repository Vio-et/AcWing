import java.util.Arrays;
import java.util.Scanner;

public class AC861 {
    final static int N = 1010;
    final static int M = 100010;
    static boolean graph[][] = new boolean [N][N];      // 稠密图用邻接矩阵
    static int match[] = new int[N];                    // 存储匹配关系
    static boolean st[] = new boolean[N];               // 存储节点状态
    static int n1;
    static int n2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        int m = scanner.nextInt(), cnt = 0;

        while (m-- > 0) {
            int u = scanner.nextInt(), v = scanner.nextInt();

            graph[u][v] = true;
        }

        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i))
                cnt++;
        }

        System.out.println(cnt);

        scanner.close();
    }
    // 匈牙利算法求二分图的最大匹配
    public static boolean find(int u) {
        boolean isFind = false;

        for (int j = 1; j <= n2 && !isFind; j++) {
            if (graph[u][j] && !st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = u;
                    isFind = true;
                }
            }
        }
        
        return isFind;
    }
}
