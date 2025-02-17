import java.util.Scanner;

public class AC240 {
    final static int N = 500010;
    static int parent[] = new int[N];
    static int distance[] = new int[N];     // 每个节点记录到根节点的距离
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt(), cnt = 0;

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        while (k-- > 0) {
            int op = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
            int px = find(x), py = find(y);

            if (x > n || y > n)
                cnt++;
            else {
                if (op == 1) {
                    if(px == py && ((distance[x] - distance[y]) % 3 != 0))
                        cnt++;
                    else if (px != py) {
                        parent[px] = py;
                        distance[px] = distance[y] - distance[x];
                    }
                } else if (op == 2) {
                    if (x == y)
                        cnt++;
                    else if (px == py && (distance[x] - distance[y] - 1) % 3 != 0)
                        cnt++;
                    else if(px != py) {
                        parent[px] = py;
                        distance[px] = distance[y] - distance[x] + 1;
                    }
                }
            }
        }
        
        System.out.println(cnt);

        scanner.close();
    }
    // 求每个节点的根节点编号，使用路径压缩
    public static int find(int x) {
        if (parent[x] != x) {
            int tmp = find(parent[x]);  // 其父节点进行了路径压缩，更新了到根节点的距离
            // 更新节点到根节点的距离
            distance[x] += distance[parent[x]];
            parent[x] = tmp;
        }

        return parent[x];
    }
}
