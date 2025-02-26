import java.util.*;

public class AC847 {
    final static int N = 100010, M = 2 * N;
    static int head[] = new int[N];     // 邻接表保存图
    static int e[] = new int[M];        // 链表实现邻接表
    static int ne[] = new int[M];
    static int d[] = new int[N];
    static int idx;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int m = scanner.nextInt();

        init();

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();

            add(a, b);
        }

        System.out.println(dfs());

        scanner.close();
    }
    // 使用深度优先搜索寻找最短路径
    public static int dfs() {
        int res = -1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        d[1] = 0;

        while (!queue.isEmpty() & res == -1) {
            int t = queue.peek();
            queue.remove();

            for (int i = head[t]; i != -1; i = ne[i]) {
                int j = e[i];

                if (d[j] == -1) {
                    queue.add(j);
                    d[j] = d[t] + 1;
                }
            }

            if (t == n)
                res = d[n];
        }
        
        return res;
    }
    
    public static void init() {
        for (int i = 0; i < N; i++) {
            head[i] = -1;
            d[i] = -1;
        }
    }
    
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}
