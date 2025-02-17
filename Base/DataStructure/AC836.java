import java.util.Scanner;

public class AC836 {
    final static int N = 100010;
    static int parent[] = new int[N];   // 利用树存储集合，以根节点的序号为集合编号，每个节点存储父节点

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            String str = scanner.next();
            int a = scanner.nextInt(), b = scanner.nextInt();

            if (str.equals("M"))
                parent[find(a)] = find(b);
            else if (str.equals("Q")) {
                if (find(a) == find(b))     // 判断两个节点是否在同一个集合中
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

        scanner.close();
    }
    // 查询节点的根节点（集合编号），使用路径压缩优化
    public static int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
}
