import java.util.Scanner;

public class AC849 {
    final static int N = 510;
    static int MAX_INF = 0x3f3f3f3f;
    static int graph[][] = new int[N][N];       // 稠密图使用邻接表
    static int distance[] = new int[N];         // 源节点到i节点的距离
    static boolean st[] = new boolean[N];       // S集合

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        init();

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
            // 去除重边，保留最小值
            graph[x][y] = Math.min(graph[x][y], z);
        }

        System.out.println(dijkstra(n));

        scanner.close();
    }
    // 朴素Dijkstra
    public static int dijkstra(int n) {
        // 更新源节点的距离
        distance[1] = 0;
        // 更新N次图
        for (int i = 0; i < n; i++) {
            int t = 0;
            // 选出S集合中距离最小的点
            for (int j = 1; j <= n; j++) {
                if (!st[j] && distance[j] < distance[t])
                    t = j;
            }
            // 将其加入S集合
            st[t] = true;
            // 更新剩余点到源节点的距离
            for (int j = 1; j <= n; j++) {
                if (!st[j] && distance[j] > distance[t] + graph[t][j])
                    distance[j] = distance[t] + graph[t][j];
            }
        }
        
        if(distance[n] == MAX_INF)
            distance[n] = -1;
        
        return distance[n];
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            distance[i] = MAX_INF;
            for(int j = 0; j < N; j++)
                graph[i][j] = MAX_INF;
        }
    }
}
