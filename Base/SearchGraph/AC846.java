import java.util.*;

public class AC846 {
    final static int N = 100010, M = N * 2; 
    static int head[] = new int[N];         // 保存链表头
    static int e[] = new int[M];            // 存储邻接表（链表实现）
    static int ne[] = new int[M];
    static boolean st[] = new boolean[N];
    static int idx;
    static int res;
    static int n;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        init();

        for(int i = 0; i < n - 1; i++){
            int a = scanner.nextInt(), b = scanner.nextInt();
            // 添加双向边
            add(a, b);
            add(b, a);
        }
        // 深度优先搜索
        dfs(1);

        System.out.println(res);
        scanner.close();
    }
    
    public static int dfs(int u){
        st[u] = true;
        
        int size = 0, sum = 0;
        for(int i = head[u]; i != -1; i = ne[i]){
            int j = e[i];

            if(!st[j]){
                int s = dfs(j);
                size = Math.max(size, s);
                sum += s;
            }
        }

        size = Math.max(size, n - sum - 1);
        res = Math.min(size, res);

        return sum + 1;
    }

    public static void init(){
        res = N;

        for(int i = 0; i < N; i++)
            head[i] = -1;
    }

    public static void add(int a, int b){
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx++;
    }
}
