import java.util.Scanner;

public class AC848 {
    final static int N = 100010, M = 2 * N;
    static int head[] = new int[N];     // 邻接表存储图
    static int in[] = new int[N];       // 保存入度
    static int q[] = new int[N];        // 队列进行拓扑排序
    static int e[] = new int[M];        // 链表实现邻接表
    static int ne[] = new int[M];
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        init();

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();

            add(a, b);
            in[b]++;
        }

        if (topSort(n)) {
            for(int i = 0; i < n; i++)
                System.out.print(q[i] + " ");
        }
        else
            System.out.println(-1);
        
        scanner.close();
    }

    public static boolean topSort(int n) {
        int hh = 0, tt = 0;
        // 先将入度为0的点插入队列
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) 
                q[tt++] = i;
        }
        
        while (hh < tt) {
            // 获取队头
            int t = q[hh++];

            for (int i = head[t]; i != -1; i = ne[i]) {
                int j = e[i];
                // 弹出队头后更新入度
                in[j]--;    
                // 将入度为0的点插入队列
                if (in[j] == 0)
                    q[tt++] = j;
            }
        }
        
        return tt == n;
    }
    
    public static void init() {
        for(int i = 0; i < N; i++)
            head[i] = -1;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}