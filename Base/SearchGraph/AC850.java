import java.util.*;

public class AC850 {
    final static int N = 150010;
    final static int MAX_INF = 0x3f3f3f3f;
    static int head[] = new int[N];         // 邻接表存储稀疏图
    static int weight[] = new int[N];       // 存储边权重
    static int e[] = new int[N];
    static int ne[] = new int[N];
    static int distance[] = new int[N];     // 存储距离
    static boolean st[] = new boolean[N];   // S集合
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.fill(head, -1);

        int n = scanner.nextInt(), m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();

            add(x, y, z);
        }

        System.out.println(dijkstra(n));

        scanner.close();
    }
    // 堆优化Dijkstra
    public static int dijkstra(int n) {
        Queue<Pair> heap = new PriorityQueue<>();   // 小根堆存储到源点的距离
        // 添加源点入堆，加入S集合
        heap.add(new Pair(0, 1));
        Arrays.fill(distance, MAX_INF);
        distance[1] = 0;

        while (!heap.isEmpty()) {
            // 用O(1)的堆取最小值获得 S集合中的最小值
            int t = heap.peek().second, d = heap.peek().first;
            heap.remove();

            // 若未用过该节点（堆不能修改，只能插入，有冗余）
            if (!st[t]) {
                // 将其加入S集合
                st[t] = true;

                // 更新节点到源点的距离
                for (int i = head[t]; i != -1; i = ne[i]) {
                    int j = e[i];

                    if (!st[j] && distance[j] > d + weight[i]) {
                        distance[j] = d + weight[i];
                        heap.add(new Pair(distance[j], j));
                    }
                }
            }
        }
        
        if(distance[n] == MAX_INF)
            distance[n] = -1;

        return distance[n];
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        weight[idx] = c;
        ne[idx] = head[a];
        head[a] = idx++;
    }
    
    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return this.first;
        }

        public int getSecond() {
            return this.second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(first, o.first);
        }
    }
}
