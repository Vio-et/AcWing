import java.util.Arrays;
import java.util.Scanner;

public class AC858 {
    final static int N = 510;
    final static int MAX_INF = 0x3f3f3f3f;
    static int graph[][] = new int[N][N];       // 使用邻接矩阵存储稠密图
    static int distance[] = new int[N];         // 存储节点到集合的距离
    static boolean st[] = new boolean[N];       // 存储节点是否在集合中的状态

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), res = -1;

        init();

        while (m-- > 0) {
            int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();

            graph[u][v] = graph[v][u] = Math.min(graph[u][v], w);
        }

        res = prim(n);

        if (res == MAX_INF)
            System.out.println("impossible");
        else
            System.out.println(res);

        scanner.close();
    }
    // Prim算法 用于求稠密图的最小生成树
    public static int prim(int n) {
        // 初始化距离
        boolean isFinish = false;
        int res = 0;
        Arrays.fill(distance, MAX_INF);

        distance[1] = 0;
        // 更新N次
        for (int i = 1; i <= n && !isFinish; i++) {
            int t = -1;
            // 取出集合外距离最小的节点
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || distance[j] < distance[t]))
                    t = j;
            }
            // 若最小距离为MAX则图不连通
            if (distance[t] == MAX_INF) {
                res = MAX_INF;
                isFinish = true;
            }
            else if (t != -1) {
                // 将节点添加的集合中
                st[t] = true;   
                // 更新最小生成树
                res += distance[t];
                // 更新距离
                for (int j = 1; j <= n; j++) {
                    if (!st[j])
                        distance[j] = Math.min(distance[j], graph[t][j]);
                }
            }
            else    // 若所有点都在集合中则结束
                isFinish = true;
        }

        return res;
    }
    
    public static void init() {
        for(int i = 0; i < N; i++)
            Arrays.fill(graph[i], MAX_INF);
    }
}
