import java.util.*;

public class AC853 {
    final static int N = 510;
    final static int M = 10010;
    final static int MAX_INF = 0x3f3f3f3f;
    static int distance[] = new int[N];     // 存储距离
    static int backup[] = new int[N];       // 备份距离
    static Edge edge[] = new Edge[M];       // 利用自定义边存储边权重

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
            edge[i] = new Edge(x, y, z);
        }

        int res = bellman_ford(n, m, k);

        if (res == MAX_INF)
            System.out.println("impossible");
        else
            System.out.println(res);

        scanner.close();
    }
    // Bellman-Ford算法
    public static int bellman_ford(int n, int m, int k) {
        Arrays.fill(distance, MAX_INF);
        distance[1] = 0;
        // 经过不超过K条边，因此是K重循环
        for (int i = 1; i <= k; i++) {
            // 备份距离，因为距离在更新过程中会改变，而每个点只能根据上个循环的结果来更新（否则相当于多走几条边）
            backup = distance.clone();
            for (int j = 0; j < m; j++) {
                Edge e = edge[j];
                // 更新距离
                distance[e.y] = Math.min(distance[e.y], backup[e.x] + e.w);
            }
        }

        if(distance[n] > MAX_INF / 2)
            distance[n] = MAX_INF;
        
        return distance[n];
    }

    static class Edge {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}