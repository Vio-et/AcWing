import java.util.Scanner;

public class AC837 {
    final static int N = 100010;
    static int parent[] = new int[N];   // 用树结构存储并查集，根节点的序号就是集合序号，每个节点保存父节点的编号
    static int size[] = new int[N];     // 用数组保存集合大小，只有根节点的集合大小有效

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        while (m-- > 0) {
            String str = scanner.next();
            int a = scanner.nextInt();

            if (str.equals("C")) {
                int b = scanner.nextInt();
                // 两节点不再同一个连通块中时才需要合并集合
                if (find(a) != find(b)) {
                    // 先更新集合节点数量，再合并集合（节点数量计算时需要未更新的祖节点获取集合大小）
                    size[find(b)] += size[find(a)];
                    parent[find(a)] = find(b);
                }
            } else if (str.equals("Q1")) {
                int b = scanner.nextInt();

                if (find(a) == find(b))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            } else if (str.equals("Q2"))
                System.out.println(size[find(a)]);
        }

        scanner.close();
    }
    // 查找根节点，使用路径压缩
    public static int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
}
