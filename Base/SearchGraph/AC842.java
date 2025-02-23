package Base.SearchGraph;

import java.util.Scanner;

public class AC842 {
    final static int N = 10;
    static int n;
    static int path[] = new int[N];         // 保存DFS的路径
    static boolean st[] = new boolean[N];   // 标识数字是否被用过

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        dfs(0);

        scanner.close();
    }
    
    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");
            System.out.println("");
        }
        
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                // 深度搜索
                dfs(u + 1);
                // 恢复现场
                st[i] = false;
            }
        }
    }
}
