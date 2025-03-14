import java.util.*;

public class AC291 {
    final static int N = 12;
    final static int M = 1 << N;
    static long f[][] = new long[N][M];
    static boolean st[] = new boolean[M];
    static List<List<Integer>> valid = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isFinish = false;

        while (!isFinish) {
            int n = sc.nextInt(), m = sc.nextInt();

            if(n == 0 && m == 0)
                isFinish = true;
            else {
                Arrays.fill(st, true);
                // 计算两方案是否冲突
                for (int i = 0; i < 1 << n; i++) {
                    int cnt = 0;

                    for (int j = 0; j < n; j++) {
                        if ((i >> j & 1) == 1) {
                            if (cnt % 2 == 1)
                                st[i] = false;

                            cnt = 0;
                        } else
                            cnt++;
                    }

                    if (cnt % 2 == 1)
                        st[i] = false;
                }
                // 计算方案i的有效方案j
                valid.clear();

                for (int i = 0; i < 1 << n; i++) {
                    List<Integer> list = new LinkedList<>();

                    for (int j = 0; j < 1 << n; j++) {
                        if (((i & j) == 0) && st[i | j])
                            list.add(j);
                    }

                    valid.add(list);
                }
                // DP
                for(int i = 0; i < N; i++)
                    Arrays.fill(f[i], 0);

                f[0][0] = 1;    

                for (int i = 1; i <= m; i++) {
                    for (int j = 0; j < 1 << n; j++) {
                        for (int k : valid.get(j))
                            f[i][j] += f[i - 1][k];
                    }
                }

                System.out.println(f[m][0]);                    
            }
        }

        sc.close();
    }
}
