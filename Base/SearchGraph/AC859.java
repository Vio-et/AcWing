import java.util.Arrays;
import java.util.Scanner;

public class AC859 {
    final static int N = 100010;
    final static int M = 200010;
    final static int MAX_INF = 0x3f3f3f3f;
    static Edge[] edges = new Edge[M];      // 稀疏图 可以用自定义结构图（因为只用循环所有边）
    static int[] parent = new int[N];       // 利用并查集
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), res = -1;

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        res = kruskal(n, m);

        if (res == MAX_INF)
            System.out.println("impossible");
        else
            System.out.println(res);

        scanner.close();
    }
    // Kruskal算法 求稀疏图的最小生成树
    public static int kruskal(int n, int m) {
        int res = 0, cnt = 0;
        // 将所有边进行升序排序
        Arrays.sort(edges, 0, m);
        // 初始化并查集
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        // 遍历每一个边
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            // 如果两个连通块不连通，则将其连通起来
            if (find(edge.x) != find(edge.y)) {
                parent[find(edge.x)] = find(edge.y);
                res += edge.w;
                cnt++;
            }
        }

        if(cnt != n - 1)
            res = MAX_INF;

        return res;
    }
    
    public static int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
    
    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge t) {
            return Integer.compare(this.w, t.w);
        }
    }
}
