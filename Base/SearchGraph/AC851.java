import java.util.*;

public class AC851 {
    final static int N = 100010;
    final static int MAX_INF = 0x3f3f3f3f;
    static int distance[] = new int[N];     // 保存到源点的距离
    static int weight[] = new int[N];       // 保存边的权重
    static int head[] = new int[N];         // 使用邻接表存储图 
    static int e[] = new int[N];            // 使用链表实现邻接表
    static int ne[] = new int[N];
    static boolean st[] = new boolean[N];   // 保存是否在队列中的状态
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.fill(head, -1);

        int n = scanner.nextInt(), m = scanner.nextInt();

        while (m-- > 0) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();

            add(x, y, z);
        }

        int res = spfa(n);

        if (res == MAX_INF)
            System.out.println("impossible");
        else
            System.out.println(res);

        scanner.close();
    }
    // SPFA算法
    public static int spfa(int n) {
        Arrays.fill(distance, MAX_INF);             // 初始化距离为无穷大
        Queue<Integer> queue = new LinkedList<>();  // 队列中保存所有最新更新过的节点编号，以此编号更新其他节点
        // 源点入队
        queue.add(1);
        distance[1] = 0;
        st[1] = true;

        while (!queue.isEmpty()) {
            int t = queue.poll();   // 取出队头
            st[t] = false;
            // 扩展队头
            for (int i = head[t]; i != -1; i = ne[i]) {
                int j = e[i];
                // 更新距离
                if (distance[j] > distance[t] + weight[i]) {
                    distance[j] = distance[t] + weight[i];
                    if (!st[j]) {
                        queue.add(j);
                        st[j] = true;
                    }
                }
            }
        }

        if(distance[n] > MAX_INF / 2)
            distance[n] = MAX_INF;

        return distance[n];
    }
    
    public static void add(int a, int b, int c) {
        e[idx] = b;
        weight[idx] = c;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}
