import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC852 {
    final static int N = 10010;
    final static int M = 10010;
    final static int MAX_INF = 0x3f3f3f3f;
    static int head[] = new int[N];         // 邻接表保存图
    static int distance[] = new int[N];     
    static int cnt[] = new int[N];          // 保存经过的边数
    static int weight[] = new int[N];
    static int e[] = new int[N];
    static int ne[] = new int[N];
    static boolean st[] = new boolean[N];
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.fill(head, -1);

        int n = scanner.nextInt(), m = scanner.nextInt();

        while (m-- > 0) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();

            add(x, y, z);
        }

        if (spfa(n))
            System.out.println("Yes");
        else
            System.out.println("No");

        scanner.close();
    }

    public static boolean spfa(int n) {
        boolean isCircle = false;
        Arrays.fill(distance, MAX_INF);
        Queue<Integer> queue = new LinkedList<>();
        // 将所有点入队才能找到所有负环
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }

        distance[1] = 0;

        while (!queue.isEmpty() && !isCircle) {
            int t = queue.poll();
            st[t] = false;

            for (int i = head[t]; i != -1 && !isCircle; i = ne[i]) {
                int j = e[i];

                if (distance[j] > distance[t] + weight[i]) {
                    // 更新距离的同时更新经过的边数
                    distance[j] = distance[t] + weight[i];
                    cnt[j] = cnt[t] + 1;
                    
                    if (cnt[j] >= n)
                        isCircle = true;

                    if (!st[j]) {
                        queue.add(j);
                        st[j] = true;
                    }
                }
            }
        }

        return isCircle;
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        weight[idx] = c;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}
