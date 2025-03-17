import java.util.*;

public class AC285 {
    final static int N = 6010;
    static int f[][] = new int[N][2];
    static int w[] = new int[N];
    static int head[] = new int[N];
    static int e[] = new int[N];
    static int ne[] = new int[N];
    static boolean has_fa[] = new boolean[N];
    static int idx; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), root = 1;

        Arrays.fill(head, -1);

        for (int i = 1; i <= n; i++)
            w[i] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int l = sc.nextInt(), k = sc.nextInt();

            add(k, l);
            has_fa[l] = true;
        }

        while (has_fa[root])
            root++;

        dfs(root);

        System.out.println(Math.max(f[root][0], f[root][1]));

        sc.close();
    }

    public static void dfs(int u) {
        f[u][1] = w[u];

        for (int i = head[u]; i != -1; i = ne[i]) {
            int j = e[i];

            dfs(j);

            f[u][0] += Math.max(f[j][1], f[j][0]);
            f[u][1] += f[j][0];
        }
    }

    public static void add(int a, int b){
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}
