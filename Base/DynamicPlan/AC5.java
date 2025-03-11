package Base.DynamicPlan;

import java.util.*;

public class AC5 {
    final static int N = 25000;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];
    // 二进制优化版 多重背包 O(NV log S)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), s = sc.nextInt(), k = 1;

            while (k <= s) {
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k *= 2;
            }

            if (s > 0) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }
        

        for (int i = 1; i <= cnt; i++) {
            for (int j = m; j >= v[i]; j--)
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
        }
        
        System.out.println(f[m]);

        sc.close();
    }
}
