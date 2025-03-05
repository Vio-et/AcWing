import java.util.Arrays;
import java.util.Scanner;

public class AC860 {
    final static int N = 200010;
    static int head[] = new int[N];     // 稀疏图使用邻接数组存
    static int e[] = new int[N];
    static int ne[] = new int[N];
    static int color[] = new int[N];    // 染色法解决判断二分图的问题
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isPerfect = true;
        int n = scanner.nextInt(), m = scanner.nextInt();

        Arrays.fill(head, -1);

        while (m-- > 0) {
            int u = scanner.nextInt(), v = scanner.nextInt();

            add(u, v);
            add(v, u);
        }

        for (int i = 1; i <= n && isPerfect; i++) {
            if (color[i] == 0) {
                if(!dfs(i, 1))
                    isPerfect = false;
            }
        }

        if (!isPerfect)
            System.out.println("No");
        else
            System.out.println("Yes");

        scanner.close();
    }   
    // 染色法
    public static boolean dfs(int u, int type) {
        boolean isPerfect = true;
        color[u] = type;

        for (int i = head[u]; i != -1; i = ne[i]) {
            int j = e[i];

            if (color[j] == 0) {
                if (!dfs(j, 3 - type))
                    isPerfect = false;
            } else if (color[j] == type)
                isPerfect = false;
        }
        
        return isPerfect;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}