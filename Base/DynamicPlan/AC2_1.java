import java.util.*;

public class AC2_1 {
    final static int N = 1010;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];    // 优化为一维
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // 优化一维后，f需要上一层的值，所有要逆序遍历，否则会被覆盖
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        
        System.out.println(f[m]);

        sc.close();
    }
}
